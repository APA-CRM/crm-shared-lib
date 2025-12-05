package com.crm.sharedlib.core.filter.criteria.impl;

import com.crm.sharedlib.core.dto.request.BaseFilterRequest;
import com.crm.sharedlib.core.filter.criteria.interfaces.PageableBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.springframework.util.StringUtils.hasText;

public class DefaultPageableFilter implements PageableBuilder {

    @Override
    public Pageable buildPageable(BaseFilterRequest request, String sortFieldName) {
        return PageRequest.of(request.getPage(), request.getSize(),
                getSortBy(request, sortFieldName)
        );
    }

    private Sort getSortBy(BaseFilterRequest request, String sortFieldName) {
        Sort.Direction direction = Sort.Direction.valueOf(request.getSortDirection().name());
        String sortBy = hasText(request.getSortBy())
                ? request.getSortBy() : sortFieldName;

        return Sort.by(direction, sortBy);
    }

}
