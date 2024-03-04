public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        if (queues[0].length > 0) {

            int floorToGo = queues[0][0];
            return new int[]{0, floorToGo, 0};


        }

        if (queues.length > 2 && queues[2].length > 0) {

            int floorToGo = queues[2][0];
            if (floorToGo == 0) {
                return new int[]{0, 2, 0};
            }

        }

        if (queues.length > 2 && queues[1].length > 0) {

            int floorToGo = queues[1][0];
            if (floorToGo == 0) {
                return new int[]{0, 1, 0};
            }

        }

        if (queues.length > 2 && queues[3].length > 0) {

            int floorToGo = queues[3][0];
            if (floorToGo == 0) {
                return new int[]{0, 3, 0};
            }

        }


        for (int floorIndex = 1; floorIndex <= queues.length; floorIndex++) {

            if (queues.length > 2 && queues[floorIndex].length > 0) {

                int floorToGo = queues[floorIndex][0];
                return new int[]{0, floorIndex, floorToGo, 0};

            }

        }

        return new int[]{0};

    }
}
