package com.crm.sharedlib.filter.criteria;

import com.crm.sharedlib.dto.request.BaseFilterRequest;
import com.crm.sharedlib.filter.Filter;
import com.crm.sharedlib.filter.criteria.interfaces.CountableFilter;
import com.crm.sharedlib.filter.criteria.interfaces.OrderByApplier;
import com.crm.sharedlib.filter.criteria.interfaces.PageableBuilder;
import com.crm.sharedlib.filter.criteria.interfaces.PredicateBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class BaseCriteriaFilter<T> implements Filter<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected abstract Class<T> getEntityClass();

    protected abstract String getDefaultSortField();

    protected abstract PredicateBuilder<T> getPredicateBuilder();

    protected abstract CountableFilter<T> getCountableFilter();

    protected abstract PageableBuilder getPageableBuilder();

    protected abstract OrderByApplier<T> getOrderByApplier();

    @Override
    public PageImpl<T> filter(BaseFilterRequest request) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());
        Root<T> root = query.from(getEntityClass());

        List<Predicate> predicates =
                getPredicateBuilder().buildPredicates(request, builder, root);

        query.where(predicates.toArray(new Predicate[0]));

        getOrderByApplier().applyOrderBy(
                request, builder, query, root, getDefaultSortField()
        );

        Pageable pageable = getPageableBuilder().buildPageable(request, getDefaultSortField());

        List<T> resultList = this.getResultList(pageable, query);

        Long counted = getCountableFilter().countAll(
                request, getEntityClass(),
                entityManager, getPredicateBuilder()
        );

        return new PageImpl<>(resultList, pageable, counted);
    }

    private List<T> getResultList(
            Pageable pageable,
            CriteriaQuery<T> query
    ) {
        return entityManager.createQuery(query)
                .setMaxResults(pageable.getPageSize())
                .setFirstResult((int) pageable.getOffset())
                .getResultList();
    }

}
