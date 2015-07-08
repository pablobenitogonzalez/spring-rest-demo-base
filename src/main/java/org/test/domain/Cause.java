package org.test.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code", "cause" }))
@SuppressWarnings("unused")
public class Cause extends Domain {

    private static Log logger = LogFactory.getLog(Cause.class);

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
    @JoinColumn(name = "code")
    private ErrorInfo errorInfo;
    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }
    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    @NotNull
    private String cause;
    public String getCause() {
        return cause;
    }
    public void setCause(String cause) {
        this.cause = cause;
    }

    public Cause() {}

    public Cause(ErrorInfo errorInfo, String cause) {
        logger.info("New object " + Cause.class);
        this.errorInfo = errorInfo;
        this.cause = cause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cause cause1 = (Cause) o;

        if (!errorInfo.equals(cause1.errorInfo)) return false;
        return cause.equals(cause1.cause);

    }

    @Override
    public int hashCode() {
        int result = errorInfo.hashCode();
        result = 31 * result + cause.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cause{" +
                "id=" + id +
                ", code=" + errorInfo.getCode() +
                ", cause='" + cause + '\'' +
                '}';
    }
}
