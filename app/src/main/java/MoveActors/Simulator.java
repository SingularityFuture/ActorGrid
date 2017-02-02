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

        for(int frame=2; frame<=frameTotal; frame++) { // Iterate through each frame of the list
            for (ActorDefinition actor : actorList) {

            }
        }
        return results;
    }
}
