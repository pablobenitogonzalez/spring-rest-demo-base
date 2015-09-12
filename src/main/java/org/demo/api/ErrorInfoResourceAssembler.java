package org.demo.api;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.demo.domain.ErrorCause;
import org.demo.domain.ErrorInfo;
import org.demo.domain.ErrorSolution;

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
        errorInfoResource.causes = errorInfo.getErrorCauses().stream().map(ErrorCause::getCause).collect(Collectors.toList());
        errorInfoResource.solutions = errorInfo.getErrorSolutions().stream().map(ErrorSolution::getSolution).collect(Collectors.toList());
        return errorInfoResource;
    }
}
