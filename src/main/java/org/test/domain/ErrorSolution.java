package org.test.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "error_info", "solution" }))
@SuppressWarnings("unused")
public class ErrorSolution extends Domain {

    private static Log logger = LogFactory.getLog(ErrorSolution.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "error_info")
    private ErrorInfo errorInfo;
    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }
    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    @NotNull
    private String solution;
    public String getSolution() {
        return solution;
    }
    public void setSolution(String solution) {
        this.solution = solution;
    }

    public ErrorSolution() {}

    public ErrorSolution(ErrorInfo errorInfo, String solution) {
        logger.info("New object " + ErrorSolution.class);
        this.errorInfo = errorInfo;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorSolution errorSolution1 = (ErrorSolution) o;

        if (!errorInfo.equals(errorSolution1.errorInfo)) return false;
        return solution.equals(errorSolution1.solution);

    }

    @Override
    public int hashCode() {
        int result = errorInfo.hashCode();
        result = 31 * result + solution.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ErrorSolution{" +
                "id=" + id +
                ", code=" + errorInfo.getCode() +
                ", solution='" + solution + '\'' +
                '}';
    }
}
