package com.crm.sharedlib.core.filter.criteria.interfaces;

import jakarta.persistence.criteria.Root;

@FunctionalInterface
public interface JoinApplier<T> {

    static <T> JoinApplier<T> defaultJoinApplier() {
        return root -> {
        };
    }

    void applyJoin(Root<T> root);

}
