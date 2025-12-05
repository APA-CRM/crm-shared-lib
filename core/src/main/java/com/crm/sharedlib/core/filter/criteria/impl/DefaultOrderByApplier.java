package com.crm.sharedlib.core.filter.criteria.impl;

import com.crm.sharedlib.core.dto.request.BaseFilterRequest;
import com.crm.sharedlib.core.enums.SortDirections;
import com.crm.sharedlib.core.filter.criteria.interfaces.OrderByApplier;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import static org.springframework.util.StringUtils.hasText;

public class DefaultOrderByApplier<T> implements OrderByApplier<T> {

    @Override
    public void applyOrderBy(
            BaseFilterRequest request,
            CriteriaBuilder builder,
            CriteriaQuery<T> query,
            Root<T> root,
            String sortFieldName
    ) {
        final String sortBy = hasText(request.getSortBy())
                ? request.getSortBy() : sortFieldName;

        if (request.getSortDirection() == SortDirections.ASC) {
            query.orderBy(builder.asc(root.get(sortBy)));
        } else {
            query.orderBy(builder.desc(root.get(sortBy)));
        }
    }
}
