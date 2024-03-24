import java.util.*;
import java.util.stream.IntStream;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {

        if (queues[0].length == 0) {
            return new int[]{0};
        }

        List<Integer> liftStops = new ArrayList<>();

        liftStops.add(0);
        for (int floor = 0; floor < queues.length; floor++) {

            for (int peopleGoToFloorIndex = 0; peopleGoToFloorIndex < queues[floor].length; peopleGoToFloorIndex++) {

                if (peopleGoToFloorIndex > capacity -1) {
                        liftStops.add(floor);
                }

                liftStops.add(queues[floor][peopleGoToFloorIndex]);
            }


        }
        liftStops.add(0);

        return liftStops.stream().mapToInt(i -> i).toArray();


    }


}
