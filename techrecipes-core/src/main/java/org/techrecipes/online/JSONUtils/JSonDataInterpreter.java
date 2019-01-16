package org.techrecipes.online.JSONUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JSonDataInterpreter {
    Logger LOG = LoggerFactory.getLogger(JSonDataInterpreter.class);

    public void serializerFor() {
        String json = "{\"name\":\"Frank\",\"id\":5000}";
        Employee nameOfEmployee = null;
        try {
            nameOfEmployee = new ObjectMapper().readValue(json, Employee.class);
            System.out.println("The name of Employee\t" + nameOfEmployee.toString());
        } catch (IOException e) {
            LOG.error("JSON Object mapping exception", e);
        }

    }
}
