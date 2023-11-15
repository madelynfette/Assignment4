package com.example.assignment4;

import static android.R.layout.simple_list_item_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.collection.LLRBNode;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class WordyActivity extends AppCompatActivity {

    //create buttons
    Button submit_button;
    Button addWord_button;
    Button restart_button;
    Button clear_button;
    int clickCount;

    TextView outcome;

    String target;

    FirebaseDatabase database;
    DatabaseReference reference;


    EditText editText1, editText2, editText3, editText4, editText5,
            editText6, editText7, editText8, editText9, editText10,
            editText11, editText12, editText13, editText14, editText15,
            editText16, editText17, editText18, editText19, editText20,
            editText21, editText22, editText23, editText24, editText25,
            editText26, editText27, editText28, editText29, editText30;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordy);


        //initialize buttons
        submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(submitListener);
        addWord_button = findViewById(R.id.addWord_button);
        addWord_button.setOnClickListener(addWordListener);
        restart_button = findViewById(R.id.restart_button);
        restart_button.setOnClickListener(restartListener);
        clear_button = findViewById(R.id.clear_button);
        clear_button.setOnClickListener(clearListener);


        //initialize textViews
        editText1 = findViewById(R.id.tv1);
        editText2 = findViewById(R.id.tv2);
        editText3 = findViewById(R.id.tv3);
        editText4 = findViewById(R.id.tv4);
        editText5 = findViewById(R.id.tv5);
        editText6 = findViewById(R.id.tv6);
        editText7 = findViewById(R.id.tv7);
        editText8 = findViewById(R.id.tv8);
        editText9 = findViewById(R.id.tv9);
        editText10 = findViewById(R.id.tv10);
        editText11 = findViewById(R.id.tv11);
        editText12 = findViewById(R.id.tv12);
        editText13 = findViewById(R.id.tv13);
        editText14 = findViewById(R.id.tv14);
        editText15 = findViewById(R.id.tv15);
        editText16 = findViewById(R.id.tv16);
        editText17 = findViewById(R.id.tv17);
        editText18 = findViewById(R.id.tv18);
        editText19 = findViewById(R.id.tv19);
        editText20 = findViewById(R.id.tv20);
        editText21 = findViewById(R.id.tv21);
        editText22 = findViewById(R.id.tv22);
        editText23 = findViewById(R.id.tv23);
        editText24 = findViewById(R.id.tv24);
        editText25 = findViewById(R.id.tv25);
        editText26 = findViewById(R.id.tv26);
        editText27 = findViewById(R.id.tv27);
        editText28 = findViewById(R.id.tv28);
        editText29 = findViewById(R.id.tv29);
        editText30 = findViewById(R.id.tv30);

        //disable all EditTexts but the first row
        editText1.setEnabled(true);
        editText2.setEnabled(true);
        editText3.setEnabled(true);
        editText4.setEnabled(true);
        editText5.setEnabled(true);
        editText6.setEnabled(false);
        editText7.setEnabled(false);
        editText8.setEnabled(false);
        editText9.setEnabled(false);
        editText10.setEnabled(false);
        editText11.setEnabled(false);
        editText12.setEnabled(false);
        editText13.setEnabled(false);
        editText14.setEnabled(false);
        editText15.setEnabled(false);
        editText16.setEnabled(false);
        editText17.setEnabled(false);
        editText18.setEnabled(false);
        editText19.setEnabled(false);
        editText20.setEnabled(false);
        editText21.setEnabled(false);
        editText22.setEnabled(false);
        editText23.setEnabled(false);
        editText24.setEnabled(false);
        editText25.setEnabled(false);
        editText26.setEnabled(false);
        editText27.setEnabled(false);
        editText28.setEnabled(false);
        editText29.setEnabled(false);
        editText30.setEnabled(false);

        outcome = findViewById(R.id.outcomeTV);
        outcome.setText("");

        //Firebase
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        setWord();





    }

    View.OnClickListener addWordListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            outcome.setText("");
            Intent intent = new Intent(getApplicationContext(), AddWord.class);
            startActivity(intent);
            setContentView(R.layout.activity_add_word);
        }
    };

    View.OnClickListener submitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clickCount ++;
            outcome.setText("");


            //initialize the strings
            String letterOne = new String();
            String letterTwo = new String();
            String letterThree = new String();
            String letterFour = new String();
            String letterFive = new String();
            String letterSix = new String();
            String letterSeven = new String();
            String letterEight = new String();
            String letterNine = new String();
            String letterTen = new String();
            String letterEleven = new String();
            String letterTwelve = new String();
            String letterThirteen = new String();
            String letterFourteen = new String();
            String letterFifteen = new String();
            String letterSixteen = new String();
            String letterSeventeen = new String();
            String letterEighteen = new String();
            String letterNineteen = new String();
            String letterTwenty = new String();
            String letterTwentyOne = new String();
            String letterTwentyTwo = new String();
            String letterTwentyThree = new String();
            String letterTwentyFour = new String();
            String letterTwentyFive = new String();
            String letterTwentySix = new String();
            String letterTwentySeven = new String();
            String letterTwentyEight = new String();
            String letterTwentyNine = new String();
            String letterThirty = new String();



            //get the inputs from the EditTexts
            letterOne = editText1.getText().toString().trim();
            letterTwo = editText2.getText().toString().trim();
            letterThree = editText3.getText().toString().trim();
            letterFour = editText4.getText().toString().trim();
            letterFive = editText5.getText().toString().trim();
            letterSix = editText6.getText().toString().trim();
            letterSeven = editText7.getText().toString().trim();
            letterEight = editText8.getText().toString().trim();
            letterNine = editText9.getText().toString().trim();
            letterTen = editText10.getText().toString().trim();
            letterEleven = editText11.getText().toString().trim();
            letterTwelve = editText12.getText().toString().trim();
            letterThirteen = editText13.getText().toString().trim();
            letterFourteen = editText14.getText().toString().trim();
            letterFifteen = editText15.getText().toString().trim();
            letterSixteen = editText16.getText().toString().trim();
            letterSeventeen = editText17.getText().toString().trim();
            letterEighteen = editText18.getText().toString().trim();
            letterNineteen = editText19.getText().toString().trim();
            letterTwenty = editText20.getText().toString().trim();
            letterTwentyOne = editText21.getText().toString().trim();
            letterTwentyTwo = editText22.getText().toString().trim();
            letterTwentyThree = editText23.getText().toString().trim();
            letterTwentyFour = editText24.getText().toString().trim();
            letterTwentyFive = editText25.getText().toString().trim();
            letterTwentySix = editText26.getText().toString().trim();
            letterTwentySeven = editText27.getText().toString().trim();
            letterTwentyEight = editText28.getText().toString().trim();
            letterTwentyNine = editText29.getText().toString().trim();
            letterThirty = editText30.getText().toString().trim();

            //make the right text views available upon submission
            if(clickCount == 1){
                editText1.setEnabled(false);
                editText6.setEnabled(true);
            }
            if(clickCount == 1){
                editText2.setEnabled(false);
                editText7.setEnabled(true);
            }
            if(clickCount == 1){
                editText3.setEnabled(false);
                editText8.setEnabled(true);
            }
            if(clickCount == 1){
                editText4.setEnabled(false);
                editText9.setEnabled(true);

            }if(clickCount == 1){
                editText5.setEnabled(false);
                editText10.setEnabled(true);
            }
            if(clickCount == 2){
                editText6.setEnabled(false);
                editText11.setEnabled(true);
            }
            if(clickCount == 2){
                editText7.setEnabled(false);
                editText12.setEnabled(true);
            }
            if(clickCount == 2){
                editText8.setEnabled(false);
                editText13.setEnabled(true);
            }
            if(clickCount == 2){
                editText9.setEnabled(false);
                editText14.setEnabled(true);

            }if(clickCount == 2){
                editText10.setEnabled(false);
                editText15.setEnabled(true);
            }
            if(clickCount == 3){
                editText11.setEnabled(false);
                editText16.setEnabled(true);
            }
            if(clickCount == 3){
                editText12.setEnabled(false);
                editText17.setEnabled(true);
            }
            if(clickCount == 3){
                editText13.setEnabled(false);
                editText18.setEnabled(true);
            }
            if(clickCount == 3){
                editText14.setEnabled(false);
                editText19.setEnabled(true);

            }if(clickCount == 3){
                editText15.setEnabled(false);
                editText20.setEnabled(true);
            }
            if(clickCount == 4){
                editText16.setEnabled(false);
                editText21.setEnabled(true);
            }
            if(clickCount == 4){
                editText17.setEnabled(false);
                editText22.setEnabled(true);
            }
            if(clickCount == 4){
                editText18.setEnabled(false);
                editText23.setEnabled(true);
            }
            if(clickCount == 4){
                editText19.setEnabled(false);
                editText24.setEnabled(true);

            }if(clickCount == 4){
                editText20.setEnabled(false);
                editText25.setEnabled(true);
            }
            if(clickCount == 5){
                editText21.setEnabled(false);
                editText26.setEnabled(true);
            }
            if(clickCount == 5){
                editText22.setEnabled(false);
                editText27.setEnabled(true);
            }
            if(clickCount == 5){
                editText23.setEnabled(false);
                editText28.setEnabled(true);
            }
            if(clickCount == 5){
                editText24.setEnabled(false);
                editText29.setEnabled(true);

            }if(clickCount == 5){
                editText25.setEnabled(false);
                editText30.setEnabled(true);
            }
            if(clickCount == 6){
                editText26.setEnabled(false);
            }
            if(clickCount == 6){
                editText27.setEnabled(false);
            }
            if(clickCount == 6){
                editText28.setEnabled(false);
            }
            if(clickCount == 6){
                editText29.setEnabled(false);
            }
            if(clickCount == 6){
                editText30.setEnabled(false);
            }


            String targlet1 = String.valueOf(target.charAt(0));
            String targlet2 = String.valueOf(target.charAt(1));
            String targlet3 = String.valueOf(target.charAt(2));
            String targlet4 = String.valueOf(target.charAt(3));
            String targlet5 = String.valueOf(target.charAt(4));

            //Round 1
            boolean r1l1 = false;
            boolean r1l2 = false;
            boolean r1l3 = false;
            boolean r1l4 = false;
            boolean r1l5 = false;

            //check 1
            if(clickCount == 1){
            if(letterOne.matches(targlet1)){
                editText1.setBackgroundColor(getResources().getColor(R.color.green));
                r1l1 = true;
            }
            else if(letterOne.matches(targlet2) || letterOne.matches(targlet3) || letterOne.matches(targlet4) || letterOne.matches(targlet5)){
                editText1.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText1.setBackgroundColor(getResources().getColor(R.color.gray));}

            //check 2
            if(letterTwo.matches(targlet2)){
                editText2.setBackgroundColor(getResources().getColor(R.color.green));
                r1l2 = true;
            }
            else if(letterTwo.matches(targlet1) || letterTwo.matches(targlet3) || letterTwo.matches(targlet4)|| letterTwo.matches(targlet5)){
                editText2.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText2.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 3
            if(letterThree.matches(targlet3)){
                editText3.setBackgroundColor(getResources().getColor(R.color.green));
                r1l3 = true;
            }
            else if(letterThree.matches(targlet1) || letterThree.matches(targlet2) || letterThree.matches(targlet4)|| letterThree.matches(targlet5)){
                editText3.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText3.setBackgroundColor(getResources().getColor(R.color.gray));}



            //check 4
            if(letterFour.matches(targlet4)){
                editText4.setBackgroundColor(getResources().getColor(R.color.green));
                r1l4 = true;
            }
            else if(letterFour.matches(targlet1) || letterFour.matches(targlet2) || letterFour.matches(targlet3)|| letterFour.matches(targlet5)){
                editText4.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText4.setBackgroundColor(getResources().getColor(R.color.gray));}

            //check 5
            if(letterFive.matches(targlet5)){
                editText5.setBackgroundColor(getResources().getColor(R.color.green));
                r1l5 = true;
            }
            else if(letterFive.matches(targlet1) || letterFive.matches(targlet2) || letterFive.matches(targlet3)|| letterFive.matches(targlet4)){
                editText5.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText5.setBackgroundColor(getResources().getColor(R.color.gray));}}


            //check for win
            if(r1l1 && r1l2 && r1l3 && r1l4 && r1l5){
                outcome.setText("You Win!!");
            }





          // Round 2
            boolean r2l1 = false;
            boolean r2l2 = false;
            boolean r2l3 = false;
            boolean r2l4 = false;
            boolean r2l5 = false;
            if(clickCount == 2){
            //check 6
            if(letterSix.matches(targlet1)){
                editText6.setBackgroundColor(getResources().getColor(R.color.green));
                r2l1 = true;
            }
            else if(letterSix.matches(targlet2) || letterSix.matches(targlet3) || letterSix.matches(targlet4) || letterSix.matches(targlet5)){
                editText6.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText6.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 7
            if(letterSeven.matches(targlet2)){
                editText7.setBackgroundColor(getResources().getColor(R.color.green));
                r2l2 = true;
            }
            else if(letterSeven.matches(targlet1) || letterSeven.matches(targlet3) || letterSeven.matches(targlet4)|| letterSeven.matches(targlet5)){
                editText7.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText7.setBackgroundColor(getResources().getColor(R.color.gray));}

            //check 8
            if(letterEight.matches(targlet3)){
                editText8.setBackgroundColor(getResources().getColor(R.color.green));
                r2l3 = true;
            }
            else if(letterEight.matches(targlet1) || letterEight.matches(targlet2) || letterEight.matches(targlet4)|| letterEight.matches(targlet5)){
                editText8.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText8.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 9
            if(letterNine.matches(targlet4)){
                editText9.setBackgroundColor(getResources().getColor(R.color.green));
                r2l4 = true;
            }
            else if(letterNine.matches(targlet1) || letterNine.matches(targlet2) || letterNine.matches(targlet3)|| letterNine.matches(targlet5)){
                editText9.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText9.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 10
            if(letterTen.matches(targlet5)){
                editText10.setBackgroundColor(getResources().getColor(R.color.green));
                r2l5 = true;
            }
            else if(letterTen.matches(targlet1) || letterTen.matches(targlet2) || letterTen.matches(targlet3)|| letterTen.matches(targlet4)){
                editText10.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText10.setBackgroundColor(getResources().getColor(R.color.gray));}}



            //check outcome
            if(r2l1 && r2l2 && r2l3 && r2l4 && r2l5){
                outcome.setText("You Win!!");
            }

            // Round 3
            boolean r3l1 = false;
            boolean r3l2 = false;
            boolean r3l3 = false;
            boolean r3l4 = false;
            boolean r3l5 = false;
            if(clickCount == 3){
            //check 11
            if(letterEleven.matches(targlet1)){
                editText11.setBackgroundColor(getResources().getColor(R.color.green));
                r3l1 = true;
            }
            else if(letterEleven.matches(targlet2) || letterEleven.matches(targlet3) || letterEleven.matches(targlet4) || letterEleven.matches(targlet5)){
                editText11.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText11.setBackgroundColor(getResources().getColor(R.color.gray));}



            //check 12
            if(letterTwelve.matches(targlet2)){
                editText12.setBackgroundColor(getResources().getColor(R.color.green));
                r3l2 = true;
            }
            else if(letterTwelve.matches(targlet1) || letterTwelve.matches(targlet3) || letterTwelve.matches(targlet4)|| letterTwelve.matches(targlet5)){
                editText12.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText12.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 13
            if(letterThirteen.matches(targlet3)){
                editText13.setBackgroundColor(getResources().getColor(R.color.green));
                r3l3 = true;
            }
            else if(letterThirteen.matches(targlet1) || letterThirteen.matches(targlet2) || letterThirteen.matches(targlet4)|| letterFourteen.matches(targlet5)){
                editText13.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText13.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 14
            if(letterFourteen.matches(targlet4)){
                editText14.setBackgroundColor(getResources().getColor(R.color.green));
                r3l4 = true;
            }
            else if(letterFourteen.matches(targlet1) || letterFourteen.matches(targlet2) || letterFourteen.matches(targlet3)|| letterFourteen.matches(targlet5)){
                editText14.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText14.setBackgroundColor(getResources().getColor(R.color.gray));}

            //check 15
            if(letterFifteen.matches(targlet5)){
                editText15.setBackgroundColor(getResources().getColor(R.color.green));
                r3l5 = true;
            }
            else if(letterFifteen.matches(targlet1) || letterFifteen.matches(targlet2) || letterFifteen.matches(targlet3)|| letterFifteen.matches(targlet4)){
                editText15.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText15.setBackgroundColor(getResources().getColor(R.color.gray));}}

            //check outcome
            if(r3l1 && r3l2 && r3l3 && r3l4 &&r3l5){
                outcome.setText("You Win!!");
            }

            //Round 4
            boolean r4l1 = false;
            boolean r4l2 = false;
            boolean r4l3 = false;
            boolean r4l4 = false;
            boolean r4l5 = false;
            if(clickCount == 4){


            //check 16
            if(letterSixteen.matches(targlet1)){
                editText16.setBackgroundColor(getResources().getColor(R.color.green));
                r4l1 = true;
            }
            else if(letterSixteen.matches(targlet2) || letterSixteen.matches(targlet3) || letterSixteen.matches(targlet4) || letterSixteen.matches(targlet5)){
                editText16.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText16.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 17
            if(letterSeventeen.matches(targlet2)){
                editText17.setBackgroundColor(getResources().getColor(R.color.green));
                r4l2 = true;
            }
            else if(letterSeventeen.matches(targlet1) || letterSeventeen.matches(targlet3) || letterSeventeen.matches(targlet4)|| letterSeventeen.matches(targlet5)){
                editText17.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText17.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 18
            if(letterEighteen.matches(targlet3)){
                editText18.setBackgroundColor(getResources().getColor(R.color.green));
                r4l3 = true;
            }
            else if(letterEighteen.matches(targlet1) || letterEighteen.matches(targlet2) || letterEighteen.matches(targlet4)|| letterEighteen.matches(targlet5)){
                editText18.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText18.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 19
            if(letterNineteen.matches(targlet4)){
                editText19.setBackgroundColor(getResources().getColor(R.color.green));
                r4l4 = true;
            }
            else if(letterNineteen.matches(targlet1) || letterNineteen.matches(targlet2) || letterNineteen.matches(targlet3)|| letterNineteen.matches(targlet5)){
                editText19.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText19.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 20
            if(letterTwenty.matches(targlet5)){
                editText20.setBackgroundColor(getResources().getColor(R.color.green));
                r4l5 = true;
            }
            else if(letterTwenty.matches(targlet1) || letterTwentyEight.matches(targlet2) || letterTwenty.matches(targlet3)|| letterTwenty.matches(targlet4)){
                editText20.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText20.setBackgroundColor(getResources().getColor(R.color.gray));}}

            //check outcome
            if(r4l1 && r4l2 && r4l3 && r4l4 && r4l5){
                outcome.setText("You Win");
            }

            //Round 5
            boolean r5l1 = false;
            boolean r5l2 = false;
            boolean r5l3 = false;
            boolean r5l4 = false;
            boolean r5l5 = false;
            if(clickCount == 5){


            //check 21
            if(letterTwentyOne.matches(targlet1)){
                editText21.setBackgroundColor(getResources().getColor(R.color.green));
                r5l1 = true;
            }
            else if(letterTwentyOne.matches(targlet2) || letterTwentyOne.matches(targlet3) || letterTwentyOne.matches(targlet4) || letterTwentyOne.matches(targlet5)){
                editText21.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText21.setBackgroundColor(getResources().getColor(R.color.gray));}

            //check 22
            if(letterTwentyTwo.matches(targlet2)){
                editText22.setBackgroundColor(getResources().getColor(R.color.green));
                r5l2 = true;
            }
            else if(letterTwentyTwo.matches(targlet1) || letterTwentyTwo.matches(targlet3) || letterTwentyTwo.matches(targlet4)|| letterTwentyTwo.matches(targlet5)){
                editText22.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText22.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 23
            if(letterTwentyThree.matches(targlet3)){
                editText23.setBackgroundColor(getResources().getColor(R.color.green));
                r5l3 = true;
            }
            else if(letterTwentyThree.matches(targlet1) || letterTwentyThree.matches(targlet2) || letterTwentyThree.matches(targlet4)|| letterTwentyThree.matches(targlet5)){
                editText23.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText23.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 24
            if(letterTwentyFour.matches(targlet4)){
                editText24.setBackgroundColor(getResources().getColor(R.color.green));
                r5l4 = true;
            }
            else if(letterTwentyFour.matches(targlet1) || letterTwentyFour.matches(targlet2) || letterTwentyFour.matches(targlet3)|| letterTwentyFour.matches(targlet5)){
                editText24.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText24.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 25
            if(letterTwentyFive.matches(targlet5)){
                editText25.setBackgroundColor(getResources().getColor(R.color.green));
                r5l5 = true;
            }
            else if(letterTwentyFive.matches(targlet1) || letterTwentyFive.matches(targlet2) || letterTwentyFive.matches(targlet3)|| letterTwentyFive.matches(targlet4)){
                editText25.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText25.setBackgroundColor(getResources().getColor(R.color.gray));}}


            //check outcome
            if(r5l1 && r5l2 && r5l3 && r5l4 &&r5l5){
                outcome.setText("You Win!!");
            }

            //Round 6
            boolean r6l1 = false;
            boolean r6l2 = false;
            boolean r6l3 = false;
            boolean r6l4 = false;
            boolean r6l5 = false;

            if(clickCount == 6){



            //check 26
            if(letterTwentySix.matches(targlet1)){
                editText26.setBackgroundColor(getResources().getColor(R.color.green));
                r6l1 = true;
            }
            else if(letterTwentySix.matches(targlet2) || letterTwentySix.matches(targlet3) || letterTwentySix.matches(targlet4) || letterTwentySix.matches(targlet5)){
                editText26.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText26.setBackgroundColor(getResources().getColor(R.color.gray));}

            //check 27
            if(letterTwentySeven.matches(targlet2)){
                editText27.setBackgroundColor(getResources().getColor(R.color.green));
                r6l2 = true;
            }
            else if(letterTwentySeven.matches(targlet1) || letterTwentySeven.matches(targlet3) || letterTwentySeven.matches(targlet4)|| letterTwentySeven.matches(targlet5)){
                editText27.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText27.setBackgroundColor(getResources().getColor(R.color.gray));}


            //check 28
            if(letterTwentyEight.matches(targlet3)){
                editText28.setBackgroundColor(getResources().getColor(R.color.green));
                r6l3 = true;
            }
            else if(letterTwentyEight.matches(targlet1) || letterTwentyEight.matches(targlet2) || letterTwentyEight.matches(targlet4)|| letterTwentyEight.matches(targlet5)){
                editText28.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText28.setBackgroundColor(getResources().getColor(R.color.gray));}



            //check 29
            if(letterTwentyNine.matches(targlet4)){
                editText29.setBackgroundColor(getResources().getColor(R.color.green));
                r6l4 = true;
            }
            else if(letterTwentyNine.matches(targlet1) || letterTwentyNine.matches(targlet2) || letterTwentyNine.matches(targlet3)|| letterTwentyNine.matches(targlet5)){
                editText29.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText29.setBackgroundColor(getResources().getColor(R.color.gray));}



            //check 30
            if(letterThirty.matches(targlet5)){
                editText30.setBackgroundColor(getResources().getColor(R.color.green));
                r6l5 = true;
            }
            else if(letterThirty.matches(targlet1) || letterThirty.matches(targlet2) || letterThirty.matches(targlet3)|| letterThirty.matches(targlet4)){
                editText30.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else{  editText30.setBackgroundColor(getResources().getColor(R.color.gray));}}

            //check outcome
            if( r6l1 && r6l2 && r6l3 && r6l4 && r6l5){
                outcome.setText("You Win!!");
            }
            if(clickCount == 6){
            if(!r6l1 || !r6l2 || !r6l3 || !r6l4 || !r6l5){
                outcome.setText("You Lose!!");
            }}








        }
    };

    View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clear();
        }
    };

    View.OnClickListener restartListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clear();
            setWord();
        }
    };

    public void setWord(){

        reference.addListenerForSingleValueEvent(
        new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int count = 0;
                Random random = new Random();
                int randomIndex = random.nextInt((int) dataSnapshot.getChildrenCount());
                Iterator<DataSnapshot> options = dataSnapshot.getChildren().iterator();
                while(count < randomIndex){
                    Word word = options.next().getValue(Word.class);
                    if(count == randomIndex - 1){
                        target = word.getWord();
                    }
                    count++;
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

    }

    public void clear(){
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        editText6.setText("");
        editText7.setText("");
        editText8.setText("");
        editText9.setText("");
        editText10.setText("");
        editText11.setText("");
        editText12.setText("");
        editText13.setText("");
        editText14.setText("");
        editText15.setText("");
        editText16.setText("");
        editText17.setText("");
        editText18.setText("");
        editText19.setText("");
        editText20.setText("");
        editText21.setText("");
        editText22.setText("");
        editText23.setText("");
        editText24.setText("");
        editText25.setText("");
        editText26.setText("");
        editText27.setText("");
        editText28.setText("");
        editText29.setText("");
        editText30.setText("");


        editText1.setEnabled(true);
        editText2.setEnabled(true);
        editText3.setEnabled(true);
        editText4.setEnabled(true);
        editText5.setEnabled(true);
        editText6.setEnabled(false);
        editText7.setEnabled(false);
        editText8.setEnabled(false);
        editText9.setEnabled(false);
        editText10.setEnabled(false);
        editText11.setEnabled(false);
        editText12.setEnabled(false);
        editText13.setEnabled(false);
        editText14.setEnabled(false);
        editText15.setEnabled(false);
        editText16.setEnabled(false);
        editText17.setEnabled(false);
        editText18.setEnabled(false);
        editText19.setEnabled(false);
        editText20.setEnabled(false);
        editText21.setEnabled(false);
        editText22.setEnabled(false);
        editText23.setEnabled(false);
        editText24.setEnabled(false);
        editText25.setEnabled(false);
        editText26.setEnabled(false);
        editText27.setEnabled(false);
        editText28.setEnabled(false);
        editText29.setEnabled(false);
        editText30.setEnabled(false);

        editText1.setBackgroundColor(Color.TRANSPARENT);
        editText2.setBackgroundColor(Color.TRANSPARENT);
        editText3.setBackgroundColor(Color.TRANSPARENT);
        editText4.setBackgroundColor(Color.TRANSPARENT);
        editText5.setBackgroundColor(Color.TRANSPARENT);
        editText6.setBackgroundColor(Color.TRANSPARENT);
        editText7.setBackgroundColor(Color.TRANSPARENT);
        editText8.setBackgroundColor(Color.TRANSPARENT);
        editText9.setBackgroundColor(Color.TRANSPARENT);
        editText10.setBackgroundColor(Color.TRANSPARENT);
        editText11.setBackgroundColor(Color.TRANSPARENT);
        editText12.setBackgroundColor(Color.TRANSPARENT);
        editText13.setBackgroundColor(Color.TRANSPARENT);
        editText14.setBackgroundColor(Color.TRANSPARENT);
        editText15.setBackgroundColor(Color.TRANSPARENT);
        editText16.setBackgroundColor(Color.TRANSPARENT);
        editText17.setBackgroundColor(Color.TRANSPARENT);
        editText18.setBackgroundColor(Color.TRANSPARENT);
        editText19.setBackgroundColor(Color.TRANSPARENT);
        editText20.setBackgroundColor(Color.TRANSPARENT);
        editText21.setBackgroundColor(Color.TRANSPARENT);
        editText22.setBackgroundColor(Color.TRANSPARENT);
        editText23.setBackgroundColor(Color.TRANSPARENT);
        editText24.setBackgroundColor(Color.TRANSPARENT);
        editText25.setBackgroundColor(Color.TRANSPARENT);
        editText26.setBackgroundColor(Color.TRANSPARENT);
        editText27.setBackgroundColor(Color.TRANSPARENT);
        editText28.setBackgroundColor(Color.TRANSPARENT);
        editText29.setBackgroundColor(Color.TRANSPARENT);
        editText30.setBackgroundColor(Color.TRANSPARENT);

        clickCount = 0;
        outcome.setText("");

    }
}