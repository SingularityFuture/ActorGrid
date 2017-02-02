package MoveActors;

/**
 * Created by Michael on 1/31/2017.
 *
 * Moves an actor in a Veer Left movement (counter-clockwise, continuously expanding).
 */

public class VeerLeft {
    private int newDirection; // Declare the new direction
    private int[] newLocation = new int[2]; // Initialize new location
    private int[] results = new int[3]; // Initialize new direction

    public int[] moveVeerLeft(int row, int column, int dir, int frame){

        // Check whether the current frame is triangular, which requires a direction change
        if(new Triangular().checkIfTriangular(frame)){
            newDirection=dir !=0 ? dir-1 : 7; // If the current frame is a member of the triangular sequence, change direction
        }
        else{
            newDirection = dir; // Otherwise stay in the same direction
        }

        newLocation = new Line().moveLine(row, column, newDirection);
        results[0] = newLocation[0]; // Store location
        results[1] = newLocation[1];
        results[3] = newDirection; // Store direction

        return results; // Return all the results
    }
}
