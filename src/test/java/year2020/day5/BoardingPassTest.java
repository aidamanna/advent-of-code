package year2020.day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardingPassTest {

    @Test
    void returnsTheSeatId() {
        BoardingPass boardingPass = new BoardingPass();

        assertEquals(357, boardingPass.seatId("FBFBBFFRLR"));
    }

    @Test
    void returnHighestSeatId() {
        BoardingPass boardingPass = new BoardingPass();
        String rawBinarySpacePartitions = "BFFFBBFRRR\n"
            + "FFFBBBFRRR\n"
            + "BBFFBBFRLL";

        assertEquals(820, boardingPass.getHighestSeatId(rawBinarySpacePartitions));
    }
}