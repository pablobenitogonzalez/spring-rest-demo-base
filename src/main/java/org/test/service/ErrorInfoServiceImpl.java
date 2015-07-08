package org.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.test.domain.Category;
import org.test.domain.ErrorInfo;
import org.test.exception.ResourceNotFoundException;
import org.test.repository.CategoryRepository;
import org.test.repository.ErrorInfoRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class ErrorInfoServiceImpl implements ErrorInfoService {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ErrorInfoRepository errorInfoRepository;

    public ErrorInfo getErrorInfo(String code) {
        if(code == null) {
            throw new IllegalArgumentException(messageService.getMessage("org.test.demo.message.errorInfo.code.null"));
        }
        ErrorInfo errorInfo = errorInfoRepository.findByCode(code);
        if(errorInfo == null) {
            throw new ResourceNotFoundException(messageService.getMessage("org.test.demo.message.errorInfo.not.found", new Object[]{code}));
        }
        return errorInfo;
    }

    public List<ErrorInfo> getAllErrorInfo() {
        return errorInfoRepository.findAllOrderByCode();
    }
}
