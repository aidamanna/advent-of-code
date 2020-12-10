package year2020.day9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EncodedNumbers {

    private int preamble;

    public EncodedNumbers(int preamble) {
        this.preamble = preamble;
    }

    public Long getEncryptionWeakness(String rawEncodedNumbers) {
        Long weakNumber = getWeakNumber(rawEncodedNumbers);

        List<Long> encodedNumbers = getEncodedNumbers(rawEncodedNumbers);

        int leftIndex = 0;
        int rightIndex = 1;

        while (rightIndex > leftIndex) {
            if (encodedNumbers.subList(leftIndex, rightIndex + 1).stream().reduce(0L, Long::sum) == weakNumber) {
                return Collections.max(encodedNumbers.subList(leftIndex, rightIndex + 1)) + Collections.min(encodedNumbers.subList(leftIndex, rightIndex + 1));
            }

            if (encodedNumbers.subList(leftIndex, rightIndex + 1).stream().reduce(0L, Long::sum) < weakNumber) {
                rightIndex++;
            } else {
                leftIndex++;
            }
        }



        return 0L;
    }

    public Long getWeakNumber(String rawEncodedNumbers) {
        List<Long> encodedNumbers = getEncodedNumbers(rawEncodedNumbers);

        for (int i = preamble; i < encodedNumbers.size(); i++) {
            List<Long> preambleNumbers = List.copyOf(encodedNumbers.subList(i - preamble, i));
            List<Long> sortedPreambleNumbers = preambleNumbers.stream().sorted().collect(Collectors.toList());

            if (!isNumberSumOfPreambles(sortedPreambleNumbers, preamble, encodedNumbers.get(i))) {
                return encodedNumbers.get(i);
            }
        }

        return 0L;
    }

    private List<Long> getEncodedNumbers(String rawEncodedNumbers) {
        return Arrays.asList(rawEncodedNumbers.split("\n")).stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
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
