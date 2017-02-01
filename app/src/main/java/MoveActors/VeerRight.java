package MoveActors;

/**
 * Created by Michael on 1/31/2017.
 */

public class VeerRight {
    private int newDirection; // Initialize the new direction

    public int[] moveVeerRight(int row, int column, int dir, int frame){

        // Check whether the current frame is triangular, which requires a direction change
        if(new Triangular().checkIfTriangular(frame)){
            if(dir!=7){ // Check you are not moving to the upper left
                newDirection=dir+1; // If the current frame is a member of the triangular sequence, change direction.
            }
            else{
                newDirection=0; // If moving to the upper left before, now move up
            }
        }

        return new Line().moveLine(row, column, newDirection); // Return the new location arrayMoveLine
    }


}
