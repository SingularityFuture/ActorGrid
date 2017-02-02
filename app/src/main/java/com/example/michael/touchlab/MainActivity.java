package com.example.michael.touchlab;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Actors.ActorDefinition;
import Actors.ParseActorString;
import Actors.ValidActors;
import MoveActors.Simulator;

public class MainActivity extends AppCompatActivity {

    private Button runButton; // Button that runs the simulation
    public int gridRows; // Number of rows on grid
    public int gridColumns; // Number of columns on grid
    public int frames; // Number of frames run in simulation
    public List<String> actors = new ArrayList<>(); // Create list for all actors' traits
    public ActorDefinition actorObject = new ActorDefinition(); // Create an object for each actor object
    public ArrayList<ActorDefinition> parsedActorResults = new ArrayList<>(); // Create list of ActorDefinition objects, each of which holds the actor traits
    public int numberOfActors; // Number of actors

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfActors=getResources().getInteger(R.integer.default_actors); // Set the initial # of actors
        gridRows=getResources().getInteger(R.integer.default_rows); // Set the initial # of rows in the grid
        gridColumns=getResources().getInteger(R.integer.default_columns); // Set the initial # of columns in the grid
        frames=getResources().getInteger(R.integer.default_frames); // Set the initial # of frames in the simulation

        LinearLayout layout = (LinearLayout)findViewById(R.id.activity_main); // Get the main activity
        for (int i = 1; i < layout.getChildCount(); i++) { // For each element in the layout, starting after the first TextView
            View v = layout.getChildAt(i); // Get each child
            if (v instanceof EditText && i<=numberOfActors) { // If this is an EditText element and its within the actor section
                actors.add(getResources().getStringArray(R.array.actor_array)[i-1]); // Set the initial actor traits
                validateAndAdd((EditText) v, i-1); // Add the initial list to the collection of actors so it doesn't go out of bounds
                addActorTextListener((EditText) v, i-1); // Add a listener to the EditText view if the input changes
            }
            else if (v instanceof EditText && i==numberOfActors+1) { // If its in the grid row section,
                addGridRowListener((EditText) v); // Then add a listener for that
            }
            else if (v instanceof EditText && i==numberOfActors+2) { // If its in the grid column section,
                addGridColumnListener((EditText) v); // Then add a listener for that
            }
            else if (v instanceof EditText && i==numberOfActors+3) { // If this is the frame input
                addFrameListener((EditText) v); // Then add a listener for that
            }
        }
        addRunButtonListener();
    }

    public void addActorTextListener(final EditText actorText, final int index){

        actorText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView actorText, int actionId, KeyEvent event) {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_DONE) { // If user presses Enter
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Get the keyboard
                mgr.hideSoftInputFromWindow(actorText.getWindowToken(), 0); // Get the keyboard
                // Parse and validate here
                try{
                    validateAndAdd(actorText, index);
                    actors.set(index,actorText.getText().toString()); // Replace the default with the new input data only after validated
                    Toast.makeText(MainActivity.this, "Actor information entered \n"+actors.get(index), Toast.LENGTH_SHORT).show(); // Test listener with toast.
                    handled = true;
                }
                catch(IllegalArgumentException e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show(); // Display error message
                    //<font color='#EE0000'>
                }
            }
            return handled;
        }
        });
    }

    // Extract method to make it reusable so actorObject doesn't go out of bounds
    private void validateAndAdd(TextView actorText, int index) {
        String[] result = new ParseActorString().parseToDefinition(actorText.getText().toString(),gridRows,gridColumns); // Try to parse input string
        int lengthOfInput = result.length; // Store length of result.
        switch (lengthOfInput){ // Based the object definition on the length of the input
            case 1:
                actorObject.set(ValidActors.valueOf(result[0]));
                break;
            case 2:
                actorObject.set(ValidActors.valueOf(result[0]),Integer.valueOf(result[1]));
                break;
            case 3:
                actorObject.set(ValidActors.valueOf(result[0]),Integer.valueOf(result[1]),Integer.valueOf(result[2]));
                break;
            case 4:
                actorObject.set(ValidActors.valueOf(result[0]),Integer.valueOf(result[1]),Integer.valueOf(result[2]),Integer.valueOf(result[3]));
                break;
        }

        parsedActorResults.add(index,actorObject); // If the parsing works, add it to the list of Actor Results
    }

    public void addGridRowListener(final EditText gridText) {

        gridText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) { // If user presses Enter
                    Toast.makeText(MainActivity.this, "Grid rows entered", Toast.LENGTH_SHORT).show(); // Test listener with toast.
                    InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Get the keyboard
                    mgr.hideSoftInputFromWindow(gridText.getWindowToken(), 0); // Hide the keyboard

                    gridRows = Integer.valueOf(v.getText().toString()); // Replace the default with the new input data
                    handled = true;
                }
                return handled;
            }
        });
    }

    public void addGridColumnListener(final EditText gridText){

        gridText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView gridText, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) { // If user presses Enter
                    Toast.makeText(MainActivity.this, "Grid columns entered", Toast.LENGTH_SHORT).show(); // Test listener with toast.
                    InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Get the keyboard
                    mgr.hideSoftInputFromWindow(gridText.getWindowToken(), 0); // Hide the keyboard

                    gridColumns=Integer.valueOf(gridText.getText().toString()); // Replace the default with the new input data
                    handled = true;
                }
                return handled;
            }
        });
    }

    public void addFrameListener(final EditText frameText){

        frameText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) { // If user presses Enter
                    Toast.makeText(MainActivity.this, "Frame information entered", Toast.LENGTH_SHORT).show(); // Test listener with toast.
                    InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Get the keyboard
                    mgr.hideSoftInputFromWindow(frameText.getWindowToken(), 0); // Hide keyboard
                    frames=Integer.valueOf(frameText.getText().toString()); // Replace the default with the new input data

                    handled = true;
                }
                return handled;
            }
        });
    }

    public void addRunButtonListener(){
        runButton = (Button) findViewById(R.id.run_simulation);

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Running Simulation", Toast.LENGTH_SHORT).show(); // Test listener with toast.
                // Run the simulations with all the inputs and show the results!
                ArrayList<String> results = new Simulator().runSimulation(parsedActorResults,gridRows,gridColumns,frames);

            }
        });
    }
}
