package year2020.day9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncodedNumbersTest {

    @Test
    void returnsTheFirstWeakNumber() {
        String rawEncodedNumbers = "35\n" +
                "20\n" +
                "15\n" +
                "25\n" +
                "47\n" +
                "40\n" +
                "62\n" +
                "55\n" +
                "65\n" +
                "95\n" +
                "102\n" +
                "117\n" +
                "150\n" +
                "182\n" +
                "127\n" +
                "219\n" +
                "299\n" +
                "277\n" +
                "309\n" +
                "576";

        EncodedNumbers encodedNumbers = new EncodedNumbers(5);

        assertEquals(127, encodedNumbers.getWeakNumber(rawEncodedNumbers));
    }

    @Test
    void returnsEncryptionWeakness() {
        String rawEncodedNumbers = "35\n" +
                "20\n" +
                "15\n" +
                "25\n" +
                "47\n" +
                "40\n" +
                "62\n" +
                "55\n" +
                "65\n" +
                "95\n" +
                "102\n" +
                "117\n" +
                "150\n" +
                "182\n" +
                "127\n" +
                "219\n" +
                "299\n" +
                "277\n" +
                "309\n" +
                "576";

        EncodedNumbers encodedNumbers = new EncodedNumbers(5);

        assertEquals(62, encodedNumbers.getEncryptionWeakness(rawEncodedNumbers));
    }
}