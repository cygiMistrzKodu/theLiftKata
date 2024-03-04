public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        if (queues[0].length > 0) {

            int floorToGo = queues[0][0];
            return new int[]{0, floorToGo, 0};


        }


        for (int floorIndex = 1; floorIndex <= queues.length; floorIndex++) {

            if (queues.length > 2 && queues[floorIndex].length > 0) {

                int floorToGo = queues[floorIndex][0];

                if (floorToGo == 0) {
                    return new int[]{0, floorIndex, 0};
                }

                return new int[]{0, floorIndex, floorToGo, 0};


            }

        }

        return new int[]{0};

    }
}
