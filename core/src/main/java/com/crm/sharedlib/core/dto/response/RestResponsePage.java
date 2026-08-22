package com.crm.sharedlib.core.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedModel;
import tools.jackson.databind.JsonNode;

import java.util.List;

public class RestResponsePage<T> extends PagedModel<T> {

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
