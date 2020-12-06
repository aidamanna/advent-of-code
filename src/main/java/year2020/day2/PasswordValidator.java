package year2020.day2;

import java.util.Arrays;

public class PasswordValidator {

    private String rawPasswords;

    public PasswordValidator(String rawPasswords) {
        this.rawPasswords = rawPasswords;
    }

    public long count() {
        return Arrays.stream(rawPasswords.split("\n"))
                .map(PasswordWithPolicy::from)
                .filter(PasswordWithPolicy::isValid)
                .count();
    }
}
