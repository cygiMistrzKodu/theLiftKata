import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {

        List<Floor> building = new ArrayList<>();

        for (int floorNumber = 0; floorNumber < queues.length; floorNumber++) {

            Floor floor = new Floor();
            floor.setNumber(floorNumber);

            for (int peopleOnFloor = 0; peopleOnFloor < queues[floorNumber].length; peopleOnFloor++) {

                floor.addPeopleWaitingForLift(queues[floorNumber][peopleOnFloor]);
            }
            building.add(floor);

        }


        List<Integer> liftStops = new ArrayList<>();

        for (int i = 0; i < building.size(); i++) {

            Floor floor = building.get(i);

            if (!floor.peopleWaitingForLift.isEmpty() || i == 0) {
                liftStops.add(floor.getNumber());
            }

            Collections.sort(floor.peopleWaitingForLift);
            liftStops.addAll(floor.peopleWaitingForLift);
        }

        if (!(liftStops.size() == 1 && liftStops.get(0) == 0)) {
            liftStops.add(0);
        }


        return liftStops.stream().mapToInt(i -> i).toArray();


    }

    private static class Floor {

        private Integer number;
        private final List<Integer> peopleWaitingForLift = new ArrayList<>();

        public Floor() {
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public void addPeopleWaitingForLift(Integer floorToGo) {
            peopleWaitingForLift.add(floorToGo);
        }

        public void peopleEnterTheLift(Integer floorToGo) {
            peopleWaitingForLift.remove(floorToGo);
        }
    }


}
