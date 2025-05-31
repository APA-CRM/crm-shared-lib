package com.crm.sharedlib.dto.request;

import com.crm.sharedlib.enums.SortDirections;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseFilterRequest {

    @NotNull(message = "Page can't be null")
    @PositiveOrZero(message = "Page can't be negative number")
    private Integer page;

    @NotNull(message = "Size can't be null")
    @Positive(message = "Size can't be negative or zero number")
    private Integer size;

    private SortDirections sortDirection = SortDirections.ASC;

    private String sortBy;

    @JsonIgnore
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Map<String, Object> additionalFields = new HashMap<>();

    public void addAdditionalField(String key, Object value) {
        this.additionalFields.put(key, value);
    }

    public <T> T getAdditionalField(String key, Class<T> type) {
        Object value = this.additionalFields.get(key);
        if (type.isInstance(value)) {
            return type.cast(value);
        }
        return null;
    }

}
