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

    public ArrayList<String> runSimulation(ArrayList<ActorDefinition> actorList, int gridRows, int gridColumns, int frameTotal){

        // Start off the 0 "first" frame with the initial locations
        for (ActorDefinition actor : actorList) { // For each actor in the collection
            // Add the initial locations to frame 0 in results!
            results.add("0" + ',' + String.valueOf(actor.getActorType()) + ',' + actor.getRow() + ',' + actor.getColumn());
        }

        //ActorDefinition actor = new ActorDefinition();
        for(int frame=2; frame<=frameTotal; frame++) { // Iterate through each frame of the list
            for (ActorDefinition actor : actorList) { // For each actor in the collection
                int[] newLocation = new int[2]; // Initialize the new location array.
                int[] veerResults; // Initialize results array for VeerRight and VeerLeft
                switch (actor.getActorType()){ // Switch between the types
                    case L : // If type Line
                        newLocation = new Line().moveLine(actor.getRow(),actor.getColumn(),actor.getDir()); // Make it move in a line
                        break;
                    case S: // If type Still
                        newLocation[0]=actor.getRow(); // Keep him in the same place
                        newLocation[1]=actor.getColumn();
                        break;
                    case VL : // If type Veer Left
                        // Make it veer counter-clockwise in a widening fashion
                        veerResults = new VeerLeft().moveVeerLeft(actor.getRow(),actor.getColumn(),actor.getDir(),frame);
                        newLocation[0] = veerResults[0]; // Set row result
                        newLocation[1] = veerResults[1]; // Set column result
                        actor.setDir(veerResults[2]); // Set new direction
                        break;
                    case VR : // If type Veer Right
                        // Make it veer clockwise in a widening fashion
                        veerResults = new VeerRight().moveVeerRight(actor.getRow(),actor.getColumn(),actor.getDir(),frame);
                        newLocation[0] = veerResults[0]; // Set row result
                        newLocation[1] = veerResults[1]; // Set column result
                        actor.setDir(veerResults[2]); // Set new direction
                        break;
                    case R : // If type Random
                        // Give it a random new location
                        newLocation = new RandomActor().moveRandom(gridRows,gridColumns);
                        break;
                }
                actor.setRow(newLocation[0]); // Set the new row
                actor.setColumn(newLocation[1]); // Set the new column

                // Add the current results to the list of strings in results!
                results.add(String.valueOf(frame-1)+','+String.valueOf(actor.getActorType())+','+String.valueOf(newLocation[0])+','+String.valueOf(newLocation[1]));
            }
        }
        return results;
    }
}
