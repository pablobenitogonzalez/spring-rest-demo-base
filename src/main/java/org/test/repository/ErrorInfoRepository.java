package org.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.test.domain.ErrorInfo;

import java.util.List;

@SuppressWarnings("unused")
public interface ErrorInfoRepository extends JpaRepository<ErrorInfo, Long> {

    @Query ("select e from ErrorInfo e order by e.code")
    List<ErrorInfo> findAllOrderByCode();

    ErrorInfo findByCode(String code);

}
