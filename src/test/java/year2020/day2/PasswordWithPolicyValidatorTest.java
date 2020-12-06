package year2020.day2;

import org.junit.jupiter.api.Test;
import year2020.day2.PasswordValidator;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordWithPolicyValidatorTest {

    @Test
    void returnsNumberOfValidPasswords() {
        String passwords = "1-3 a: abcde\n" +
                "1-3 b: cdefg\n" +
                "2-9 c: ccccccccc";
        PasswordValidator passwordValidator = new PasswordValidator(passwords);

        assertEquals(1, passwordValidator.count());
    }
}
