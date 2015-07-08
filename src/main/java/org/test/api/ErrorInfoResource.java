package org.test.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@SuppressWarnings("unused")
@JsonPropertyOrder({ "code", "title", "description", "causes", "solutions" })
public class ErrorInfoResource extends ResourceSupport {

    public String code;
    public String title;
    public String description;
    public List<String> causes;
    public List<String> solutions;

    public ErrorInfoResource() {}
}
