package MoveActors;

import java.util.Random;

/**
 * Created by Michael on 1/31/2017.
 *
 * Moves an actor to a random location on the grid.
 */

public class RandomActor {
    int[] RandomLocation = new int[2]; // Declare the new location array

    public int[] moveRandom(int gridRows, int gridColumns){
        Random rand = new Random(); // Create a new random number
        RandomLocation[0]=rand.nextInt(gridRows); // Pick a random integer within the range of all number of rows
        RandomLocation[1]=rand.nextInt(gridColumns); // Pick a random integer within the range of all number of columns

        return RandomLocation; // Return the new location
    }
}
