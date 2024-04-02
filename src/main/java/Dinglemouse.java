import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {

        List<Integer> liftStopsUp = new ArrayList<>();

        List<Integer> peopleEnterTheLiftToUpFloors = new ArrayList<>();

        List<Integer> timesLiftReturnToFloorUp = new ArrayList<>();
        int peopleStepOutTheLiftToUpCounter = 0;
        int liftReturnToSameFloorFromUp = 0;

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
                        timesLiftReturnToFloorUp.add(floor);
                    }

                    peopleEnterTheLiftToUpFloors.add(queues[floor][peopleGoToIndex]);
                }


            }

            if (peopleEnterTheLiftToUpFloors.contains(floor)) {

                int peopleLeaveIndex = peopleEnterTheLiftToUpFloors.indexOf(floor);
                int peopleLeaveFloorNumber = peopleEnterTheLiftToUpFloors.get(peopleLeaveIndex);

                int lastFloor = liftStopsUp.get(liftStopsUp.size() - 1);

                if (lastFloor != peopleLeaveFloorNumber) {
                    liftStopsUp.add(peopleLeaveFloorNumber);
                }

                peopleStepOutTheLiftToUpCounter++;


                if (liftReturnToSameFloorFromUp < timesLiftReturnToFloorUp.size()) {

                    if (peopleStepOutTheLiftToUpCounter > capacity - 1) {

                        int liftBackToSameFloor = timesLiftReturnToFloorUp.get(liftReturnToSameFloorFromUp++);
                        liftStopsUp.add(liftBackToSameFloor);
                    }
                }

            }


        }

        List<Integer> liftStopsDown = new ArrayList<>();
        List<Integer> peopleEnterTheLiftToDownFloors = new ArrayList<>();
        List<Integer> timesLiftReturnToFloor = new ArrayList<>();

        int peopleGoOutTheLiftCounter = 0;
        int peopleGoOutFromLift = 0;
        int backToSameFloorsNext = 0;

        for (int floor = queues.length - 1; floor > 0; floor--) {

            if (queues[floor].length > 0 && queues[floor][0] < floor) {

                if (liftStopsUp.get(liftStopsUp.size() - 1) != floor) {
                    liftStopsDown.add(floor);
                }
            }

            for (int peopleGoToFloorIndex = 0; peopleGoToFloorIndex < queues[floor].length; peopleGoToFloorIndex++) {

                if (queues[floor][peopleGoToFloorIndex] < floor) {

                    if (peopleGoToFloorIndex > capacity - 1) {
                        timesLiftReturnToFloor.add(floor);
                    }

                    peopleEnterTheLiftToDownFloors.add(queues[floor][peopleGoToFloorIndex]);
                }
            }

            if (peopleEnterTheLiftToDownFloors.contains(floor)) {


                int peopleLeaveLift = peopleEnterTheLiftToDownFloors.get(peopleGoOutFromLift++);

                int lastFloor = -1;
                if (!liftStopsDown.isEmpty()) {
                    lastFloor = liftStopsDown.get(liftStopsDown.size() - 1);
                }

                if (lastFloor != peopleLeaveLift) {
                    liftStopsDown.add(peopleLeaveLift);
                    peopleGoOutTheLiftCounter++;
                }



                if (backToSameFloorsNext < timesLiftReturnToFloor.size()) {

                    if (peopleGoOutTheLiftCounter > capacity - 1) {

                        int liftBackToSameFloor = timesLiftReturnToFloor.get(backToSameFloorsNext++);
                        liftStopsDown.add(liftBackToSameFloor);
                    }
                }

            }

        }

        List<Integer> liftStops = Stream.concat(liftStopsUp.stream(), liftStopsDown.stream()).collect(Collectors.toList());


        if (liftStops.get(liftStops.size() - 1) != 0) {

            liftStops.add(0);
        }


        return liftStops.stream().mapToInt(i -> i).toArray();


    }


}
