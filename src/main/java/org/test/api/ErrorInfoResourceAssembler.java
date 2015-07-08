package org.test.api;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.test.domain.Cause;
import org.test.domain.ErrorInfo;
import org.test.domain.Solution;

import java.util.stream.Collectors;

@Component
@SuppressWarnings("unused")
public class ErrorInfoResourceAssembler extends ResourceAssemblerSupport<ErrorInfo, ErrorInfoResource> {

    public ErrorInfoResourceAssembler() {
        super(ErrorInfoController.class, ErrorInfoResource.class);
    }

    @Override
    public ErrorInfoResource toResource(ErrorInfo errorInfo) {
        ErrorInfoResource resource = createResourceWithId(errorInfo.getCode(), errorInfo);
        return resource;
    }

    @Override
    protected ErrorInfoResource instantiateResource(ErrorInfo errorInfo) {
        ErrorInfoResource errorInfoResource = new ErrorInfoResource();
        errorInfoResource.code = errorInfo.getCode();
        errorInfoResource.title = errorInfo.getTitle();
        errorInfoResource.description = errorInfo.getDescription();
        errorInfoResource.causes = errorInfo.getCauses().stream().map(Cause::getCause).collect(Collectors.toList());
        errorInfoResource.solutions = errorInfo.getSolutions().stream().map(Solution::getSolution).collect(Collectors.toList());
        return errorInfoResource;
    }
}
