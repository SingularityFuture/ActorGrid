package MoveActors;

/**
 * Created by Michael on 1/31/2017.
 *
 * Moves an actor in a Veer Right movement (clockwise, continuously expanding).
 */

public class VeerRight {
    // Declare the new direction
    private int newDirection;

    public int[] moveVeerRight(int row, int column, int dir, int frame){

        // Check whether the current frame is triangular, which requires a direction change
        if(new Triangular().checkIfTriangular(frame)){
            newDirection=dir !=7 ? dir+1 : 0; // If the current frame is a member of the triangular sequence, change direction
        }
        else{
            newDirection=dir; // Otherwise continue in the same direction
        }

        return new Line().moveLine(row, column, newDirection); // Return the new location arrayMoveLine
    }


}
