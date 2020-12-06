package year2020.day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class SlopeTest {

    @Test
    void calculatesNumberOfTreesInSlope() {
        String rawTreeMap = "..##.......\n"
            + "#...#...#..\n"
            + ".#....#..#.\n"
            + "..#.#...#.#\n"
            + ".#...##..#.\n"
            + "..#.##.....\n"
            + ".#.#.#....#\n"
            + ".#........#\n"
            + "#.##...#...\n"
            + "#...##....#\n"
            + ".#..#...#.#";

        Slope slope = new Slope(rawTreeMap);
        int rightMoves = 3;
        int downMoves = 1;

        assertEquals(7, slope.calculateTrees(rightMoves, downMoves));
    }

    @Test
    void calculatesSlopesRiskFactor() {
        String rawTreeMap = "..##.......\n"
            + "#...#...#..\n"
            + ".#....#..#.\n"
            + "..#.#...#.#\n"
            + ".#...##..#.\n"
            + "..#.##.....\n"
            + ".#.#.#....#\n"
            + ".#........#\n"
            + "#.##...#...\n"
            + "#...##....#\n"
            + ".#..#...#.#";

        List<List<Integer>> movements = List.of(List.of(1, 1),
            List.of(3,1),
            List.of(5, 1),
            List.of(7, 1),
            List.of(1, 2));

        Slope slope = new Slope(rawTreeMap);

        assertEquals(336, slope.calculateRiskFactor(movements));
    }
}