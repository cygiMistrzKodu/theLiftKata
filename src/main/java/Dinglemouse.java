import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {

        for (int floorIndex = 0; floorIndex < queues.length; floorIndex++) {

            if (queues.length > 1 && queues[floorIndex].length > 0) {


                if (queues[floorIndex].length >= 1) {


                    int[] floorsToGo = queues[floorIndex];

                    List<Integer> liftStops = new ArrayList<>();
                    liftStops.add(0);

                    if (floorIndex > 0) {
                        liftStops.add(floorIndex);
                    }

                    List<Integer> peopleGoDown = new ArrayList<>();
                    List<Integer> peopleGoUp = new ArrayList<>();


                    for (int personIndex = 0; personIndex < floorsToGo.length; personIndex++) {

                        if (floorsToGo[personIndex] < floorIndex) {
                            peopleGoDown.add(floorsToGo[personIndex]);
                        }

                        if (floorsToGo[personIndex] > floorIndex) {
                            peopleGoUp.add(floorsToGo[personIndex]);
                        }

                    }
                    Collections.sort(peopleGoUp);
                    peopleGoDown.sort(Collections.reverseOrder());
                    liftStops.addAll(peopleGoDown);
                    liftStops.addAll(peopleGoUp);

                    if (liftStops.get(liftStops.size() -1) != 0) {
                        liftStops.add(0);
                    }

                    return liftStops.stream().mapToInt(i -> i).toArray();

                }


            }

        }

        return new int[]{0};

    }
}
