package MoveActors;

import java.util.Random;

/**
 * Created by Michael on 1/31/2017.
 */

public class MoveRandom{
    public int[] RandomLocation;

    public int[] MoveRandom(int gridRows, int gridColumns){
        Random rand = new Random();
        RandomLocation[0]=rand.nextInt(gridRows);
        RandomLocation[1]=rand.nextInt(gridColumns);

        return RandomLocation;
    }

}
