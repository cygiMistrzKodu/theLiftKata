import java.util.ArrayList;
import java.util.List;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        List<Integer> liftStops = new ArrayList<>();

        if (queues[0].length == 0) {
            liftStops.add(0);
        }

        List<Integer> floorPeopleWantToGo = new ArrayList<>();

        for (int floorIndex = 0; floorIndex < queues.length; floorIndex++) {

            if (queues[floorIndex].length > 0 && queues[floorIndex][0] > floorIndex) {


                if (floorIndex == 0) {
                    liftStops.add(floorIndex);
                }

                if (floorIndex >= 1) {
                    liftStops.add(floorIndex);
                }

                floorPeopleWantToGo.add(queues[floorIndex][0]);
            }


            if (floorPeopleWantToGo.contains(floorIndex)) {

                int index = floorPeopleWantToGo.indexOf(floorIndex);

                int peopleGoOutLiftFloor = floorPeopleWantToGo.get(index);
                floorPeopleWantToGo.remove(Integer.valueOf(peopleGoOutLiftFloor));

                if (liftStops.get(liftStops.size() - 1) != floorIndex) {
                    liftStops.add(peopleGoOutLiftFloor);

                }


            }


        }

        for (int floorIndex = queues.length - 1; floorIndex >= 0; floorIndex--) {

            if (queues[floorIndex].length > 0 && queues[floorIndex][0] < floorIndex) {

                if (queues[floorIndex].length == 0 || queues.length - 1 == floorIndex) {

                    if (liftStops.get(liftStops.size() - 1) != floorIndex) {
                        liftStops.add(floorIndex);
                    }

                }

                if (liftStops.get(liftStops.size() - 1) != floorIndex) {
                    liftStops.add(floorIndex);
                }

                liftStops.add(queues[floorIndex][0]);
            }

        }

        if (liftStops.get(liftStops.size() - 1) != 0) {
            liftStops.add(0);

        }


        return liftStops.stream().mapToInt(i -> i).toArray();

    }
}
