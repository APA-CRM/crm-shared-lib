package com.crm.sharedlib.core.filter.criteria.interfaces;

import com.crm.sharedlib.core.dto.request.BaseFilterRequest;
import org.springframework.data.domain.Pageable;

public interface PageableBuilder {
    Pageable buildPageable(BaseFilterRequest request, String sortFieldName);
}
