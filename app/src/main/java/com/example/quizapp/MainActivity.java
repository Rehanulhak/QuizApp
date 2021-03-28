package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int answerQ1 = 4;
    String answerQ2 = "RADIUS";
    Boolean answerQ3 = null;
    Boolean answerQ4 = null;
    String answerQ5 = "FORREST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void RadioQuestion3Clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.choice1Q3:
                if(checked){
                    answerQ3 = false;
                    break;
                }
            case R.id.choice2Q3:
                if(checked){
                    answerQ3 = false;
                    break;
                }
            case R.id.choice3Q3:
                if(checked){
                    answerQ3 = true;
                    break;
                }
            case R.id.choice4Q3:
                if(checked){
                    answerQ3 = false;
                    break;
                }
        }

    }
    public void RadioQuestion4Clicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.choice1Q4:
                if(checked){
                    answerQ4 = false;
                    break;
                }
            case R.id.choice2Q4:
                if(checked){
                    answerQ4 = true;
                    break;
                }
            case R.id.choice3Q4:
                if(checked){
                    answerQ4 = false;
                    break;
                }
            case R.id.choice4Q4:
                if(checked){
                    answerQ4 = false;
                    break;
                }
        }
    }
    public boolean checkboxQuestion6Check() {
        CheckBox checkbox = findViewById(R.id.choice2Q6);

        if (checkbox.isChecked()){
            return false;
        }
        else {
            checkbox = findViewById(R.id.choice1Q6);
            if (checkbox.isChecked()) {
                checkbox = findViewById(R.id.choice3Q6);
                if (checkbox.isChecked()) {
                    checkbox = findViewById(R.id.choice4Q6);
                    if (checkbox.isChecked()) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    public boolean checkInput(){
        EditText editText = findViewById(R.id.nameField);
        String string = editText.getText().toString();
        if (string.isEmpty()){
            return false;
        }
        editText = findViewById(R.id.answer1);
        string = editText.getText().toString();
        if (string.isEmpty()){
            return false;
        }
        editText = findViewById(R.id.answer2);
        string = editText.getText().toString();
        if (string.isEmpty()){
            return false;
        }
        RadioGroup radioGroup = findViewById(R.id.question3Choices);
        int selected = radioGroup.getCheckedRadioButtonId();
        if (selected == -1){
            return false;
        }
        radioGroup = findViewById(R.id.question4Choices);
        selected = radioGroup.getCheckedRadioButtonId();
        if (selected == -1){
            return false;
        }
        editText = findViewById(R.id.answer5);
        string = editText.getText().toString();
        if (string.isEmpty()){
            return false;
        }
        return true;
    }
    public void endQuiz(View view){
        if (checkInput()) {
            int score = 0;

            EditText text = findViewById(R.id.answer1);
            String checkAnswer = text.getText().toString();

            if (Integer.parseInt(checkAnswer) == answerQ1) {
                score++;
            }

            text = findViewById(R.id.answer2);
            checkAnswer = text.getText().toString();


            if (checkAnswer.equals(answerQ2)) {
                score++;
            }
            if (answerQ3) {
                score++;
            }
            if (answerQ4) {
                score++;
            }

            text = findViewById(R.id.answer5);
            checkAnswer = text.getText().toString();

            if (checkAnswer.equals(answerQ5)) {
                score++;
            }
            if (checkboxQuestion6Check()){
                score++;
            }

            EditText nameField = findViewById(R.id.nameField);
            String name = nameField.getText().toString();
            Toast.makeText(this, name + ", Your Quiz score is: " + score, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "You need to answer all input fields including name", Toast.LENGTH_LONG).show();
        }
    }
}