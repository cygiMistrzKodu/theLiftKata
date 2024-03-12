import java.util.ArrayList;
import java.util.List;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        List<Integer> liftStops = new ArrayList<>();

        if (queues[0].length == 0) {
            liftStops.add(0);
        }

        List<Integer> floorsPeopleWantToGo = new ArrayList<>();

        for (int floor = 0; floor < queues.length; floor++) {


            if (queues[floor].length > 0 && queues[floor][0] > floor) {


                if (floor == 0) {
                    liftStops.add(floor);
                }

                if (floor >= 1) {
                    liftStops.add(floor);
                }

                for (int peopleIndex = 0; peopleIndex < queues[floor].length; peopleIndex++) {
                    floorsPeopleWantToGo.add(queues[floor][peopleIndex]);
                }

            }


            if (floorsPeopleWantToGo.contains(floor)) {

                int index = floorsPeopleWantToGo.indexOf(floor);

                int peopleGoOutLiftFloor = floorsPeopleWantToGo.get(index);
                floorsPeopleWantToGo.remove(Integer.valueOf(peopleGoOutLiftFloor));

                if (liftStops.get(liftStops.size() - 1) != floor) {
                    liftStops.add(peopleGoOutLiftFloor);

                }

            }

        }

        for (int floor = queues.length - 1; floor >= 0; floor--) {

            if (queues[floor].length > 0 && queues[floor][0] < floor) {

                if (liftStops.get(liftStops.size() - 1) != floor) {
                    liftStops.add(floor);
                }

                for (int peopleIndex = 0; peopleIndex < queues[floor].length; peopleIndex++) {
                    floorsPeopleWantToGo.add(queues[floor][peopleIndex]);
                }

            }

            if (floorsPeopleWantToGo.contains(floor)) {

                int index = floorsPeopleWantToGo.indexOf(floor);

                int peopleGoOutLiftFloor = floorsPeopleWantToGo.get(index);
                floorsPeopleWantToGo.remove(Integer.valueOf(peopleGoOutLiftFloor));

                if (liftStops.get(liftStops.size() - 1) != floor) {
                    liftStops.add(peopleGoOutLiftFloor);

                }

            }

        }

        if (liftStops.get(liftStops.size() - 1) != 0) {
            liftStops.add(0);

        }


        return liftStops.stream().mapToInt(i -> i).toArray();

    }
}
