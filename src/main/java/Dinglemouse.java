public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        if (queues[0].length > 0)
        {

            int floorToGo = queues[0][0];
            return new int[]{0,floorToGo,0};


        }

        return new int[]{0};

    }
}
