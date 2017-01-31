package MoveActors;

import java.util.Random;

/**
 * Created by Michael on 1/31/2017.
 */

public class MoveRandom{
    private int[] location;

    public int[] MoveRandom(int gridRows, int gridColumns){
        Random rand = new Random();
        location[0]=rand.nextInt(gridRows);
        location[1]=rand.nextInt(gridColumns);

        return location;
    }

}
