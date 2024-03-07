import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dinglemouse {
    public static int[] theLift(int[][] queues, final int capacity) {

        if ( queues[0].length > 0) {
            return new int[]{0,queues[0][0],0};
        }

        if ( queues[1].length > 0) {
            return new int[]{0,1,queues[1][0],0};
        }

        if ( queues[2].length > 0) {
            return new int[]{0,2,queues[2][0],0};
        }

        return new int[]{0};

    }
}
