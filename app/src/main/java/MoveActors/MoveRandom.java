package MoveActors;

import java.util.Random;

/**
 * Created by Michael on 1/31/2017.
 */

public class MoveRandom{
    public int[] RandomLocation; // Initialize the new location array

    public int[] MoveRandom(int gridRows, int gridColumns){
        Random rand = new Random(); // Create a new random number
        RandomLocation[0]=rand.nextInt(gridRows); // Pick a random integer within the range of all number of rows
        RandomLocation[1]=rand.nextInt(gridColumns); // Pick a random integer within the range of all number of columns

        return RandomLocation; // Return the new location
    }
}
