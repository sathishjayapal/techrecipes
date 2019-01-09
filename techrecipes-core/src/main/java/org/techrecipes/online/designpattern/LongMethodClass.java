package org.techrecipes.online.designpattern;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Compose method pattern.
 * Intially when the method started for this class. checkAndChangeObject was doing the operation
 * of checking if incoming object is a string/integer/float/other. After the determination, same method was
 * doing the operation for a String and an Integer. Now following compose method pattern, we broke the long
 * method and applied "SLAP" principle to isolate and do one operation for each object type.
 */
public class LongMethodClass {
    public static final String SA = "Sa";
    public static final String ME = "Me";
    public static final String DA = "Da";
    Logger logger = LoggerFactory.getLogger(LongMethodClass.class);
    public <T extends Object> T checkAndChangeObject(Object inputData) {
        logger.debug("Starting the checkMyNameStartsWithSa");
        Object returnObject = (T) Boolean.FALSE;
        if (inputData instanceof String) {
            returnObject = changeObjectString((String) inputData);
        } else if (inputData instanceof Integer) {
            returnObject = changeObjectInt((Integer) inputData);
        } else if (inputData instanceof Float) {
            logger.debug("Identified object as Float");
            returnObject = Float.valueOf((Float) inputData);
        } else {
            logger.debug("Unable to determine the object type");
        }
        logger.debug("Ending the checkMyStartsWithSa");
        return (T) returnObject;
    }
    private Integer changeObjectInt(Integer inputData) {
        logger.debug("Indetified object as Integer");
        Integer covertedInteger = inputData;
        if (Math.floorMod(inputData, 5) == 0) {
            System.out.println("The number is a multiple of 5");
            covertedInteger = inputData + Math.incrementExact(5);
        }
        if (Math.floorMod(inputData, 2) == 0) {
            System.out.println("The number is a multiple of 2 and is an even number");
            covertedInteger = inputData + Math.incrementExact(2);
        }
        return covertedInteger;
    }
    private String changeObjectString(String inputData) {
        String convertedData = inputData;
        logger.debug("Indetified object as String");
        if (StringUtils.startsWith(convertedData, SA)) {
            logger.debug("The input is starting with Sa ");
            System.out.println("The converted string is " + StringUtils.replace(convertedData, SA, ME));
            convertedData = StringUtils.replace(convertedData, SA, ME);
        } else if (StringUtils.startsWith(convertedData, DA)) {
            logger.debug("The input is starting with Da ");
            System.out.println("The converted string is " + StringUtils.replace(convertedData, DA, ME));
            convertedData = StringUtils.replace(convertedData, DA, ME);
        }
        return convertedData;
    }
}
