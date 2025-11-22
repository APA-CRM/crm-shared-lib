package com.crm.sharedlib.utils;

import com.crm.sharedlib.dto.DateRange;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.experimental.UtilityClass;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.util.StringUtils.hasText;

@UtilityClass
public class PredicateFilterUtils {

    public static void filterByDateRange(
            DateRange dateRange,
            String fieldName,
            List<Predicate> predicates,
            CriteriaBuilder builder,
            Root<?> root
    ) {
        if (isNull(dateRange) ||
                (isNull(dateRange.getTo()) && isNull(dateRange.getFrom()))
        ) {
            return;
        }

        if (nonNull(dateRange.getFrom()) && nonNull(dateRange.getTo())) {
            predicates.add(
                    builder.and(
                            builder.greaterThan(root.get(fieldName), dateRange.getFrom()),
                            builder.lessThan(root.get(fieldName), dateRange.getTo())
                    )
            );
        } else if (nonNull(dateRange.getFrom())) {
            predicates.add(
                    builder.greaterThan(
                            root.get(fieldName), dateRange.getFrom()
                    )
            );
        } else {
            predicates.add(
                    builder.greaterThan(
                            root.get(fieldName), dateRange.getFrom()
                    )
            );
        }
    }

    public static void filterBySymbolContains(
            String value,
            String fieldName,
            List<Predicate> predicates,
            CriteriaBuilder builder,
            Root<?> root
    ) {
        if (!hasText(value)) {
            return;
        }

        predicates.add(
                builder.like(
                        root.get(fieldName), "%" + value + "%"
                )
        );
    }

}
