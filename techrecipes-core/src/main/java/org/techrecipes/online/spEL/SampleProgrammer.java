package org.techrecipes.online.spEL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
/**
 * Created by sathishjayapal on 12/30/17.
 */
public class SampleProgrammer {
    final static Logger logger = LoggerFactory.getLogger(SampleProgrammer.class);
    public String name;
    public String occupation;
    @Autowired
    SampleProgrammer(String name, String occupation) {
        this.name = name;
        this.occupation = occupation;
    }
    public String getValueOfName() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression nameExpression = expressionParser.parseExpression("name");
        String data = (String) nameExpression.getValue(this);
        if (logger.isDebugEnabled()) {
            logger.debug("Context Name is " + data);
        }
        return data;
    }
    public String getValueOfOccupation() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression nameExpression = expressionParser.parseExpression("occupation");
        String data = (String) nameExpression.getValue(this);
        if (logger.isDebugEnabled()) {
            logger.debug("Context Occupation is " + data);
        }
        return data;
    }
}

