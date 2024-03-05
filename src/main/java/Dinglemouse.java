import java.util.ArrayList;
import java.util.List;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        if (queues[0].length == 1) {

            int floorToGo = queues[0][0];
            return new int[]{0, floorToGo, 0};


        }


        for (int floorIndex = 0; floorIndex <= queues.length; floorIndex++) {

            if (queues.length > 2 && queues[floorIndex].length > 0) {

                if (queues[floorIndex].length == 1) {

                    int floorToGo = queues[floorIndex][0];

                    if (floorToGo == 0) {
                        return new int[]{0, floorIndex, 0};
                    }

                    return new int[]{0, floorIndex, floorToGo, 0};

                }


                if (queues[floorIndex].length >= 2) {


                    int[] floorsToGo = queues[floorIndex];

                    List<Integer> liftStops = new ArrayList<>();
                    liftStops.add(0);

                    if (floorIndex > 0) {
                        liftStops.add(floorIndex);
                    }

                    for (int personIndex = 0; personIndex < floorsToGo.length; personIndex++) {
                        liftStops.add(floorsToGo[personIndex]);

                    }
                    liftStops.add(0);

                    return liftStops.stream().mapToInt(i -> i).toArray();

                }


            }

        }

        return new int[]{0};

    }
}
