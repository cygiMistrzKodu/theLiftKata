//import org.junit.Test;
//import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DinglemouseTest {
    @Test
    void noPeopleToEnterThenLiftStayOnGroundFloor() {

        final int[][] queues = {
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0}, result);

    }

    @Test
    void OnePeopleGoOn1Flor() {

        final int[][] queues = {
                new int[]{1},
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0,1,0}, result);

    }

    @Test
    void OnePeopleGoOn2Flor() {

        final int[][] queues = {
                new int[]{2},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0,2,0}, result);

    }

    @Test
    void OnePeopleGoOn1FloorIn3StoryBuilding() {

        final int[][] queues = {
                new int[]{1},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0,1,0}, result);

    }

    @Test
    void OnePeopleGoOn2FloorIn4StoryBuilding() {

        final int[][] queues = {
                new int[]{2},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0,2,0}, result);

    }

    @Test
    void OnePeopleGoOn3FloorIn4StoryBuilding() {

        final int[][] queues = {
                new int[]{3},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0,3,0}, result);

    }



}
