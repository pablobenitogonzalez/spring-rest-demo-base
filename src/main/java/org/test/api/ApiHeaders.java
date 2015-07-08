package org.test.api;

import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class ApiHeaders {

    public static HttpHeaders getCreatedResourceHttpHeaders(Class classController, Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        URI locationURI = linkTo(classController).slash(id).toUri();
        httpHeaders.setLocation((locationURI));
        return httpHeaders;
    }
}
