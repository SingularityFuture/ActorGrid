package Actors;

import java.util.ArrayList;

/**
 * Created by Michael on 2/1/2017.
 *
 * Parse the input actor behavior string and throw errors if anything is wrong
 */

public class ParseActorString {
    private ArrayList<String> definition; // Declare result

    public ArrayList<String> parseToDefinition(String input, int gridRows, int gridColumns){
        String[] splitInput = input.split("\\s+"); // Split the string up using spaces
        if(splitInput.length>4){ // If the numbero of arguments after split is >4, throw error
            throw new IllegalArgumentException("Only 4 inputs separated by spaces can be entered"); // Throw wrong argument count exception
        }
        else if(!new ActorValidate().validateActorType(splitInput[0])){ // Validate the actor type
            throw new IllegalArgumentException("Actor is not of type L, S, VL, VR, or R"); // Throw invalid actor exception
        }
        else if(!new ActorValidate().validateInitialRow(Integer.valueOf(splitInput[1]), gridRows)){ // Validate the input row
            throw new IllegalArgumentException("Initial row is not >=0 and <max rows"); // Throw invalid row exception
        }
        else if(!new ActorValidate().validateInitialColumn(Integer.valueOf(splitInput[2]), gridColumns)){ // Validate the input column
            throw new IllegalArgumentException("Initial column is not >=0 and <max columns"); // Throw invalid column exception
        }
        else if(!new ActorValidate().validateDirection(Integer.valueOf(splitInput[3]))){ // Validate the input direction
            throw new IllegalArgumentException("Initial direction is not between 0 and 7"); // Throw invalid direction exception
        }

        return definition;
    }

}
