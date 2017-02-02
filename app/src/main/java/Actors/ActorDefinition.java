package Actors;

/**
 * Created by Michael on 2/1/2017.
 *
 * List of possible attributes for each actor
 */

public class ActorDefinition {

    private ValidActors actorType; // Defines the behavior of the actor
    private int row; // Initial row position
    private int column; // Initial column position
    private int dir; // Initial direction

    public ActorDefinition(){
    }

    public void setter(ValidActors actorType, int ...simParameters) { // Setter method for variety of parameters, with actorType first
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

    public void setRow(int row) { // Setter for row
        this.row = row;
    }

    public void setColumn(int column) { // Setter for column
        this.column = column;
    }

    public ValidActors getActorType() { // Get method
        return this.actorType;
    } // Getter for actorType

    public int getRow() { // Get method
        return this.row;
    } // Getter for row

    public int getColumn() { // Get method
        return this.column;
    } // Getter for column

    public int getDir() { // Get method
        return this.dir;
    } // Getter for direction
}
