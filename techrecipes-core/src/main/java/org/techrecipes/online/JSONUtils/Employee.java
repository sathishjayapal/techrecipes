package org.techrecipes.online.JSONUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class Employee {
    private final long id;
    private final String empName;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Employee(@JsonProperty("id") long id, @JsonProperty("empName") String empName) {
        this.id = id;
        this.empName = empName;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }

    public long getId() {
        return id;
    }

    public String getEmpName() {
        return empName;
    }
}
