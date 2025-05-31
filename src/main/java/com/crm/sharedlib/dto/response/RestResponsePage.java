package com.crm.sharedlib.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedModel;

import java.io.Serial;
import java.util.List;

public class RestResponsePage<T> extends PagedModel<T> {

    @Serial
    private static final long serialVersionUID = 3248189030448292002L;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RestResponsePage(
            @JsonProperty("content") List<T> content,
            @JsonProperty("page") JsonNode page
    ) {
        super(
                new PageImpl<>(
                        content,
                        PageRequest.of(
                                page.path("number").asInt(),
                                page.path("size").asInt() == 0 ? 1 : page.path("size").asInt()
                        ),
                        page.path("totalElements").asInt()
                )
        );
    }

}
