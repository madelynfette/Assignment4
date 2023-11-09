package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WordyActivity extends AppCompatActivity {

    //create buttons
    Button submit_button;
    Button addWord_button;
    Button restart_button;
    Button clear_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordy);


        //initialize buttons
        submit_button = findViewById(R.id.submit_button);

        addWord_button = findViewById(R.id.addWord_button);
        addWord_button.setOnClickListener(addWordListener);

        restart_button = findViewById(R.id.restart_button);

        clear_button = findViewById(R.id.clear_button);



    }

    View.OnClickListener addWordListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), AddWord.class);
            startActivity(intent);
        }
    };
}