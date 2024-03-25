import java.util.*;
import java.util.stream.IntStream;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        List<Integer> liftStops = new ArrayList<>();

        for (int floor = 0; floor < queues.length; floor++) {

            if (queues[floor].length == 0 && floor == 0) {
                liftStops.add(0);
            }

            if (queues[floor].length > 0) {
                liftStops.add(floor);
            }


            for (int peopleGoToIndex = 0; peopleGoToIndex < queues[floor].length; peopleGoToIndex++) {


                if (peopleGoToIndex > capacity - 1) {
                    liftStops.add(floor);
                }

                liftStops.add(queues[floor][peopleGoToIndex]);
            }


        }

        if (liftStops.get(liftStops.size() -1) != 0) {

            liftStops.add(0);
        }



        return liftStops.stream().mapToInt(i -> i).toArray();


    }


}
