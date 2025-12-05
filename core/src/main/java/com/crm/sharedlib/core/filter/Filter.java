package com.crm.sharedlib.core.filter;

import com.crm.sharedlib.core.dto.request.BaseFilterRequest;
import org.springframework.data.domain.PageImpl;

public interface Filter<T> {
    PageImpl<T> filter(BaseFilterRequest request);
}
