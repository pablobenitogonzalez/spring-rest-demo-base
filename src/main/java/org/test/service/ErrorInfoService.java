package org.test.service;

import org.test.domain.ErrorInfo;

import java.util.List;

@SuppressWarnings("unused")
public interface ErrorInfoService {
    ErrorInfo getErrorInfo(String code);
    List<ErrorInfo> getAllErrorInfo();
}
