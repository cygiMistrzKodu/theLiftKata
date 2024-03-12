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

        for (int floorIndex = queues.length - 1; floorIndex >= 0; floorIndex--) {

            if (queues[floorIndex].length > 0 && queues[floorIndex][0] < floorIndex) {

                if (liftStops.get(liftStops.size() - 1) != floorIndex) {
                    liftStops.add(floorIndex);
                }

                floorsPeopleWantToGo.add(queues[floorIndex][0]);
            }

            if (floorsPeopleWantToGo.contains(floorIndex)) {

                int index = floorsPeopleWantToGo.indexOf(floorIndex);

                int peopleGoOutLiftFloor = floorsPeopleWantToGo.get(index);
                floorsPeopleWantToGo.remove(Integer.valueOf(peopleGoOutLiftFloor));

                if (liftStops.get(liftStops.size() - 1) != floorIndex) {
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
