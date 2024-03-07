import java.util.ArrayList;
import java.util.List;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        List<Integer> liftStops = new ArrayList<>();

        if (queues[0].length == 0 ) {
            liftStops.add(0);
        }

        for (int floorIndex = 0; floorIndex < queues.length; floorIndex++) {

            if ( queues[floorIndex].length > 0) {
               liftStops.add(floorIndex);
               liftStops.add(queues[floorIndex][0]);
            }

        }
        if (liftStops.get(liftStops.size()-1) != 0) {
            liftStops.add(0);

        }

        return  liftStops.stream().mapToInt(i -> i).toArray();

    }
}
