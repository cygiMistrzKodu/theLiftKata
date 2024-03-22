import java.util.*;
import java.util.stream.IntStream;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        List<Integer> liftStops = new ArrayList<>();

        Map<Integer, List<Integer>> nextPeopleWillBeTaken = new HashMap<>();


        if (queues[0].length == 0) {
            liftStops.add(0);
        }

        List<Integer> floorsPeopleWantToGo = new ArrayList<>();

        // czy trzeba wracać na piętra ?? bo ludzie czekaja a nie było miejsca ??

        for (int floor = 0; floor < queues.length; floor++) {


            if (queues[floor].length > 0) {

                if (floor == 0) {
                    liftStops.add(floor);
                }

                for (int peopleIndex = 0; peopleIndex < queues[floor].length; peopleIndex++) {

                    if (floor >= 1 && queues[floor][peopleIndex] > floor) {

                        if (liftStops.get(liftStops.size() - 1) != floor) {
                            liftStops.add(floor);
                        }
                    }
                }

            }

            if (capacity >= queues[floor].length) {

                List<Integer> peopleIndexOnCurrentFloorTaken = new ArrayList<>();
                peopleIndexOnCurrentFloorTaken.add(0, 0);
                peopleIndexOnCurrentFloorTaken.add(1, queues[floor].length);

                nextPeopleWillBeTaken.put(floor, peopleIndexOnCurrentFloorTaken);
            }

//            if (capacity < queues[floor].length) {  // moze cos innego
//
//                if (nextPeopleWillBeTaken.containsKey(floor)) {
//
//                    List<Integer> peopleIndexOnCurrentFloor = nextPeopleWillBeTaken.get(floor);
//
//                    Integer previouslyFinishStart = peopleIndexOnCurrentFloor.get(0);
//
//                    Integer nextPeopleStartIndex = previouslyFinishStart + capacity;
//
//                    Integer previouslyFinishStopIndex = peopleIndexOnCurrentFloor.get(1);
//
//                    Integer nextPeopleFinishStopIndex = previouslyFinishStopIndex + capacity;
//
//                    List<Integer> peopleIndexOnCurrentFloorTaken = new ArrayList<>();
//                    peopleIndexOnCurrentFloorTaken.set(0, nextPeopleStartIndex);
//                    peopleIndexOnCurrentFloorTaken.set(1, nextPeopleFinishStopIndex);
//
//                    nextPeopleWillBeTaken.put(floor, peopleIndexOnCurrentFloorTaken);
//
//                } else {
//
//                    List<Integer> peopleIndexOnCurrentFloorTaken = new ArrayList<>();
//                    peopleIndexOnCurrentFloorTaken.add(0, 0);
//                    peopleIndexOnCurrentFloorTaken.add(1, capacity);
//                    nextPeopleWillBeTaken.put(floor, peopleIndexOnCurrentFloorTaken);
//                }
//
//            }

            int[] peopleWaitingForLiftOnFloor = queues[floor];  // moze jakos wstawic 0 dlatego ze musi winda wrocic a potem kolejnego brac
            List<Integer> startAndStopIndexDependingOnFloor = nextPeopleWillBeTaken.get(floor);

            int[] peopleGotToLift = Arrays.stream(peopleWaitingForLiftOnFloor,
                    startAndStopIndexDependingOnFloor.get(0), startAndStopIndexDependingOnFloor.get(1)).toArray();

            floorsPeopleWantToGo.addAll(Arrays.stream(peopleGotToLift).boxed().toList());

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


            for (int peopleIndex = 0; peopleIndex < queues[floor].length; peopleIndex++) {

                if (queues[floor].length > 0 && queues[floor][peopleIndex] < floor) {

                    if (liftStops.get(liftStops.size() - 1) != floor) {
                        liftStops.add(floor);
                    }

                }

                floorsPeopleWantToGo.add(queues[floor][peopleIndex]);
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
