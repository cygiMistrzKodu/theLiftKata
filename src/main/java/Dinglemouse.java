import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

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

        liftStops.add(0);

        while (isPeopleWaitingOnTheAtLeastOneFloor(building)) {

            for (int i = 0; i < building.size(); i++) {

                Floor floor = building.get(i);


                if (!floor.peopleWaitingForLift.isEmpty()) {


                    if (floor.peopleWaitingForLift.stream().anyMatch(peopleGo -> peopleGo > floor.number)) {

                        if (liftStops.isEmpty()) {
                            liftStops.add(floor.getNumber());
                        }

                        if (!Objects.equals(liftStops.get(liftStops.size() - 1), floor.number)) {
                            liftStops.add(floor.getNumber());
                        }

                        List<Integer> peopleOnCurrentFloorGoingUp = new ArrayList<>();
                        AtomicInteger counterMaxPeopleCanEnterTheLift = new AtomicInteger();
                        counterMaxPeopleCanEnterTheLift.set(enterTheLiftToGoUpDirection.size());  // problem jakis z w tedy kiedy pasażerowie wsiadaja do windy i wysiadaja jednocześnie
                        floor.peopleWaitingForLift.stream()
                                .filter(peopleGo -> peopleGo > floor.number)
                                .forEach(peopleGo -> {
                                    if (counterMaxPeopleCanEnterTheLift.get() < capacity) {

                                        enterTheLiftToGoUpDirection.add(peopleGo);
                                        peopleOnCurrentFloorGoingUp.add(peopleGo);
                                        counterMaxPeopleCanEnterTheLift.getAndIncrement();
                                    }
                                });


                        peopleOnCurrentFloorGoingUp.forEach(floor.peopleWaitingForLift::remove);
                    }

                }

                if (enterTheLiftToGoUpDirection.contains(i)) {
                    int peopleIndex = enterTheLiftToGoUpDirection.indexOf(i);
                    if (peopleIndex != -1) {

                        Integer peopleEnterTheFloorFromLift = enterTheLiftToGoUpDirection.get(peopleIndex);
                        Integer lastFloorTheLiftStop = liftStops.get(liftStops.size() - 1);

                        if (!Objects.equals(peopleEnterTheFloorFromLift, lastFloorTheLiftStop)) {
                            liftStops.add(peopleEnterTheFloorFromLift);
                        }

                        enterTheLiftToGoUpDirection.removeIf(peopleGo -> Objects.equals(peopleGo, peopleEnterTheFloorFromLift));
                    }
                }


            }

            List<Integer> enterTheLiftToGoDownDirection = new ArrayList<>();

            for (int i = building.size() - 1; i >= 0; i--) {

                Floor floor = building.get(i);

                if (!floor.peopleWaitingForLift.isEmpty()) {


                    if (floor.peopleWaitingForLift.stream().anyMatch(peopleGo -> peopleGo < floor.number)) {

                        if (!Objects.equals(liftStops.get(liftStops.size() - 1), floor.number)) {
                            liftStops.add(floor.getNumber());
                        }

                        List<Integer> peopleOnCurrentFloorGoingDown = new ArrayList<>();
                        AtomicInteger counterMaxPeopleCanEnterTheLift = new AtomicInteger();
                        counterMaxPeopleCanEnterTheLift.set(enterTheLiftToGoDownDirection.size());   // tu zwiazan z liecznieme

                        floor.peopleWaitingForLift.stream()
                                .filter(peopleGo -> peopleGo < floor.number)
                                .forEach(peopleGo -> {

                                    if (counterMaxPeopleCanEnterTheLift.get() < capacity) {

                                        enterTheLiftToGoDownDirection.add(peopleGo);
                                        peopleOnCurrentFloorGoingDown.add(peopleGo);
                                        counterMaxPeopleCanEnterTheLift.getAndIncrement();
                                    }
                                });

                        peopleOnCurrentFloorGoingDown.forEach(floor.peopleWaitingForLift::remove);
                    }


                }

                if (enterTheLiftToGoDownDirection.contains(i)) {
                    int peopleIndex = enterTheLiftToGoDownDirection.indexOf(i);
                    if (peopleIndex != -1) {

                        Integer peopleEnterTheFloorFromLift = enterTheLiftToGoDownDirection.get(peopleIndex);
                        Integer lastFloorTheLiftStop = liftStops.get(liftStops.size() - 1);

                        if (!Objects.equals(peopleEnterTheFloorFromLift, lastFloorTheLiftStop)) {
                            liftStops.add(peopleEnterTheFloorFromLift);
                        }

                        enterTheLiftToGoDownDirection.removeIf(peopleGo -> Objects.equals(peopleGo, peopleEnterTheFloorFromLift));
                    }
                }


            }
        }

        if (!liftStops.isEmpty()) {

            if (!(liftStops.get(liftStops.size() - 1) == 0)) {
                liftStops.add(0);
            }
        } else {
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

        public boolean isPeoplePresent() {
            return !peopleWaitingForLift.isEmpty();
        }

    }

    private static boolean isPeopleWaitingOnTheAtLeastOneFloor(List<Floor> building) {
        return building.stream().anyMatch(Floor::isPeoplePresent);

    }


}
