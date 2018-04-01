package com.example.koloh.simpleandroidquiz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


public class MainActivity extends AppCompatActivity {

    int score;  // score variable declared as global variable
    String totalMessage;  // totalMessage variable declared as global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        Button submit_answers_button = (Button) findViewById ( R.id.submit_answers_button );
        submit_answers_button.setOnClickListener ( new View.OnClickListener () {

            @Override
            public void onClick(View view) {
                String question1_answer = "2008";
                EditText question1 = (EditText) findViewById ( R.id.edit_question1 );
                String questionOne = question1.getText ().toString ().trim ();
                if (questionOne.equals ( question1_answer )) {
                    score = 1;
                } else {
                    score = 0;
                    Toast.makeText ( MainActivity.this, "Your answer is in correct in question 1", Toast.LENGTH_SHORT ).show ();
                }

                // This shows which RadioButton in question 2 is clicked and scores are assigned to them
                if (((RadioButton) findViewById ( R.id.question2_button1 )).isChecked ()) {
                    score = score + 1;
                }
                if (((RadioButton) findViewById ( R.id.question2_button2 )).isChecked () || (((RadioButton) findViewById ( R.id.question2_button3 )).isChecked ())) {
                    score = score + 0;
                }

                // This shows which CheckBox is clicked and scores are assigned to them
                if (((CheckBox) findViewById ( R.id.checkbox_lollipop )).isChecked () && (((CheckBox) findViewById ( R.id.checkbox_oreo )).isChecked ()) && !(((CheckBox) findViewById ( R.id.checkbox_chocolate )).isChecked ())) {
                    score = score + 1;
                }

                // This shows which RadioButton in question 4 is clicked and scores are assigned to them
                if (((RadioButton) findViewById ( R.id.question4_button2 )).isChecked ()) {
                    score = score + 1;
                }
                if (((RadioButton) findViewById ( R.id.question4_button1 )).isChecked () || (((RadioButton) findViewById ( R.id.question4_button3 )).isChecked ())) {
                    score = score + 0;
                }

                // The totalMessage method is called and display the total score to the screen and as a Toast.
                String totalMessage = createTotalSummary ( score );
                displayScore ( totalMessage );
            }

        } );
    }

    /**
     * Helpful for screen rotation, ensures that data is saved when screen rotates horizontally and vertically
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState ( savedInstanceState );

        savedInstanceState.putInt ( " quiz score", score );
        savedInstanceState.putString ( "message", totalMessage );

    }

    /**
     * Helpful for screen rotation, ensures that data is saved when screen rotates horizontally and vertically
     */
    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState ( saveInstanceState );

        if (saveInstanceState != null) {
            score = saveInstanceState.getInt ( " quiz score" );
        }
        String question1_answer = "2008";
        EditText question1 = (EditText) findViewById ( R.id.edit_question1 );
        String questionOne = question1.getText ().toString ().trim ();
        if (questionOne.equals ( question1_answer )) {
            score = 1;
        } else {
            score = 0;
            Toast.makeText ( MainActivity.this, "Your answer is in correct in question 1", Toast.LENGTH_SHORT ).show ();
        }

        // This shows which RadioButton in question 2 is clicked and scores are assigned to them
        if (((RadioButton) findViewById ( R.id.question2_button1 )).isChecked ()) {
            score = score + 1;
        }
        if (((RadioButton) findViewById ( R.id.question2_button2 )).isChecked () || (((RadioButton) findViewById ( R.id.question2_button3 )).isChecked ())) {
            score = score + 0;
        }

        // This shows which CheckBox is clicked and scores are assigned to them
        if (((CheckBox) findViewById ( R.id.checkbox_lollipop )).isChecked () && (((CheckBox) findViewById ( R.id.checkbox_oreo )).isChecked ()) && !(((CheckBox) findViewById ( R.id.checkbox_chocolate )).isChecked ())) {
            score = score + 1;
        }

        // This shows which RadioButton in question 4 is clicked and scores are assigned to them
        if (((RadioButton) findViewById ( R.id.question4_button2 )).isChecked ()) {
            score = score + 1;
        }
        if (((RadioButton) findViewById ( R.id.question4_button1 )).isChecked () || (((RadioButton) findViewById ( R.id.question4_button3 )).isChecked ())) {
            score = score + 0;
        }

        // The totalMessage method is called and display the total score to the screen and as a Toast.
        String totalMessage = createTotalSummary ( score );
        displayScore ( totalMessage );

    }

    // This method activates the RadioButton for question 2 and 4 when clicked.
    public void onRadioButtonClicked(View v) {
        RadioButton button = (RadioButton) findViewById ( R.id.question2_button1 );
        RadioButton button2 = (RadioButton) findViewById ( R.id.question4_button1 );

    }

    // This method activates the CheckBoxes when checked.
    public void onCheckboxClicked(View v) {
    }

    // This Method shows the total Score
    private String createTotalSummary(int score) {
        String totalMessage = "Your total Score is: " + score;
        String message = "You scored " + score + " out of 4";
        Toast toast = Toast.makeText ( this, message, LENGTH_SHORT );
        toast.setGravity ( Gravity.CENTER, 0, 0 );
        toast.show ();
        return totalMessage;
    }

    /**
     * This method displays the given total Score on the screen.
     */
    private void displayScore(String message) {
        TextView orderSummaryTextView = (TextView) findViewById ( R.id.total_score_text_view );
        orderSummaryTextView.setText ( message );
    }

}


/**
 * HELPFUL RESOURCES:
 * 1. Android Logo from http://pngimg.com/imgs/logos/android_logo/
 * 2. Answer help from https://stackoverflow.com/questions/44142020/android-checkbox-radio-button-score-quiz-app
 */