/*
 * Going to attempt to keep this simple for now, and, if desired, abstract the questions and answers later
 */

package com.example.android.quizzy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static int MAX_SCORE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * Function called when Submit Answers button is pressed
     * Uses the five different methods to check correct answers
     * and increment the score
     */
    public void submitAnswers(View v) {
        int score = 0;

        if(checkQuestion1())
            score += 1;
        if(checkQuestion2())
            score += 1;
        if(checkQuestion3("Balls"))
            score += 1;
        if(checkQuestion4())
            score += 1;
        if(checkQuestion5())
            score += 1;

        displayScores(3);
    }

    /*
     * Function for formatting the scores and displaying a message as a Toast
     */
    private void displayScores(int score) {
        float percent = (float) score / (float) MAX_SCORE;
        if(percent == 1)
            Toast.makeText(this, (percent * 100) +"%! " + getString(R.string.submitted_max), Toast.LENGTH_SHORT).show();
        else if(percent < 1 && percent >= 0.8)
            Toast.makeText(this, (percent * 100) +"%! " + getString(R.string.submitted_great), Toast.LENGTH_SHORT).show();
        else if(percent < 0.8 && percent >= 0.6)
            Toast.makeText(this, (percent * 100) +"%! " + getString(R.string.submitted_good), Toast.LENGTH_SHORT).show();
        else if(percent < 0.6 && percent >= 0.4)
            Toast.makeText(this, (percent * 100) +"%! " + getString(R.string.submitted_meh), Toast.LENGTH_SHORT).show();
        else if(percent < 0.4 && percent >= 0.2)
            Toast.makeText(this, (percent * 100) +"%! " + getString(R.string.submitted_poor), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, getString(R.string.submitted_zero) + " " + percent, Toast.LENGTH_SHORT).show();

    }

    /**
     * Method to check if question 1 is correct
     * @return true if correct answer
     */
    private boolean checkQuestion1() {
        boolean isCorrect = false;
        CheckBox checkboxA = (CheckBox) findViewById(R.id.check_button_1_a);
        CheckBox checkboxB = (CheckBox) findViewById(R.id.check_button_1_b);
        CheckBox checkboxC = (CheckBox) findViewById(R.id.check_button_1_c);
        CheckBox checkboxD = (CheckBox) findViewById(R.id.check_button_1_d);

        if(checkboxA.isChecked() && checkboxC.isChecked() && !checkboxB.isChecked() && !checkboxD.isChecked())
            isCorrect = true;

        return isCorrect;
    }

    /**
     * Method to check if question 2 is correct
     * @return true if correct answer
     */
    private boolean checkQuestion2() {
        boolean isCorrect = false;
        RadioButton buttonA = (RadioButton) findViewById(R.id.radio_button_1_a);
        //RadioButton buttonB = (RadioButton) findViewById(R.id.radio_button_1_b);

        if(buttonA.isChecked())
            isCorrect = true;

        return isCorrect;
    }

    /**
     * Method to check if question 3 is correct
     * @return true if correct answer
     */
    private boolean checkQuestion3(String correctAnswer) {
        String result;
        boolean isCorrect = false;
        EditText answer = (EditText) findViewById(R.id.text_3);
        result = answer.getText().toString();

        if(result.equalsIgnoreCase(correctAnswer))
            isCorrect = true;

        return isCorrect;
    }

    /**
     * Method to check if question 4 is correct
     * @return true if correct answer
     */
    private boolean checkQuestion4() {
        boolean isCorrect = false;
        RadioButton buttonC = (RadioButton) findViewById(R.id.radio_button_4_c);

        if(buttonC.isChecked())
            isCorrect = true;

        return isCorrect;
    }

    /**
     * Method to check if question 5 is correct
     * @return true if correct answer
     */
    private boolean checkQuestion5() {
        return true;
    }

}
