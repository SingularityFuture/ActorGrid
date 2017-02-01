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

    public ActorDefinition(ValidActors actorType, int row, int column, int dir) {
        this.actorType = actorType;
        this.row = row;
        this.column = column;
        this.dir = dir;
    }
}
