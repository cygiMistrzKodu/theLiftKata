import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {

        List<Integer> liftStopsUp = new ArrayList<>();

        for (int floor = 0; floor < queues.length; floor++) {


            if (queues[floor].length == 0 && floor == 0) {
                liftStopsUp.add(0);
            }

            if (queues[floor].length > 0 && queues[floor][0] > floor) {
                liftStopsUp.add(floor);
            }


            for (int peopleGoToIndex = 0; peopleGoToIndex < queues[floor].length; peopleGoToIndex++) {

                if (queues[floor][peopleGoToIndex] > floor) {

                    if (peopleGoToIndex > capacity - 1) {
                        liftStopsUp.add(floor);
                    }

                    liftStopsUp.add(queues[floor][peopleGoToIndex]);
                }


            }


        }

        List<Integer> liftStopsOnFloorsGowingDown = new ArrayList<>();
        List<Integer> peopleInLiftGoesDown = new ArrayList<>();
        List<Integer> liftReturnOnSameFloorCaseOfCapacity = new ArrayList<>();
        int countAddition = 0;

        int sameFloorCapacity = 0;
        int peopleGoOutFromLift = 0;
        for (int floor = queues.length - 1; floor > 0; floor--) {

            if (queues[floor].length > 0 && queues[floor][0] < floor) {
                liftStopsOnFloorsGowingDown.add(floor);
            }

            for (int peopleGoToIndex = 0; peopleGoToIndex < queues[floor].length; peopleGoToIndex++) {


                if (queues[floor][peopleGoToIndex] < floor) {

                    if (peopleGoToIndex > capacity - 1) {
//                        liftStopsOnFloorsGowingDown.add(floor);
                        liftReturnOnSameFloorCaseOfCapacity.add(floor);
//                        peopleInLiftGoDown.add(floor);
                    }

//                    liftStopsOnFloorsGowingDown.add(queues[floor][peopleGoToIndex]);
                    peopleInLiftGoesDown.add(queues[floor][peopleGoToIndex]);
                }
            }

            if (peopleInLiftGoesDown.contains(floor)) {

//                int index = peopleInLiftGoDown.indexOf(floor);
//                int floorPeopleOut = peopleInLiftGoDown.get(index);

                int floorPeopleOut = peopleInLiftGoesDown.get(peopleGoOutFromLift++);
                liftStopsOnFloorsGowingDown.add(floorPeopleOut);
                countAddition++;


                if (sameFloorCapacity < liftReturnOnSameFloorCaseOfCapacity.size()) {

                    if (countAddition > capacity - 1) {

                        int backToFloor = liftReturnOnSameFloorCaseOfCapacity.get(sameFloorCapacity++);
                        liftStopsOnFloorsGowingDown.add(backToFloor);
                    }
                }

            }

//            liftStopsOnFloorsGowingDown.addAll(peopleWantToGoDawnOutOfLift);
//            peopleWantToGoDawnOutOfLift.clear();


        }


        List<Integer> liftStops = Stream.concat(liftStopsUp.stream(), liftStopsOnFloorsGowingDown.stream()).collect(Collectors.toList());


        if (liftStops.get(liftStops.size() - 1) != 0) {

            liftStops.add(0);
        }


        return liftStops.stream().mapToInt(i -> i).toArray();


    }


}
