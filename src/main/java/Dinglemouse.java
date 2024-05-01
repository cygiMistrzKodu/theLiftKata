import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {

        List<Floor> building = changeToBuildingAndFloorsRepresentation(queues);

        List<Integer> liftStops = new ArrayList<>();
        List<Integer> peopleGoingOnUpperFloors = new ArrayList<>();

        liftStops.add(0);

        while (isPeopleWaitingOnTheAtLeastOneFloor(building)) {

            for (int floorNumber = 0; floorNumber < building.size(); floorNumber++) {

                Floor floor = building.get(floorNumber);


                if (isOnFloorPeopleWaiting(floor)) {


                    if (isPeopleOnFloorWantingToGoUp(floor)) {

                        if (liftStops.isEmpty()) {
                            liftStops.add(floor.getNumber());
                        }

                        if (isLastLiftStopDifferentThanCurrentFloorNumber(liftStops, floor)) {
                            liftStops.add(floor.getNumber());
                        }

                        List<Integer> peopleOnCurrentFloorGoingUp = new ArrayList<>();

                        int maxPeopleCanEnterTheLift = calculateHowManyPeopleCanEnterTheLift(capacity, peopleGoingOnUpperFloors);

                        floor.peopleWaitingForLift.stream()
                                .filter(peopleGo -> peopleGo > floor.number)
                                .limit(maxPeopleCanEnterTheLift)
                                .forEach(peopleGoingUp -> {

                                    peopleGoingOnUpperFloors.add(peopleGoingUp);
                                    peopleOnCurrentFloorGoingUp.add(peopleGoingUp);

                                });


                        removePeopleFromCurrentFloorWaitingForLift(peopleOnCurrentFloorGoingUp, floor);
                    }

                }

                if (peopleGoingOnUpperFloors.contains(floorNumber)) {
                    int peopleIndex = peopleGoingOnUpperFloors.indexOf(floorNumber);
                    if (peopleIndex != -1) {

                        Integer peopleEnterTheFloorFromLift = peopleGoingOnUpperFloors.get(peopleIndex);
                        Integer lastFloorTheLiftStop = liftStops.get(liftStops.size() - 1);

                        if (isManyPeopleGoOutTheLiftAreCountedAsOne(peopleEnterTheFloorFromLift, lastFloorTheLiftStop)) {
                            liftStops.add(peopleEnterTheFloorFromLift);
                        }

                        peopleGetOutTheLift(peopleGoingOnUpperFloors, peopleEnterTheFloorFromLift);

                        int maxPeopleCanEnterTheLift = calculateHowManyPeopleCanEnterTheLift(capacity, peopleGoingOnUpperFloors);

                        Floor floorPeopleGoOutTheLift = building.get(peopleEnterTheFloorFromLift);
                        List<Integer> peopleWaitingAtDestinationFloorEnterTheFreeSpaceInLift = floorPeopleGoOutTheLift.peopleWaitingForLift.stream()
                                .filter(peopleGo -> peopleGo > floorPeopleGoOutTheLift.number).limit(maxPeopleCanEnterTheLift).toList();

                        peopleGoingOnUpperFloors.addAll(peopleWaitingAtDestinationFloorEnterTheFreeSpaceInLift);
                        removePeopleFromCurrentFloorWaitingForLift(peopleWaitingAtDestinationFloorEnterTheFreeSpaceInLift, floor);

                    }
                }


            }

            List<Integer> peopleGoingOnLowerFloors = new ArrayList<>();

            for (int floorNumber = building.size() - 1; floorNumber >= 0; floorNumber--) {

                Floor floor = building.get(floorNumber);

                if (isOnFloorPeopleWaiting(floor)) {

                    if (isPeopleOnFloorWantingToGoDown(floor)) {

                        if (isLastLiftStopDifferentThanCurrentFloorNumber(liftStops, floor)) {
                            liftStops.add(floor.getNumber());
                        }

                        List<Integer> peopleOnCurrentFloorGoingDown = new ArrayList<>();
                        int maxPeopleCanEnterTheLift = calculateHowManyPeopleCanEnterTheLift(capacity, peopleGoingOnLowerFloors);

                        floor.peopleWaitingForLift.stream()
                                .filter(peopleGo -> peopleGo < floor.number)
                                .limit(maxPeopleCanEnterTheLift)
                                .forEach(peopleGo -> {

                                    peopleGoingOnLowerFloors.add(peopleGo);
                                    peopleOnCurrentFloorGoingDown.add(peopleGo);

                                });

                        removePeopleFromCurrentFloorWaitingForLift(peopleOnCurrentFloorGoingDown, floor);
                    }


                }

                if (peopleGoingOnLowerFloors.contains(floorNumber)) {
                    int peopleIndex = peopleGoingOnLowerFloors.indexOf(floorNumber);
                    if (peopleIndex != -1) {

                        Integer peopleEnterTheFloorFromLift = peopleGoingOnLowerFloors.get(peopleIndex);
                        Integer lastFloorTheLiftStop = liftStops.get(liftStops.size() - 1);

                        if (isManyPeopleGoOutTheLiftAreCountedAsOne(peopleEnterTheFloorFromLift, lastFloorTheLiftStop)) {
                            liftStops.add(peopleEnterTheFloorFromLift);
                        }

                        peopleGetOutTheLift(peopleGoingOnLowerFloors, peopleEnterTheFloorFromLift);


                        Floor floorPeopleOut = building.get(peopleEnterTheFloorFromLift);

                        int maxPeopleCanEnterTheLift = calculateHowManyPeopleCanEnterTheLift(capacity, peopleGoingOnLowerFloors);

                        List<Integer> peopleEnterTheLiftWhenOtherGoOut = floorPeopleOut.peopleWaitingForLift.stream()
                                .filter(peopleGo -> peopleGo < floorPeopleOut.number).limit(maxPeopleCanEnterTheLift).toList();

                        peopleGoingOnLowerFloors.addAll(peopleEnterTheLiftWhenOtherGoOut);
                        removePeopleFromCurrentFloorWaitingForLift(peopleEnterTheLiftWhenOtherGoOut, floor);

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

    private static boolean isManyPeopleGoOutTheLiftAreCountedAsOne(Integer peopleEnterTheFloorFromLift, Integer lastFloorTheLiftStop) {
        return !Objects.equals(peopleEnterTheFloorFromLift, lastFloorTheLiftStop);
    }

    private static void peopleGetOutTheLift(List<Integer> peopleInLift, Integer liftAtFloorNow) {
        peopleInLift.removeIf(peopleGoOutFloor -> Objects.equals(peopleGoOutFloor, liftAtFloorNow));
    }

    private static boolean isLastLiftStopDifferentThanCurrentFloorNumber(List<Integer> liftStops, Floor floor) {
        return isManyPeopleGoOutTheLiftAreCountedAsOne(liftStops.get(liftStops.size() - 1), floor.number);
    }

    private static int calculateHowManyPeopleCanEnterTheLift(int capacity, List<Integer> peopleInLift) {
        return Math.max(capacity - peopleInLift.size(), 0);
    }

    private static boolean isOnFloorPeopleWaiting(Floor floor) {
        return !floor.peopleWaitingForLift.isEmpty();
    }

    private static boolean isPeopleOnFloorWantingToGoDown(Floor floor) {
        return floor.peopleWaitingForLift.stream().anyMatch(peopleGo -> peopleGo < floor.number);
    }

    private static void removePeopleFromCurrentFloorWaitingForLift(List<Integer> peopleOnCurrentFloor, Floor floor) {
        peopleOnCurrentFloor.forEach(floor.peopleWaitingForLift::remove);
    }

    private static boolean isPeopleOnFloorWantingToGoUp(Floor floor) {
        return floor.peopleWaitingForLift.stream().anyMatch(peopleGo -> peopleGo > floor.number);
    }

    private static List<Floor> changeToBuildingAndFloorsRepresentation(int[][] queues) {
        List<Floor> building = new ArrayList<>();

        for (int floorNumber = 0; floorNumber < queues.length; floorNumber++) {

            Floor floor = new Floor();
            floor.setNumber(floorNumber);

            for (int peopleOnFloor = 0; peopleOnFloor < queues[floorNumber].length; peopleOnFloor++) {

                floor.addPeopleWaitingForLift(queues[floorNumber][peopleOnFloor]);
            }
            building.add(floor);

        }
        return building;
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
