package org.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.demo.domain.ErrorInfo;
import org.demo.exception.ResourceNotFoundException;
import org.demo.repository.ErrorInfoRepository;

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
