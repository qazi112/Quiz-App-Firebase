package com.example.quiz_app.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.example.quiz_app.R;
import com.example.quiz_app.models.Question;
import com.example.quiz_app.models.Quiz;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {
    Gson gson;
    Quiz quiz;
    TextView scoreText;
    TextView textAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        scoreText = findViewById(R.id.scoreText);
        textAnswer = findViewById(R.id.textAnswer);

        setUpViews();



    }

    public void setUpViews() {

        gson = new Gson();
        Intent intent = getIntent();
        String json = intent.getStringExtra("QUIZ");
        quiz = (Quiz) gson.fromJson(json, Quiz.class);

        // deserialize data
        calculateScore();
        setAnswerView();
    }
    // Setting HTML String to TextAnswer
    public void setAnswerView() {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String,Question> entry : quiz.questions.entrySet()){
            Question question = entry.getValue();
            builder.append("<font color='#18206F'><b>Question: "+question.description+" </b></font><br><br>");
            builder.append("<font color='#009866'>Answer: "+question.answer+"</font><br><br>");
            builder.append("<font color='#009866'>Your Answer: "+question.userAnswer+"</font><br><br>");
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                textAnswer.setText(Html.fromHtml(builder.toString(),Html.FROM_HTML_MODE_COMPACT));
            }else{
                textAnswer.setText(Html.fromHtml(builder.toString()));
            }
        }
    }

    public void calculateScore() {
        int score = 0;
        Log.d("DATA",""+quiz.questions);
        for(HashMap.Entry<String,Question> entry : quiz.questions.entrySet()){
            Log.d("DATA",""+entry.getValue());
            Question val = entry.getValue();
            if(val.userAnswer.equals(val.answer)){
                score += 10;
            }


        }

        scoreText.setText("Your Score : "+score);

    }
}