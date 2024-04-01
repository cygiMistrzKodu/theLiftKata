
import org.junit.jupiter.api.Disabled;
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
        printHelp(result);
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
        printHelp(result);
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
        printHelp(result);
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
        printHelp(result);
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
        printHelp(result);
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
    @Disabled
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
        printHelp(result);
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
        printHelp(result);
        assertArrayEquals(new int[]{0, 4, 3, 2, 0}, result);
    }

    @Test
    void OneFrom4To2Second3To1Test() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{1},
                new int[]{2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 4, 3, 2, 1, 0}, result);
    }

    @Test
    void OneFrom0To2SecondFrom1To2() {

        final int[][] queues = {
                new int[]{2},
                new int[]{2},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 1, 2, 0}, result);
    }

    @Test
    void OneFrom0To3SecondFrom1To3ThirdFrom2To3() {

        final int[][] queues = {
                new int[]{3},
                new int[]{3},
                new int[]{3},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 1, 2, 3, 0}, result);
    }

    @Test
    void OneFrom4To1SecondFrom3To1ThirdFrom2To1() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{1},
                new int[]{1},
                new int[]{1}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 4, 3, 2, 1, 0}, result);
    }

    @Test
    void somePeopleGoFromDownFlorAndSamFromUpFloorToTheSameFloor() {

        final int[][] queues = {
                new int[]{2},
                new int[]{2},
                new int[0],
                new int[]{2},
                new int[]{2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 1, 2, 4, 3, 2, 0}, result);
    }

    @Test
    @Disabled
    void somePeopleGoFromDownFlorAndSamFromUpFloorToTheSameFloorAndOnFromThisFloorGoToFirstFloor() {

        final int[][] queues = {
                new int[]{2},
                new int[]{2},
                new int[]{1},
                new int[]{2},
                new int[]{2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 1, 2, 4, 3, 2, 1, 0}, result);
    }

    @Test
    void allPeopleExceptGroundFloorWantToGoToGroundFromOthersFloors() {

        final int[][] queues = {
                new int[0],
                new int[]{0},
                new int[]{0},
                new int[]{0},
                new int[]{0}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 4, 3, 2, 1, 0}, result);
    }

    @Test
    @Disabled
    void mixCaseWithPeopleGoUpAndDown() {

        final int[][] queues = {
                new int[]{1},
                new int[]{0},
                new int[]{1},
                new int[]{4},
                new int[]{2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 1, 3, 4, 2, 1, 0}, result);
    }

    @Test
    void twoPeopleGoFromGroundTo1Floor() {

        final int[][] queues = {
                new int[]{1, 1},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 1, 0}, result);
    }

    @Test
    void twoPeopleGoFromGroundTo2Floor() {

        final int[][] queues = {
                new int[]{2, 2},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 2, 0}, result);
    }

    @Test
    void twoPeopleGoFromGroundTo1and2Floor() {

        final int[][] queues = {
                new int[]{1, 2},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 0}, result);
    }

    @Test
    void ThreePeopleGoFromGroundTo1and2and4Floor() {

        final int[][] queues = {
                new int[]{1, 2, 4},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 4, 0}, result);
    }

    @Test
    void twoPeopleGoFrom4To3Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{3, 3}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 4, 3, 0}, result);
    }

    @Test
    void twoPeopleGoFrom4ToGroundFloor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{0, 0}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 4, 0}, result);
    }

    @Test
    void twoPeopleGoFrom4To3and2Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{3, 2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 4, 3, 2, 0}, result);
    }

    @Test
    void threePeopleGoFrom4To2and1andGroundFloor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{2, 1, 0}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 4, 2, 1, 0}, result);
    }

    @Test
    void twoPeopleGoFromGroundTo1and2FloorTheOrderShouldNotMatter() {

        final int[][] queues = {
                new int[]{2, 1},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 1, 2, 0}, result);
    }

    @Test
    @Disabled
    void threePeopleGoFrom4To3and2FloorTheOrderShouldNotMatter() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{2, 3}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 4, 3, 2, 0}, result);
    }

    @Test
    @Disabled
    void twoPeopleGoFrom2FloorTo1And3Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{1, 3},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 2, 3, 2, 1, 0}, result);
    }

    @Test
    @Disabled
    void twoPeopleGoFrom2FloorTo1And3FloorInReverseOrder() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{3, 1},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        assertArrayEquals(new int[]{0, 2, 3, 2, 1, 0}, result);
    }

    @Test
    void twoPeopleFromFirstFloorTo3Floor() {

        final int[][] queues = {
                new int[0],
                new int[]{3, 3},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 15);
        assertArrayEquals(new int[]{0, 1, 3, 0}, result);
    }

    @Test
    void threePeopleFromFirstFloorTo3Floor() {

        final int[][] queues = {
                new int[0],
                new int[]{3, 3, 3},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 15);
        assertArrayEquals(new int[]{0, 1, 3, 0}, result);
    }

    @Test
    void threePeopleFromFirstFloorOneGoTo2Floor2GoTo3Floor() {

        final int[][] queues = {
                new int[0],
                new int[]{3, 3, 2},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 15);
        assertArrayEquals(new int[]{0, 1, 2, 3, 0}, result);
    }

    @Test
    void threePeopleFromThreeFloorTo1Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{1, 1, 1},
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 15);
        assertArrayEquals(new int[]{0, 3, 1, 0}, result);
    }

    @Test
    @Disabled
    void manyCasesTestWith3PersonOnEachFloor() {

        final int[][] queues = {
                new int[0],
                new int[]{3, 3, 3},
                new int[]{4, 0, 3},
                new int[]{0, 1, 4},
                new int[]{1, 0, 2}
        };

        final int[] result = Dinglemouse.theLift(queues, 15);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 3, 2, 1, 0}, result);
    }

    @Test
    @Disabled
    void multiCaseWith4PeoplesOnEveryFloor() {

        final int[][] queues = {
                new int[]{3, 1, 4, 4},
                new int[]{0, 0, 2, 2},
                new int[]{1, 1, 3, 3},
                new int[]{2, 1, 2, 2},
                new int[]{1, 0, 1, 0}
        };

        final int[] result = Dinglemouse.theLift(queues, 15);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 3, 2, 1, 0}, result);
    }

    @Test
    @Disabled
    void multiCaseWith4PeopleOnFloors0and1and3WithDuplicationsAndUpaAndDownDirection() {

        final int[][] queues = {
                new int[]{3, 1, 1, 1},
                new int[]{0, 0, 0, 0},
                new int[]{3, 1, 3, 1},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 15);
        assertArrayEquals(new int[]{0, 1, 2, 3, 2, 1, 0}, result);
    }

    @Test
    void liftCapacityOneAndTwoPeopleWantToGoUpTo1floorAndSecondTo2FloorFromGround() {

        final int[][] queues = {
                new int[]{1, 2},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 0, 2, 0}, result);
    }

    @Test
    void liftCapacity1and3PeopleFromGroundWantToGoToFloors1and2and4() {

        final int[][] queues = {
                new int[]{1, 2, 4},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        assertArrayEquals(new int[]{0, 1, 0, 2, 0, 4, 0}, result);
    }

    @Test
    void liftCapacity2and3PeopleFromGroundWantToGoToFloors1and2and4() {

        final int[][] queues = {
                new int[]{1, 2, 4},
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        assertArrayEquals(new int[]{0, 1, 2, 0, 4, 0}, result);
    }

    @Test
    void liftCapacity3and4PeopleFromGroundWantToGoToFloors1and2and4and5() {

        final int[][] queues = {
                new int[]{1, 2, 4, 5},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 4, 0, 5, 0}, result);
    }

    @Test
    void liftCapacity1an2PeopleFrom1FloorWantToGoToFloors2and3() {

        final int[][] queues = {
                new int[0],
                new int[]{2, 3},
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 1, 3, 0}, result);
    }

    @Test
    void liftCapacityOneAndTwoPeopleWantToGoDownTo3AndSecondTo2FloorFrom4Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{3, 2}
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        printHelp(result);
        assertArrayEquals(new int[]{0, 4, 3, 4, 2, 0}, result);
    }

    @Test
    void liftCapacity1AndThreePeopleWantToGoDownTo1AndSecondTo2AndThreeTo1FloorFrom4Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{3, 2, 1}
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        printHelp(result);
        assertArrayEquals(new int[]{0, 4, 3, 4, 2, 4, 1, 0}, result);
    }

    @Test
    void liftCapacity2AndTwoPeopleWantToGoDownTo1AndSecondTo2AndThreeTo1FloorFrom4Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{3, 2, 1}
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        printHelp(result);
        assertArrayEquals(new int[]{0, 4, 3, 2, 4, 1, 0}, result);
    }

    @Test
    void liftCapacity3and4PeopleFrom5FloorWantToGoToFloors4and3and2and1() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{4, 3, 2, 1}

        };
        final int[] result = Dinglemouse.theLift(queues, 3);
        assertArrayEquals(new int[]{0, 5, 4, 3, 2, 5, 1, 0}, result);
    }

    @Test
    void liftCapacity1an2PeopleFrom3FloorWantToGoToFloors2and1() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{2, 1},
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        printHelp(result);
        assertArrayEquals(new int[]{0, 3, 2, 3, 1, 0}, result);
    }

    @Test
    void liftCapacity1an2PeopleFrom3FloorWantToGoToFloors2and1ChangingDirectionInFloorQueue() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{1, 2},
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        printHelp(result);
        assertArrayEquals(new int[]{0, 3, 1, 3, 2, 0}, result);
    }

}