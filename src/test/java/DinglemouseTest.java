
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
        printHelp(result);
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
        printHelp(result);
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
        printHelp(result);
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
    void OneFrom0To2Second2To4ThreeFrom4To1() {

        final int[][] queues = {
                new int[]{2},
                new int[0],
                new int[]{4},
                new int[0],
                new int[]{1}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
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
        printHelp(result);
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
    void somePeopleGoFromDownFlorAndSamFromUpFloorToTheSameFloorAndOnFromThisFloorGoToFirstFloor() {

        final int[][] queues = {
                new int[]{2},
                new int[]{2},
                new int[]{1},
                new int[]{2},
                new int[]{2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
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
    void mixCaseWithPeopleGoUpAndDown() {

        final int[][] queues = {
                new int[]{1},
                new int[]{0},
                new int[]{1},
                new int[]{4},
                new int[]{2}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
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
        printHelp(result);
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
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 0}, result);
    }

    @Test
    void threePeopleGoFrom4To3and2FloorTheOrderShouldNotMatter() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{2, 3}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 4, 3, 2, 0}, result);
    }

    @Test
    void twoPeopleGoFrom2FloorTo1And3Floor() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{1, 3},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 2, 3, 2, 1, 0}, result);
    }

    @Test
    void twoPeopleGoFrom2FloorTo1And3FloorInReverseOrder() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{3, 1},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
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
    void manyCasesTestWith3PersonOnEachFloor() {

        final int[][] queues = {
                new int[0],
                new int[]{3, 3, 3},
                new int[]{4, 0, 3},
                new int[]{0, 1, 4},
                new int[]{1, 0, 2}
        };

        final int[] result = Dinglemouse.theLift(queues, 15);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 3, 2, 1, 0}, result);
    }

    @Test
    void multiCaseWith4PeoplesOnEveryFloor() {

        final int[][] queues = {
                new int[]{3, 1, 4, 4},
                new int[]{0, 0, 2, 2},
                new int[]{1, 1, 3, 3},
                new int[]{2, 1, 2, 2},
                new int[]{1, 0, 1, 0}
        };

        final int[] result = Dinglemouse.theLift(queues, 15);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 3, 2, 1, 0}, result);
    }

    @Test
    void multiCaseWith4PeopleOnFloors0and1and3WithDuplicationsAndUpaAndDownDirection() {

        final int[][] queues = {
                new int[]{3, 1, 1, 1},
                new int[]{0, 0, 0, 0},
                new int[]{3, 1, 3, 1},
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 15);
        printHelp(result);
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
        printHelp(result);
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


    @Test
    void liftCapacity3and6peopleFloors10AllGoFrom0Floor() {

        final int[][] queues = {
                new int[]{3, 4, 5, 8, 7, 9},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        printHelp(result);
        assertArrayEquals(new int[]{0, 3, 4, 5, 0, 7, 8, 9, 0}, result);
    }

    @Test
    void testLiftFullUpp() {

        final int[][] queues = {
                new int[]{3, 4, 5, 8, 7, 9},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0]
        };

        final int[] result = Dinglemouse.theLift(queues, 3);
        printHelp(result);
        assertArrayEquals(new int[]{0, 3, 4, 5, 0, 7, 8, 9, 0}, result);
    }

    @Test
    void testUpAndDown() {

        final int[][] queues = {
                new int[]{3},
                new int[]{2},
                new int[]{0},
                new int[]{2},
                new int[0],
                new int[0],
                new int[]{5},
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 3, 6, 5, 3, 2, 0}, result);
    }

    @Test
    void testHighlander() {

        final int[][] queues = {
                new int[0],
                new int[]{2},
                new int[]{3, 3, 3},
                new int[]{1},
                new int[0],
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 3, 1, 2, 3, 2, 3, 0}, result);
    }

    @Test
    void testHighlander2() {

        final int[][] queues = {
                new int[0],
                new int[]{2},
                new int[]{3, 3},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 3, 2, 3, 0}, result);
//        assertArrayEquals(new int[]{0, 1, 2, 3, 1, 2, 3, 0}, result);
    }

    @Test
    void testLiftFullUp() {

        final int[][] queues = {
                new int[]{3, 3, 3, 3, 3, 3},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 3, 0, 3, 0}, result);
    }

    @Test
    void testLiftFullDown() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[0],
                new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[0],
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 3, 1, 3, 1, 3, 1, 0}, result);
    }

    @Test
    void testYoYo() {

        final int[][] queues = {
                new int[0],
                new int[0],
                new int[]{4, 4, 4, 4},
                new int[0],
                new int[]{2, 2, 2, 2},
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        printHelp(result);
        assertArrayEquals(new int[]{0, 2, 4, 2, 4, 2, 0}, result);
    }

    @Test
    void testLiftFullUpAndDown() {

        final int[][] queues = {
                new int[]{3, 3, 3, 3, 3, 3},
                new int[0],
                new int[0],
                new int[0],
                new int[0],
                new int[]{4, 4, 4, 4, 4, 4},
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 3, 5, 4, 0, 3, 5, 4, 0}, result);
    }

    @Test
    void testFireDrill() {

        final int[][] queues = {
                new int[0],
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0},
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 6, 5, 4, 3, 2, 1, 0, 5, 4, 3, 2, 1, 0, 4, 3, 2, 1, 0, 3, 2, 1, 0, 1, 0}, result);
    }

    @Test
    void testTrickyQueues() {

        final int[][] queues = {
                new int[0],
                new int[]{0, 0, 0, 6},
                new int[0],
                new int[0],
                new int[0],
                new int[]{6, 6, 0, 0, 0, 6},
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 5, 6, 5, 1, 0, 1, 0}, result);
    }


    @Test
    void testRandom() {

        final int[][] queues = {   // dodkoncze to wypełnica potem
                new int[0],
                new int[]{10},
                new int[]{1, 10},
                new int[]{4, 15},
                new int[]{16},
                new int[]{9},
                new int[]{13, 8, 15},
                new int[]{6, 15, 0, 4},
                new int[]{9, 3},
                new int[0],
                new int[]{12, 4, 12},
                new int[]{17, 12, 4},
                new int[]{8, 10},
                new int[]{17, 1, 1, 3},
                new int[0],
                new int[]{7, 17},
                new int[]{17, 13, 4},
                new int[]{5, 4},
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 15, 16, 17, 16, 15, 13, 12, 11, 10, 8, 7, 5, 2, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 15, 16, 17, 16, 15, 13, 12, 11, 10, 8, 7, 4, 3, 4, 5, 6, 7, 8, 11, 16, 17, 16, 15, 13, 12, 11, 10, 8, 7, 1, 3, 5, 6, 7, 8, 11, 15, 16, 15, 13, 12, 11, 10, 8, 7, 4, 5, 6, 7, 8, 9, 11, 17, 15, 13, 12, 11, 10, 8, 7, 6, 7, 8, 11, 13, 12, 11, 10, 8, 7, 1, 6, 7, 8, 9, 11, 12, 13, 12, 11, 10, 8, 7, 3, 6, 7, 15, 12, 11, 10, 8, 7, 3, 7, 15, 12, 11, 10, 7, 4, 11, 7, 4, 7, 0, 7, 4, 0}, result);
    }

    @Test
    void testRandom2() {

        final int[][] queues = {
                new int[]{10, 1, 5},
                new int[]{13, 4, 3},
                new int[]{0, 4, 4, 3},
                new int[0],
                new int[]{9, 13},
                new int[0],
                new int[0],
                new int[]{5, 4},
                new int[]{13},
                new int[]{7},
                new int[]{7},
                new int[]{9, 4},
                new int[]{11, 1, 5},
                new int[]{8, 5, 0}
        };

        final int[] result = Dinglemouse.theLift(queues, 5);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 8, 9, 10, 13, 12, 11, 10, 9, 8, 7, 5, 4, 2, 1, 0, 2, 3, 4, 12, 11, 10, 7, 5, 4, 0}, result);
    }


    @Test
    void tesTMoJ() {

        final int[][] queues = {
                new int[]{1, 1},
                new int[]{2, 2},
                new int[]{1},
                new int[0],
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 2);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 2, 1, 0}, result);
    }

    @Test
    void tesTMoJ2() {

        final int[][] queues = {
                new int[0],
                new int[]{3, 3},
                new int[]{1, 1},
                new int[]{2, 2},
                new int[0],
        };

        final int[] result = Dinglemouse.theLift(queues, 1);
        printHelp(result);
        assertArrayEquals(new int[]{0, 1, 3, 2, 1, 3, 2, 1, 0}, result);
    }


}