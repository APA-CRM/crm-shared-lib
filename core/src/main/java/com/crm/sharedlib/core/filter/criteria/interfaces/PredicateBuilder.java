package com.crm.sharedlib.core.filter.criteria.interfaces;

import com.crm.sharedlib.core.dto.request.BaseFilterRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public interface PredicateBuilder<T> {
    List<Predicate> buildPredicates(
            BaseFilterRequest request,
            CriteriaBuilder builder,
            Root<T> root
    );
}
