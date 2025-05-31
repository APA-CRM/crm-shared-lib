package com.crm.sharedlib.filter.criteria.interfaces;

import com.crm.sharedlib.dto.request.BaseFilterRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public interface OrderByApplier<T> {

    void applyOrderBy(
            BaseFilterRequest request,
            CriteriaBuilder builder,
            CriteriaQuery<T> query,
            Root<T> root,
            String defaultSortField
    );

}
