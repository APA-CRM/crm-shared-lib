package com.crm.sharedlib.filter.criteria.interfaces;

import com.crm.sharedlib.dto.request.BaseFilterRequest;
import org.springframework.data.domain.Pageable;

public interface PageableBuilder {
    Pageable buildPageable(BaseFilterRequest request, String sortFieldName);
}
