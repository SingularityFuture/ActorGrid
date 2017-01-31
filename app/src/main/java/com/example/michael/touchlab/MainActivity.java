package com.example.michael.touchlab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button runButton;
    private EditText actorText;
    public int gridRows;
    public int gridColumns;
    public String[] actors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addActorTextListener();
        addRunButtonListener();

        actorText.performClick();
    }

    public void addActorTextListener(){
        actorText = (EditText) findViewById(R.id.actor_1);



        actorText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });



    }

    public void addRunButtonListener(){
        runButton = (Button) findViewById(R.id.run_simulation);

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
