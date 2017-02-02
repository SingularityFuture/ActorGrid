package MoveActors;

import java.util.ArrayList;

import Actors.ActorDefinition;

/**
 * Created by Michael on 2/1/2017.
 *
 * Run simulations given number of frames and actor traits.
 */

public class Simulator {
    private ArrayList<String> results; // Declare list of simulation results

    public ArrayList<String> runSimulation(ArrayList<ActorDefinition> actorList, int gridRows, int gridColumns, int frameTotal){

        int[] newLocation = new int[2]; // Initialize the new location array.
        for(int frame=2; frame<=frameTotal; frame++) { // Iterate through each frame of the list
            for (ActorDefinition actor : actorList) { // For each actor in the collection
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
                        newLocation = new VeerLeft().moveVeerLeft(actor.getRow(),actor.getColumn(),actor.getDir(),frame);
                        break;
                    case VR : // If type Veer Right
                        // Make it veer clockwise in a widening fashion
                        newLocation = new VeerRight().moveVeerRight(actor.getRow(),actor.getColumn(),actor.getDir(),frame);
                        break;
                    case R : // If type Random
                        // Give it a random new location
                        newLocation = new RandomActor().moveRandom(gridRows,gridColumns);
                        break;
                }
                actor.setRow(newLocation[0]);
                actor.setColumn(newLocation[1]);

                results.add(String.valueOf(frame)+','+String.valueOf(actor.getActorType())+','+String.valueOf(newLocation[0])+','+String.valueOf(newLocation[1]));
            }
        }
        return results;
    }
}
