package org.demo.service;

import org.demo.domain.ErrorInfo;

import java.util.List;

@SuppressWarnings("unused")
public interface ErrorInfoService {
    ErrorInfo getErrorInfo(String code);
    List<ErrorInfo> getAllErrorInfo();
}
