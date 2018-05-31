package com.example.android.westwingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String userName;
    int questionNumber = 0;
    int score = 0;
    ImageView main;
    TextView question;
    EditText nameEntry, answer7;
    Button nextButton;
    LinearLayout question2, question4, question7, question8;
    RadioGroup question1, question3, question5, question6;
    CheckBox question2a, question2b, question2c, question2d, question4a, question4b, question4c, question4d, question8a, question8b, question8c, question8d;
    private final String Question_Number = "questionNumber";
    private final String Score = "score";
    private final String User_Name = userName;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(Question_Number, questionNumber);
        savedInstanceState.putInt(Score, score);
        savedInstanceState.putString(User_Name, userName);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            questionNumber = savedInstanceState.getInt("questionNumber");
            score = savedInstanceState.getInt("score");
            userName = savedInstanceState.getString("userName");
        }
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.image);
        nameEntry = findViewById(R.id.name_entry);
        nameEntry.clearFocus();
        answer7 = findViewById(R.id.answer7);
        answer7.clearFocus();
        nextButton = findViewById(R.id.next_button);
        question = findViewById(R.id.question);
        question1 = findViewById(R.id.question1);
        question2 = findViewById(R.id.question2);
        question3 = findViewById(R.id.question3);
        question4 = findViewById(R.id.question4);
        question5 = findViewById(R.id.question5);
        question6 = findViewById(R.id.question6);
        question2a = findViewById(R.id.question2a);
        question2b = findViewById(R.id.question2b);
        question2c = findViewById(R.id.question2c);
        question2d = findViewById(R.id.question2d);
        question4a = findViewById(R.id.question4a);
        question4b = findViewById(R.id.question4b);
        question4c = findViewById(R.id.question4c);
        question4d = findViewById(R.id.question4d);
        question7 = findViewById(R.id.question7);
        question8 = findViewById(R.id.question8);
        question8a = findViewById(R.id.question8a);
        question8b = findViewById(R.id.question8b);
        question8c = findViewById(R.id.question8c);
        question8d = findViewById(R.id.question8d);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screenInit();
            }


        });
    }

    /*
       method for initializing the screen
    */
    private void screenInit() {
        if (questionNumber == 0) {
            setView(nameEntry, question1);
            question.setText(setGreeting());
            changeDisplayPic();
        } else if (questionNumber == 1) {
            setView(question1, question2);
            question.setText(R.string.question2);
            checkAnswer();
            changeDisplayPic();
            nameEntry.setVisibility(View.GONE);
        } else if (questionNumber == 2) {
            setView(question2, question3);
            question.setText(R.string.question3);
            checkAnswer();
            nameEntry.setVisibility(View.GONE);

        } else if (questionNumber == 3) {
            setView(question3, question4);
            question.setText(R.string.question4);
            checkAnswer();
            nameEntry.setVisibility(View.GONE);
        } else if (questionNumber == 4) {
            setView(question4, question5);
            question.setText(R.string.question5);
            checkAnswer();
            nameEntry.setVisibility(View.GONE);
        } else if (questionNumber == 5) {
            setView(question5, question6);
            question.setText(R.string.question6);
            checkAnswer();
            nameEntry.setVisibility(View.GONE);
        } else if (questionNumber == 6) {
            setView(question6, question7);
            question.setText(R.string.question7);
            checkAnswer();
            changeDisplayPic();
            nameEntry.setVisibility(View.GONE);
        } else if (questionNumber == 7) {
            setView(question7, question8);
            question.setText(R.string.question8);
            checkAnswer();
            changeDisplayPic();
            nameEntry.setVisibility(View.GONE);

        } else if (questionNumber == 8) {
            checkAnswer();
            displayScore(score);
            reset();
        }
    }

    /*
    method to set greeting after name entry
 */
    private String setGreeting() {
        userName = nameEntry.getText().toString().trim();
        nameEntry.clearFocus();
        nameEntry.setText("");
        return getResources().getString(R.string.greeting, userName);
    }


    /*
      method to get to set the view
   */
    private void setView(View v, View w) {
        v.setVisibility(View.GONE);
        w.setVisibility(View.VISIBLE);
        questionNumber++;
    }

    /*
    Method to check each answer
     */
    private void checkAnswer() {
        if (question1.getCheckedRadioButtonId() == R.id.question1b) {
            score++;
            question1.clearCheck();
        }
        if (question2b.isChecked() && question2d.isChecked()) {
            score++;
            question2b.toggle();
            question2d.toggle();
        }
        if (question3.getCheckedRadioButtonId() == R.id.question3c) {
            score++;
            question3.clearCheck();
        }
        if (question4a.isChecked() && question4b.isChecked() && question4c.isChecked()) {
            score++;
            question4a.toggle();
            question4b.toggle();
            question4c.toggle();
        }
        if (question5.getCheckedRadioButtonId() == R.id.question5d) {
            score++;
            question5.clearCheck();
        }
        if (question6.getCheckedRadioButtonId() == R.id.question6a) {
            score++;
            question6.clearCheck();
        }
        if (answer7.getText() != null) {
            String answer = (answer7.getText().toString().toLowerCase().trim());
            if (answer.equals(getString(R.string.answer7))) {
                score++;
            }
            answer7.setText("");
        }
        if (question8a.isChecked() && question8b.isChecked() && question8d.isChecked()) {
            score++;
            question8a.toggle();
            question8b.toggle();
            question8d.toggle();
        }
    }

    /*
    Method to displayScore
     */
    private void displayScore(int i) {

        String text = getString(R.string.score, userName, i);

        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    /*
    Method to change the drawable image for questions
     */
    private void changeDisplayPic() {
        if (questionNumber == 1) {
            main.setImageResource(R.drawable.gerald_ford);
        }
        if (questionNumber == 2) {
            main.setImageResource(R.drawable.presidential_seal);
        }
        if (questionNumber == 7) {
            main.setImageResource(R.drawable.calvin_coolidge);
        }
        if (questionNumber == 8) {
            main.setImageResource(R.drawable.presidential_seal);
        }
    }

    /*
    method to reset the quiz
     */
    private void reset() {
        setView(question8, nameEntry);
        nameEntry.setText("");
        questionNumber = 0;
        score = 0;
        question.setText(R.string.intro);
    }
}