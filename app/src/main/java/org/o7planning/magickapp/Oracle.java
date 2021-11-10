package org.o7planning.magickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Oracle extends AppCompatActivity {

    Button btn_goto_main, btn_askTheOracle;
    TextView tv_oracle;
    EditText et_oracle;

    String[] answers = {"It is certain", "It is decidedly so", "Without a doubt", "Yes definitely", "You may rely on it", "As I see it, yes",
            "Most likely", "Outlook good", "Yes", "Signs point to yes", "Reply hazy try again", "Ask again later",
            "Better not tell you now", "Cannot predict now", "Concentrate and ask again", "Don't count on it",
            "My reply is no", "My sources say no", "Outlook not so good", "Very doubtful", "Nope", "Go ahead", "Could be both ways", "Is it not obvious?", "Yup"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oracle);

        btn_askTheOracle = findViewById(R.id.btn_asktheoracle);
        tv_oracle = findViewById(R.id.tv_oracle);
        et_oracle = findViewById(R.id.et_oracle);
        Random random = new Random();
        et_oracle.clearFocus();

        btn_askTheOracle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_oracle.setText("");
                tv_oracle.setText(answers[random.nextInt(answers.length)]);
            }
        });



    }
}