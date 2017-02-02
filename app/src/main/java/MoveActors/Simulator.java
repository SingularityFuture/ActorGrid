package MoveActors;

import java.util.ArrayList;

import Actors.ActorDefinition;

/**
 * Created by Michael on 2/1/2017.
 *
 * Run simulations given number of frames and actor traits.
 */

public class Simulator {
    private ArrayList<String> results = new ArrayList<>(); // Declare list of simulation results
    /***
     *  @see <a href="http://softwareengineering.stackexchange.com/questions/286008/parameters-are-passed-by-value-but-editing-them-will-edit-the-actual-object-li">Passing in Java</a>
     */
    private ArrayList<ActorDefinition> privateActorList = new ArrayList<>(); // Declare a local variable you can change

    public ArrayList<String> runSimulation(ArrayList<ActorDefinition> actorList, int gridRows, int gridColumns, int frameTotal){

        // Start off the 0 "first" frame with the initial locations
        for (ActorDefinition actor : actorList) { // For each actor in the collection
            ActorDefinition newActor = new ActorDefinition(); // Make sure its totally new!
            newActor.setter(actor.getActorType(),actor.getRow(),actor.getColumn(),actor.getDir()); // Set with its variables
            privateActorList.add(newActor); // Copy to local list
        }
        for (ActorDefinition privateActor : privateActorList) { // For each actor in the collection
            // Add the initial locations to frame 0 in results!
            results.add("0" + ',' + String.valueOf(privateActor.getActorType()) + ',' + privateActor.getRow() + ',' + privateActor.getColumn());
        }

        //ActorDefinition actor = new ActorDefinition();
        for(int frame=2; frame<=frameTotal; frame++) { // Iterate through each frame of the list
            for (ActorDefinition privateActor : privateActorList) { // For each actor in the collection
                int[] newLocation = new int[2]; // Initialize the new location array.
                int[] veerResults; // Initialize results array for VeerRight and VeerLeft
                switch (privateActor.getActorType()){ // Switch between the types
                    case L : // If type Line
                        newLocation = new Line().moveLine(privateActor.getRow(),privateActor.getColumn(),privateActor.getDir()); // Make it move in a line
                        break;
                    case S: // If type Still
                        newLocation[0]=privateActor.getRow(); // Keep him in the same place
                        newLocation[1]=privateActor.getColumn();
                        break;
                    case VL : // If type Veer Left
                        // Make it veer counter-clockwise in a widening fashion
                        veerResults = new VeerLeft().moveVeerLeft(privateActor.getRow(),privateActor.getColumn(),privateActor.getDir(),frame);
                        newLocation[0] = veerResults[0]; // Set row result
                        newLocation[1] = veerResults[1]; // Set column result
                        privateActor.setDir(veerResults[2]); // Set new direction
                        break;
                    case VR : // If type Veer Right
                        // Make it veer clockwise in a widening fashion
                        veerResults = new VeerRight().moveVeerRight(privateActor.getRow(),privateActor.getColumn(),privateActor.getDir(),frame);
                        newLocation[0] = veerResults[0]; // Set row result
                        newLocation[1] = veerResults[1]; // Set column result
                        privateActor.setDir(veerResults[2]); // Set new direction
                        break;
                    case R : // If type Random
                        // Give it a random new location
                        newLocation = new RandomActor().moveRandom(gridRows,gridColumns);
                        break;
                }
                privateActor.setRow(newLocation[0]); // Set the new row
                privateActor.setColumn(newLocation[1]); // Set the new column

                // Add the current results to the list of strings in results!
                results.add(String.valueOf(frame-1)+','+String.valueOf(privateActor.getActorType())+','+String.valueOf(newLocation[0])+','+String.valueOf(newLocation[1]));
            }
        }
        return results;
    }
}
