
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DinglemouseTest {
    @Test
    void noPeopleToEnterThenLiftStayOnGroundFloor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0}, result);

    }
    @Test
    void OnePeopleGoOn1Flor() {

        final int[][] queues = {
                new int[]{1},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 1, 0}, result);

    }

    @Test
    void OnePeopleGoOn2FloorFromGround() {

        final int[][] queues = {
                new int[]{2},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 2, 0}, result);

    }
    @Test
    void OnePeopleGoOn3FloorFromGround() {

        final int[][] queues = {
                new int[]{3},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 3, 0}, result);

    }
    @Test
    void OnePeopleGoOn2FloorFromFirstFloor() {

        final int[][] queues = {
                new int[0],
                new int[]{2},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0,1, 2, 0}, result);

    }

    @Test
    void OnePeopleGoOn3FloorFrom2Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{3},
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0,2, 3, 0}, result);

    }



}
