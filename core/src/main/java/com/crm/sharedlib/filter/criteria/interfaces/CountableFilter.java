package com.crm.sharedlib.filter.criteria.interfaces;

import com.crm.sharedlib.dto.request.BaseFilterRequest;
import jakarta.persistence.EntityManager;

public interface CountableFilter<T> {
    Long countAll(
            BaseFilterRequest request,
            Class<T> entityClass,
            EntityManager entityManager,
            PredicateBuilder<T> predicateBuilder
    );
}
