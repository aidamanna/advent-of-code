package year2020.day5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoardingPass {

    public Optional<Integer> findMissingSeatId(String rawBinarySpacePartitions) {
        List<Integer> seatIds = Arrays.asList(rawBinarySpacePartitions.split("\n"))
            .stream()
            .map(this::seatId)
            .collect(Collectors.toList());

        boolean firstSeatFound = false;

        for (int i = 1; i < 1032; i++) {
            if(seatIds.contains(i)) {
                firstSeatFound = true;
            }

            if (!seatIds.contains(i) && firstSeatFound) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }
    public int seatId(String binarySpacePartitioning) {
        String encodedBinaryRow = binarySpacePartitioning.substring(0, 7);
        String encodedBinarySeat = binarySpacePartitioning.substring(7);

        String binaryRow = decode(encodedBinaryRow, 'F', 'B');
        String binarySeat = decode(encodedBinarySeat, 'L', 'R');

        int row = Integer.parseInt(binaryRow, 2);
        int seat = Integer.parseInt(binarySeat, 2);


        return row * 8 + seat;
    }

    public int getHighestSeatId(String rawBinarySpacePartitions) {
        return Arrays.asList(rawBinarySpacePartitions.split("\n"))
            .stream()
            .map(this::seatId)
            .max(Comparator.naturalOrder()).get();
    }

    private String decode(String encodedValue, char encodedZero, char encodedOne) {
        return encodedValue
            .replace(encodedZero, '0')
            .replace(encodedOne, '1');
    }
}
