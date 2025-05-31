package com.crm.sharedlib.filter.criteria.impl;

import com.crm.sharedlib.dto.request.BaseFilterRequest;
import com.crm.sharedlib.filter.criteria.interfaces.CountableFilter;
import com.crm.sharedlib.filter.criteria.interfaces.PredicateBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class DefaultCountableFilter<T> implements CountableFilter<T> {

    @Override
    public Long countAll(
            BaseFilterRequest request,
            Class<T> entityClass,
            EntityManager entityManager,
            PredicateBuilder<T> predicateBuilder
    ) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<T> root = query.from(entityClass);

        List<Predicate> predicates =
                predicateBuilder.buildPredicates(request, builder, root);

        query.select(builder.count(root))
                .where(predicates.toArray(Predicate[]::new));

        return entityManager.createQuery(query)
                .getSingleResult();
    }

}
