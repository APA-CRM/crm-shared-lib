package com.crm.sharedlib.core.filter.criteria.interfaces;

import com.crm.sharedlib.core.dto.request.BaseFilterRequest;
import jakarta.persistence.EntityManager;

public interface CountableFilter<T> {
    Long countAll(
            BaseFilterRequest request,
            Class<T> entityClass,
            EntityManager entityManager,
            PredicateBuilder<T> predicateBuilder
    );
}
