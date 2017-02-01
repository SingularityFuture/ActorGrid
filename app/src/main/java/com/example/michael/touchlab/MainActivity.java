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

    private Button runButton;
    public int gridRows;
    public int gridColumns;
    public List<String> actors = new ArrayList<String>();
    public int numberOfActors;
    //public int numberOfActors=getResources().getInteger(R.integer.default_actors);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberOfActors=getResources().getInteger(R.integer.default_actors); // Set the initial # of actors

        LinearLayout layout = (LinearLayout)findViewById(R.id.activity_main);
        for (int i = 1; i < layout.getChildCount(); i++) {
            View v = layout.getChildAt(i);
            if (v instanceof EditText && i<=numberOfActors) {
                actors.add(getResources().getStringArray(R.array.actor_array)[i]); // Set the initial actor traits
                addActorTextListener((EditText) v);
            }
            else if (v instanceof EditText && i>numberOfActors) {
                addGridRowColumnListener((EditText) v);
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
                // Test listener with toast.
                Toast.makeText(MainActivity.this, "Actor information entered", Toast.LENGTH_SHORT).show();
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Hide keyboard
                mgr.hideSoftInputFromWindow(actorText.getWindowToken(), 0);

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
                    // Test listener with toast.
                    Toast.makeText(MainActivity.this, "Grid information entered", Toast.LENGTH_SHORT).show();
                    InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // Hide keyboard
                    mgr.hideSoftInputFromWindow(gridText.getWindowToken(), 0);

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
