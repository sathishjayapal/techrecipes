package org.techrecipes.online.references;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by sathishjayapal on 6/5/16.
 */
public class UserInformationValidator {
    private static final String User_Name_Matcher = "^[A-Za-z0-9_]{3,15}$";
    private Pattern pattern;
    private Matcher matcher;
    public UserInformationValidator() {
        pattern = Pattern.compile(User_Name_Matcher);
    }
    public boolean validate(String userName) {
        matcher = pattern.matcher(userName);
        return matcher.matches();
    }
}
