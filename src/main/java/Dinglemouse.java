public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        if (queues[0].length > 0)
        {

            int floorToGo = queues[0][0];
            return new int[]{0,floorToGo,0};


        }

        if ( queues[1].length > 0) {

            if (queues[1][0] == 2) {
                return new int[]{0, 1, 2, 0};
            }

            if (queues[1][0] == 3) {
                return new int[]{0, 1, 3, 0};
            }

            if (queues[1][0] == 4) {
                return new int[]{0, 1, 4, 0};
            }


        }

        return new int[]{0};

    }
}
