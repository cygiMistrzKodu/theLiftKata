import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
        List<Integer> enterTheLiftToGoUpDirection = new ArrayList<>();

        for (int i = 0; i < building.size(); i++) {

            Floor floor = building.get(i);


            if (floor.peopleWaitingForLift.isEmpty() && i == 0) {
                liftStops.add(floor.getNumber());
            }

            if (!floor.peopleWaitingForLift.isEmpty()) {


                if (floor.number < floor.peopleWaitingForLift.get(0)) {

                    if (liftStops.isEmpty()) {
                        liftStops.add(floor.getNumber());
                    }

                    if (!Objects.equals(liftStops.get(liftStops.size() - 1), floor.number)) {
                        liftStops.add(floor.getNumber());
                    }

                    floor.peopleWaitingForLift.stream()
                            .filter(peopleGo -> peopleGo > floor.number)
                            .forEach(enterTheLiftToGoUpDirection::add);


                }


            }

            if (enterTheLiftToGoUpDirection.contains(i)) {
               int peopleIndex =  enterTheLiftToGoUpDirection.indexOf(i);
               if (peopleIndex != -1) {

                Integer peopleEnterTheFloor =   enterTheLiftToGoUpDirection.get(peopleIndex);
                Integer lastFloorTheLiftStop = liftStops.get(liftStops.size() -1);

                if (!Objects.equals(peopleEnterTheFloor, lastFloorTheLiftStop)) {
                    liftStops.add(enterTheLiftToGoUpDirection.get(peopleIndex));
                }

               }
            }

        }

        for (int i = building.size() - 1; i > 0; i--) {

            Floor floor = building.get(i);

            if (!floor.peopleWaitingForLift.isEmpty()) {


                if (floor.number > floor.peopleWaitingForLift.get(0)) {

                    if (!Objects.equals(liftStops.get(liftStops.size() - 1), floor.number)) {
                        liftStops.add(floor.getNumber());
                    }


                    liftStops.addAll(floor.peopleWaitingForLift);
                }


            }


        }


        if (!(liftStops.get(liftStops.size() - 1) == 0)) {
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
