package validator;

import java.util.regex.Pattern;

public class PasswordValidator {
    
    // Regex pattern for password validation
    private static final String PASSWORD_PATTERN = 
        "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{9,}$";

    public boolean isValidPassword(String password) {
        return Pattern.matches(PASSWORD_PATTERN, password);
    }
}