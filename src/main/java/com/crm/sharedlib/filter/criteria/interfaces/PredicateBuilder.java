package com.crm.sharedlib.filter.criteria.interfaces;

import com.crm.sharedlib.dto.request.BaseFilterRequest;
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
