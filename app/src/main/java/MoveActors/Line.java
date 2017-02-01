package MoveActors;

/**
 * Created by Michael on 1/31/2017.
 */

public class Line {
    private int[] newLocation; // Initialize the new location array

    public int[] moveLine(int row, int column, int dir){
        newLocation = new int[] {row, column}; // Put the current row and column as initial values to reduce conditions below
        if(dir<2 || dir==7){ // If direction is above
            newLocation[0]=row-1; // Subtract a row
        }
        else if(dir<6 && dir>2){ // If direction is below
            newLocation[0]=row+1; // Add a row
        }

        if(dir<4 && dir>0) { // If direction is right
            newLocation[1] = column+1; // Add a column
        }
        else if(dir>4){ // If direction is left
            newLocation[1] = column-1; // Subtract a column
        }

        return newLocation; // Return the new location arrayMoveLine
    }
}
