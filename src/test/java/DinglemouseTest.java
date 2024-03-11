
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DinglemouseTest {

    private static void printHelp(int[] result) {
        System.out.println(Arrays.toString(result));
    }

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
        assertArrayEquals(new int[]{0, 1, 2, 0}, result);

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
        assertArrayEquals(new int[]{0, 2, 3, 0}, result);

    }

    @Test
    void OnePeopleGoFrom3FloorTo2Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);

        assertArrayEquals(new int[]{0, 3, 2, 0}, result);

    }

    @Test
    void OnePeopleFrom0To1FloorSecond2To3() {

        final int[][] queues = {
                new int[]{1},
                new int[0],
                new int[]{3},
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 1, 2, 3, 0}, result);

    }

    @Test
    void OnePeopleFrom3To2FloorSecond1ToGround() {

        final int[][] queues = {
                new int[0],
                new int[]{0},
                new int[0],
                new int[]{2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 3, 2, 1, 0}, result);

    }

    @Test
    void OnePeopleFrom1ToGroundSecond2To1ThirdFrom4To2Test() {

        final int[][] queues = {
                new int[0],
                new int[]{0},
                new int[]{1},
                new int[0],
                new int[]{2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);

        assertArrayEquals(new int[]{0, 4, 2, 1, 0}, result);

    }

    @Test
    void OnePeopleFrom0To3FloorSecond4To2Test() {

        final int[][] queues = {
                new int[]{3},
                new int[0],
                new int[0],
                new int[0],
                new int[]{2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);

        assertArrayEquals(new int[]{0, 3, 4, 2, 0}, result);

    }

    @Test
    void OneFrom1To4Second3ToGroundTest() {

        final int[][] queues = {
                new int[0],
                new int[]{4},
                new int[0],
                new int[]{0},
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);

        assertArrayEquals(new int[]{0, 1, 4, 3, 0}, result);

    }

    @Test
    void OneFrom0To2Second2To4ThreeFrom4To1() {

        final int[][] queues = {
                new int[]{2},
                new int[0],
                new int[]{4},
                new int[0],
                new int[]{1}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 2, 4, 1, 0}, result);

    }

    @Test
    void OneFrom0To3Second1To2() {

        final int[][] queues = {
                new int[]{3},
                new int[]{2},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 1, 2, 3, 0}, result);
    }

    @Test
    void OneFrom4To3Second3To2() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{2},
                new int[]{3}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 4, 3, 2, 0}, result);
    }

}
