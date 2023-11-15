package com.example.assignment4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class AddWord extends AppCompatActivity {
    Button addWordButton;
    Button cancelButton;
    boolean duplicate;
    FirebaseDatabase database;
    DatabaseReference reference;
    TextView addWordTV;
    ArrayList<Word> words;
    EditText addWordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        //create buttons
        addWordButton = findViewById(R.id.addDB_button);
        addWordButton.setOnClickListener(addWordListener);
        cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(cancelListener);
        addWordTV = findViewById(R.id.add_text);

        //Firebase
        database = FirebaseDatabase.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        addWordInput = findViewById(R.id.addWordInput);

        duplicate = false;











    }

    View.OnClickListener addWordListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView wordInput = findViewById(R.id.addWordInput);
            String sWordInput = wordInput.getText().toString();
            Boolean verify;
            verify = true;

            //check if null
            if(sWordInput.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please enter a word", Toast.LENGTH_SHORT).show();
                verify = false;
                addWordTV.setTextColor(getResources().getColor(R.color.purple));
            }

            //check if 5 characters long
            if(sWordInput.length() != 5){
                Toast.makeText(getApplicationContext(), "Please enter a 5 letter word", Toast.LENGTH_SHORT).show();
                verify = false;
                addWordTV.setTextColor(getResources().getColor(R.color.purple));
            }

            //check if alphabetical characters
            if(!sWordInput.matches("[a-zA-Z]+")){
                Toast.makeText(getApplicationContext(), "Please enter only alphabetical letters", Toast.LENGTH_SHORT).show();
                verify = false;
                addWordTV.setTextColor(getResources().getColor(R.color.purple));
            }

            reference.addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            int count = 0;
                            int index = (int) snapshot.getChildrenCount();
                            Iterator<DataSnapshot> options = snapshot.getChildren().iterator();
                            while(count < index){
                                Word word = options.next().getValue(Word.class);
                                if(word.getWord().toLowerCase().equals(sWordInput.toLowerCase())){
                                  duplicate = true;
                                }
                                count++;
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    }
            );


            if(duplicate){
                verify = false;
                Toast.makeText(getApplicationContext(), "A duplicate word was entered", Toast.LENGTH_SHORT).show();
            }
                            //Stored in database
            if(verify){
                Toast.makeText(getApplicationContext(), "The information was stored in the database", Toast.LENGTH_SHORT).show();
                String uid = reference.push().getKey();
                Word word = new Word();
                word.setWord(sWordInput);
                reference.child(uid).setValue(word);




               addWordInput.setText("");




            }



        }
    };
    View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), WordyActivity.class);
            startActivity(intent);
            setContentView(R.layout.activity_wordy);
        }
    };
}