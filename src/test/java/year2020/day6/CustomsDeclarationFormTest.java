package year2020.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomsDeclarationFormTest {

    @Test
    void returnsCountOfCustomsDeclarationsFormAnswersForAnyoneYes() {
        String rawAnswers = "abc\n" +
                "\n" +
                "a\n" +
                "b\n" +
                "c\n" +
                "\n" +
                "ab\n" +
                "ac\n" +
                "\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "\n" +
                "b";

        CustomsDeclarationForm form = new CustomsDeclarationForm();

        assertEquals(11, form.getCountForAnyoneYes(rawAnswers));
    }

    @Test
    void returnsCountOfCustomsDeclarationsFormAnswersForEveryoneYes() {
        String rawAnswers = "abc\n" +
                "\n" +
                "a\n" +
                "b\n" +
                "c\n" +
                "\n" +
                "ab\n" +
                "ac\n" +
                "\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "a\n" +
                "\n" +
                "b";

        CustomsDeclarationForm form = new CustomsDeclarationForm();

        assertEquals(6, form.getCountForEveryoneYes(rawAnswers));
    }
}