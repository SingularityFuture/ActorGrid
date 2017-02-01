package Actors;

/**
 * Created by Michael on 2/1/2017.
 *
 * List of possible attributes for each actor
 */

public class ActorDefinition {

    ValidActors actorType; // Defines the behavior of the actor
    private int row; // Initial row position
    private int column; // Initial column position
    private int dir; // Initial direction

    public ActorDefinition(ValidActors actorType, int ...simParameters) {
        this.actorType = actorType; // Must at least have an actor type (minimum allowed for Random type)
        if(simParameters.length>0 ) {
            this.row = simParameters[0];
        }
        if(simParameters.length>1) {
            this.column = simParameters[1];
        }
        if(simParameters.length>2){
            this.dir = simParameters[2];
        }
    }
}
