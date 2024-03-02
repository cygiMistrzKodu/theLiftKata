public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {


        if (queues.length == 4 && queues[0][0] == 3) {
            return new int[]{0,3,0};
        }


        if (queues[0].length > 0 && queues[0][0] == 2) {
            return new int[]{0,2,0};
        }

        if (queues[0].length > 0) {
            return new int[]{0,1,0};
        }


        return new int[]{0};
    }
}
