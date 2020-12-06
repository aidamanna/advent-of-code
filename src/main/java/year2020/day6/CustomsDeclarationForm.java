package year2020.day6;

import java.util.Arrays;

public class CustomsDeclarationForm {

    public long getCount(String rawAnswers) {
        return Arrays.asList(rawAnswers.split("\n\n")).stream()
                .map(groupAnswers -> groupAnswers.replace("\n", "").chars().distinct().count())
                .reduce(0L, Long::sum);
    }
}
