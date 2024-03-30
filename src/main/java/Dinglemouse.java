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

        List<Integer> liftStopsOnUpToDown = new ArrayList<>();
        List<Integer> peopleEnterTheLiftToDownFloors = new ArrayList<>();
        List<Integer> timesLiftReturnToFloor = new ArrayList<>();

        int peopleGoOutTheLiftCounter = 0;
        int peopleGoOutFromLift = 0;
        int getNextFloorReturnCaseOfMaxCapcity = 0;

        for (int floor = queues.length - 1; floor > 0; floor--) {

            if (queues[floor].length > 0 && queues[floor][0] < floor) {
                liftStopsOnUpToDown.add(floor);
            }

            for (int peopleGoToIndex = 0; peopleGoToIndex < queues[floor].length; peopleGoToIndex++) {

                if (queues[floor][peopleGoToIndex] < floor) {

                    if (peopleGoToIndex > capacity - 1) {
                        timesLiftReturnToFloor.add(floor);
                    }

                    peopleEnterTheLiftToDownFloors.add(queues[floor][peopleGoToIndex]);
                }
            }

            if (peopleEnterTheLiftToDownFloors.contains(floor)) {


                int floorPeopleOut = peopleEnterTheLiftToDownFloors.get(peopleGoOutFromLift++);
                liftStopsOnUpToDown.add(floorPeopleOut);
                peopleGoOutTheLiftCounter++;


                if (getNextFloorReturnCaseOfMaxCapcity < timesLiftReturnToFloor.size()) {

                    if (peopleGoOutTheLiftCounter > capacity - 1) {

                        int backToFloor = timesLiftReturnToFloor.get(getNextFloorReturnCaseOfMaxCapcity++);
                        liftStopsOnUpToDown.add(backToFloor);
                    }
                }

            }

        }

        List<Integer> liftStops = Stream.concat(liftStopsUp.stream(), liftStopsOnUpToDown.stream()).collect(Collectors.toList());


        if (liftStops.get(liftStops.size() - 1) != 0) {

            liftStops.add(0);
        }


        return liftStops.stream().mapToInt(i -> i).toArray();


    }


}
