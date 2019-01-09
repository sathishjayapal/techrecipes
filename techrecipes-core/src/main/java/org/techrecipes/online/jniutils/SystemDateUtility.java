package org.techrecipes.online.jniutils;

public class SystemDateUtility {
    static {
        System.loadLibrary("nativedatetimeutils");
    }
    public native String getSystemTime();
    public String loadThisSystemDateTime(){
        return null;
    }
}
