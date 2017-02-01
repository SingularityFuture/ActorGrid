package Actors;

import java.util.ArrayList;

/**
 * Created by Michael on 2/1/2017.
 */

public class ParseActorString {
    private ArrayList<String> definition;
    Exception badInput;

    public ArrayList<String> parseToDefinition(String input){
        String[] splitInput = input.split("\\s+");
        if(splitInput.length>4){
            throw new IllegalArgumentException("Only 4 inputs separated by spaces can be entered"); // Throw wrong argument count exception
        }
        else if(!new ActorValidate().validateActorType(splitInput[0])){
            throw new IllegalArgumentException("Actor is not of type L, S, VL, VR, or R"); // Throw invalid actor exception

        }

        return definition;
    }

}
