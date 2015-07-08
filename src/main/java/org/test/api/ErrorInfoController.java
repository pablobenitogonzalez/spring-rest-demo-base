package org.test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.test.service.ErrorInfoService;

import java.util.List;

@RestController
@RequestMapping(ApiController.ERRORS_URL)
@SuppressWarnings("unused")
public class ErrorInfoController {

    @Autowired
    private ErrorInfoService errorInfoService;

    @Autowired
    private ErrorInfoResourceAssembler errorInfoResourceAssembler;

    @RequestMapping (value = "/{code}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ErrorInfoResource getErrorInfo(@PathVariable String code) {
        return errorInfoResourceAssembler.toResource(errorInfoService.getErrorInfo(code));
    }

    @RequestMapping (method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ErrorInfoResource> getAllCategories() {
        return errorInfoResourceAssembler.toResources(errorInfoService.getAllErrorInfo());
    }

}
