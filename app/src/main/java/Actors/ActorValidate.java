package Actors;

/**
 * Created by Michael on 2/1/2017.
 *
 * Validates actor definition inputs before creation of Actor object
 */

public class ActorValidate {

    public boolean validateActorType(String actor){ // Make sure input actor string matches valid types
        for(ValidActors instance : ValidActors.values()){
            if(actor.equalsIgnoreCase(instance.toString())){ // Compare to all values, ignoring case
                return true; // Return true if you find a match
            }
        }
        return false;
    }

    public boolean validateInitialRow(int row, int gridRows){
        return row < gridRows;
    }

    public boolean validateInitialColumn(int column, int gridColumns){
        return column < gridColumns;
    }

    public boolean validateDirection(int dir){
        return dir >= 0 && dir < 8;
    }
}
