
import org.junit.jupiter.api.Disabled;
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
        assertArrayEquals(new int[]{0, 1, 0}, result);

    }

    @Test
    void OnePeopleGoOn2Flor() {

        final int[][] queues = {
                new int[]{2},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 2, 0}, result);

    }

    @Test
    void OnePeopleGoOn1FloorIn3StoryBuilding() {

        final int[][] queues = {
                new int[]{1},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 1, 0}, result);

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
        assertArrayEquals(new int[]{0, 2, 0}, result);

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
        assertArrayEquals(new int[]{0, 3, 0}, result);

    }

    @Test
    void OnePeopleGoOn4FloorIn4StoryBuilding() {

        final int[][] queues = {
                new int[]{4},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 4, 0}, result);

    }

    @Test
    void OnePeopleGoOn5FloorIn5StoryBuilding() {

        final int[][] queues = {
                new int[]{5},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 5, 0}, result);

    }

    @Test
    void OnePeopleGoOn6FloorIn6StoryBuilding() {

        final int[][] queues = {
                new int[]{6},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 6, 0}, result);

    }

    @Test
    void OnePeopleGetIn1FloorAndGoToSecond() {

        final int[][] queues = {
                new int[0],
                new int[]{2},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 1, 2, 0}, result);

    }

    @Test
    void OnePeopleGetIn1FloorAndGoTo3Floor() {

        final int[][] queues = {
                new int[0],
                new int[]{3},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 1, 3, 0}, result);

    }

    @Test
    void OnePeopleGetIn1FloorAndGoTo4Floor() {

        final int[][] queues = {
                new int[0],
                new int[]{4},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 1, 4, 0}, result);

    }

    @Test
    void OnePeopleGetIn1FloorAndGoTo5Floor() {

        final int[][] queues = {
                new int[0],
                new int[]{5},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 1, 5, 0}, result);

    }

    @Test
    void OnePeopleGetIn2FloorAndGoTo3Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{3},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 2, 3, 0}, result);

    }

    @Test
    void OnePeopleGetIn2FloorAndGoTo4Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{4},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 2, 4, 0}, result);

    }

    @Test
    void OnePeopleGetIn3FloorAndGoTo5Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{5},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 3, 5, 0}, result);

    }

    @Test
    void OnePeopleGetIn3FloorAndGoTo6Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{6},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 3, 6, 0}, result);

    }

    @Test
    void OnePeopleWantGotFrom2FloorToFirstFlor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{1},
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 2, 1, 0}, result);

    }

    @Test
    void OnePeopleWantGotFrom3FloorTo2Flor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{2},
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 3, 2, 0}, result);

    }

    @Test
    void OnePeopleWantGotFrom3FloorTo1Flor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{1},
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 3, 1, 0}, result);

    }

    @Test
    void OnePeopleWantGotFrom2FloorToGround() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{0},
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 2, 0}, result);

    }

    @Test
    void OnePeopleWantGotFrom1FloorToGround() {

        final int[][] queues = {
                new int[0],
                new int[]{0},
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 1, 0}, result);

    }

    @Test
    void OnePeopleWantGotFrom3FloorToGround() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{0},
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 3, 0}, result);

    }

    @Test
    void OnePeopleWantGotFrom5FloorToGround() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{0},
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 5, 0}, result);

    }

    @Test
    void twoPeopleWantToGoFromGroundTo1Floor() {

        final int[][] queues = {
                new int[]{1, 1},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        assertArrayEquals(new int[]{0, 1, 0}, result);

    }

    @Test
    void twoPeopleWantToGoFrom3FlorToGround() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{0, 0},
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        assertArrayEquals(new int[]{0, 3, 0}, result);

    }

    @Test
    void OnePeopleWantTo1FloorSecondPeopleWantToGo2FloorFromGround() {

        final int[][] queues = {
                new int[]{1, 2},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        assertArrayEquals(new int[]{0, 1, 2, 0}, result);

    }

    @Test
    void OnePeopleWantTo4FloorSecondPeopleWantToGo5FromGround() {

        final int[][] queues = {
                new int[]{4, 5},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        assertArrayEquals(new int[]{0, 4, 5, 0}, result);

    }

    @Test
    void OnePeopleWantTo4FloorSecondPeopleWantToGo5FromFirstFloor() {

        final int[][] queues = {
                new int[0],
                new int[]{4, 5},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        assertArrayEquals(new int[]{0, 1, 4, 5, 0}, result);

    }

    @Test
    void OnePeopleWantTo4FloorSecondPeopleWantToGo6FromSecondFloor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{4, 6},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        assertArrayEquals(new int[]{0, 2, 4, 6, 0}, result);

    }

    @Test
    void OnePeopleWantTo1FloorSecondPeopleWantToGo1FloorFrom5Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{2, 1},
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        assertArrayEquals(new int[]{0, 5, 2, 1, 0}, result);

    }

    @Test
    void OnePeopleWantTo1FloorSecondPeopleWantToGo1FloorFrom5FloorReversDirectionInLift() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{1, 2},
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        assertArrayEquals(new int[]{0, 5, 2, 1, 0}, result);

    }

    @Test
    void threePeopleWantToGoToSame5FloorFromTheGround() {

        final int[][] queues = {
                new int[]{5, 5, 5},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        assertArrayEquals(new int[]{0, 5, 0}, result);

    }

    @Test
    void threePeopleWantToGoToFrom6FloorToTheGround() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{0, 0, 0},
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        assertArrayEquals(new int[]{0, 6, 0}, result);

    }

    @Test
    void threePeopleWantToGoToFrom3FloorTo2Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{2, 2, 2},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        assertArrayEquals(new int[]{0, 3, 2, 0}, result);

    }

    @Test
    void fromFloorOnePeopleTo2FloorFrom3floorOnePeopleTo4Floor() {

        final int[][] queues = {
                new int[0],
                new int[]{2},
                new int[0],
                new int[]{4},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 0}, result);

    }

    @Test
    void fromGroundOnePeopleTo2FloorFrom4floorOnePeopleTo5Floor() {

        final int[][] queues = {
                new int[]{2},
                new int[0],
                new int[0],
                new int[0],
                new int[]{5},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        assertArrayEquals(new int[]{0, 2, 4, 5, 0}, result);

    }

    @Test
    void from6FloorOnePeopleTo5FloorSecondPeopleFrom4to2() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{2},
                new int[0],
                new int[]{5}
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        assertArrayEquals(new int[]{0, 6, 5, 4, 2, 0}, result);

    }

    @Test
    void from5FloorOnePeopleTo3FloorSecondPeopleFrom2to1() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{1},
                new int[0],
                new int[0],
                new int[]{3},
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        assertArrayEquals(new int[]{0, 5, 3, 2, 1, 0}, result);

    }

    @Test
    void onePeopleGoFromUpDoDownFlorSecondFromDownToUpFloor() {

        final int[][] queues = {
                new int[]{4},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{3}
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        assertArrayEquals(new int[]{0, 4, 6, 3, 0}, result);

    }


}
