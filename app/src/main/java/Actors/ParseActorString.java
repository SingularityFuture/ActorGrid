package Actors;

/**
 * Created by Michael on 2/1/2017.
 *
 * Parse the input actor behavior string and throw errors if anything is wrong
 */

public class ParseActorString {
    private String[] splitInput; // Declare result

    public String[] parseToDefinition(String input, int gridRows, int gridColumns){
        splitInput = input.split("\\s+"); // Split the string up using spaces
        if(splitInput.length>4){ // If the number of arguments after split is >4, throw error
            throw new IllegalArgumentException("Only 4 inputs separated by spaces can be entered"); // Throw wrong argument count exception
        }
        else if(splitInput.length==0){ // If the user didn't enter anything
            throw new IllegalArgumentException("You must enter in at least a random actor"); // Throw wrong argument count exception
        }
        else if(!new ActorValidate().validateActorType(splitInput[0])){ // Validate the actor type
            throw new IllegalArgumentException("Actor is not of type L, S, VL, VR, or R"); // Throw invalid actor exception
        }
        else if(!splitInput[0].equalsIgnoreCase("R") && splitInput.length<3){ // If the user didn't enter location
            throw new IllegalArgumentException("You must enter in initial location at least if not a random actor"); // Throw wrong argument count exception
        }
        else if(!splitInput[0].equalsIgnoreCase("S") && !splitInput[0].equalsIgnoreCase("R") && splitInput.length<4){ // If the user didn't enter in location and/or direction
            throw new IllegalArgumentException("You must enter in direction and location if not a random or still actor"); // Throw wrong argument count exception
        }
        else if (splitInput.length>1) { // Enter in all the rest of the information for all types for any length
            if (!new ActorValidate().validateInitialRow(Integer.valueOf(splitInput[1]), gridRows)) { // Validate the input row
                throw new IllegalArgumentException("Initial row is not >=0 and <max rows"); // Throw invalid row exception
            }
        }
        else if (splitInput.length>2) {
            if (!new ActorValidate().validateInitialColumn(Integer.valueOf(splitInput[2]), gridColumns)) { // Validate the input column
                throw new IllegalArgumentException("Initial column is not >=0 and <max columns"); // Throw invalid column exception
            }
        }
        else if (splitInput.length>3){
            if (!new ActorValidate().validateDirection(Integer.valueOf(splitInput[3]))) { // Validate the input direction
                throw new IllegalArgumentException("Initial direction is not between 0 and 7"); // Throw invalid direction exception
            }
        }

        return splitInput;
    }
}
