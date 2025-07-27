package validator;

import java.util.regex.Pattern;

public class NameValidator {
    
    private static final String NAMA_PATTERN = "^[A-Za-z\\s]+$"; // Hanya huruf dan spasi
    private final Pattern pattern;

    public NameValidator() {
        pattern = Pattern.compile(NAMA_PATTERN);
    }

    public boolean validate(String nama) {
        return pattern.matcher(nama).matches();
    }
}
