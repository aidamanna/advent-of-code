package year2020.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EncodedNumbers {

    private int preamble;

    public EncodedNumbers(int preamble) {
        this.preamble = preamble;
    }

    public Long getWeakness(String rawEncodedNumbers) {
        List<Long> encodedNumbers = Arrays.asList(rawEncodedNumbers.split("\n")).stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());

        for (int i = preamble; i < encodedNumbers.size(); i++) {
            List<Long> preambleNumbers = List.copyOf(encodedNumbers.subList(i - preamble, i));
            List<Long> sortedPreambleNumbers = preambleNumbers.stream().sorted().collect(Collectors.toList());

            if (!isNumberSumOfPreambles(sortedPreambleNumbers, preamble, encodedNumbers.get(i))) {
                return encodedNumbers.get(i);
            }
        }

        return 0L;
    }

    private boolean isNumberSumOfPreambles(List<Long> preambleNumbers, int preamble, long sum) {
        int leftIndex = 0;
        int rightIndex = preamble - 1;

        while(rightIndex > leftIndex) {
            if (preambleNumbers.get(leftIndex) + preambleNumbers.get(rightIndex) == sum) {
                return true;
            }

            if (preambleNumbers.get(leftIndex) + preambleNumbers.get(rightIndex) < sum) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return false;
    }
}
