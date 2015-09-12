package org.demo.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (uniqueConstraints = @UniqueConstraint (columnNames = { "code" }))
@SuppressWarnings("unused")
public class ErrorInfo extends Domain {

    private static Log logger = LogFactory.getLog(ErrorInfo.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    private String code;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @NotNull
    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany (mappedBy = "errorInfo", fetch = FetchType.EAGER)
    private Set<ErrorCause> errorCauses = new HashSet<>();
    public Set<ErrorCause> getErrorCauses() {
        return errorCauses;
    }
    public void setErrorCauses(Set<ErrorCause> errorCauses) {
        this.errorCauses = errorCauses;
    }

    @OneToMany (mappedBy = "errorInfo", fetch = FetchType.EAGER)
    private Set<ErrorSolution> errorSolutions = new HashSet<>();
    public Set<ErrorSolution> getErrorSolutions() {
        return errorSolutions;
    }
    public void setErrorSolutions(Set<ErrorSolution> errorSolutions) {
        this.errorSolutions = errorSolutions;
    }

    public ErrorInfo() {}

    public ErrorInfo(String code, String title, String description) {
        logger.info("New object " + ErrorInfo.class);
        this.code = code;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorInfo errorInfo = (ErrorInfo) o;

        return code.equals(errorInfo.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
