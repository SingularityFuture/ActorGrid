package MoveActors;

/**
 * Created by Michael on 1/31/2017.
 */

public class MoveLine {
    public int[] NewLocation; // Initialize the new location array

    public int[] MoveLine(int row, int column, int dir){
        NewLocation = new int[] {row, column}; // Put the current row and column as initial values to reduce conditions below
        if(dir<2 || dir==7){ // If direction is above
            NewLocation[0]=row-1; // Subtract a row
        }
        else if(dir<6 && dir>2){ // If direction is below
            NewLocation[0]=row+1; // Add a row
        }

        if(dir<4 && dir>0) { // If direction is right
            NewLocation[1] = column+1; // Add a column
        }
        else if(dir>4){ // If direction is left
            NewLocation[1] = column-1; // Subtract a column
        }

        return NewLocation; // Return the new location array
    }
}
