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

public class MainActivity extends AppCompatActivity {

    private Button runButton; // Button that runs the simulation
    public int gridRows; // Number of rows on grid
    public int gridColumns; // Number of columns on grid
    public List<String> actors = new ArrayList<String>(); // Create list for all actors' traits
    public int numberOfActors; // Number of actors

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfActors=getResources().getInteger(R.integer.default_actors); // Set the initial # of actors

        LinearLayout layout = (LinearLayout)findViewById(R.id.activity_main); // Get the main activity
        for (int i = 1; i < layout.getChildCount(); i++) { // For each element in the layout, starting after the first TextView
            View v = layout.getChildAt(i); // Get each child
            if (v instanceof EditText && i<=numberOfActors) { // If this is an EditText element and its within the actor section
                actors.add(getResources().getStringArray(R.array.actor_array)[i-1]); // Set the initial actor traits
                addActorTextListener((EditText) v); // Add a listener to the EditText view if the input changes
            }
            else if (v instanceof EditText && i>numberOfActors && i<=numberOfActors+2) { // If its in the grid row and column section,
                addGridRowColumnListener((EditText) v); // Then add a listener for that
            }
            else if (v instanceof EditText && i==numberOfActors+3) { // If this is the frame input
                addFrameListener((EditText) v); // Then add a listener for that
            }
        }
        addRunButtonListener();
        //actorText.performClick();
    }

    public void addActorTextListener(final EditText actorText){

        actorText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                Toast.makeText(MainActivity.this, "Actor information entered", Toast.LENGTH_SHORT).show(); // Test listener with toast.
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Get the keyboard
                mgr.hideSoftInputFromWindow(actorText.getWindowToken(), 0); // Get the keyboard

                handled = true;
            }
            return handled;
        }
        });
    }

    public void addGridRowColumnListener(final EditText gridText){

        gridText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Toast.makeText(MainActivity.this, "Grid information entered", Toast.LENGTH_SHORT).show(); // Test listener with toast.
                    InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Get the keyboard
                    mgr.hideSoftInputFromWindow(gridText.getWindowToken(), 0); // Hide the keyboard

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
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Toast.makeText(MainActivity.this, "Frame information entered", Toast.LENGTH_SHORT).show(); // Test listener with toast.
                    InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Get the keyboard
                    mgr.hideSoftInputFromWindow(frameText.getWindowToken(), 0); // Hide keyboard

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
                // Test listener with toast.
                Toast.makeText(MainActivity.this, "Running Simulation", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
