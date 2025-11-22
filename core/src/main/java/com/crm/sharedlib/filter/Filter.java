package com.crm.sharedlib.filter;

import com.crm.sharedlib.dto.request.BaseFilterRequest;
import org.springframework.data.domain.PageImpl;

public interface Filter<T> {
    PageImpl<T> filter(BaseFilterRequest request);
}
