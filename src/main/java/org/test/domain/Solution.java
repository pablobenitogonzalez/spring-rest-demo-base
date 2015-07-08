package org.test.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code", "solution" }))
@SuppressWarnings("unused")
public class Solution extends Domain {

    private static Log logger = LogFactory.getLog(Solution.class);

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
    private String solution;
    public String getSolution() {
        return solution;
    }
    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Solution() {}

    public Solution(ErrorInfo errorInfo, String solution) {
        logger.info("New object " + Solution.class);
        this.errorInfo = errorInfo;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution1 = (Solution) o;

        if (!errorInfo.equals(solution1.errorInfo)) return false;
        return solution.equals(solution1.solution);

    }

    @Override
    public int hashCode() {
        int result = errorInfo.hashCode();
        result = 31 * result + solution.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ", code=" + errorInfo.getCode() +
                ", solution='" + solution + '\'' +
                '}';
    }
}
