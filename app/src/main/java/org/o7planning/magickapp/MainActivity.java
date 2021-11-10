package org.o7planning.magickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_goto_oracle;
    ImageButton btn_goto_curse;
    ImageButton btn_goto_zodiac;
    ImageButton btn_goto_bestiary;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_goto_oracle = findViewById(R.id.ib_oracle);


        btn_goto_oracle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_oracle = new Intent(MainActivity.this,Oracle.class);
                startActivity(goto_oracle);
            }
        });

        btn_goto_curse = findViewById(R.id.ib_curse);


        btn_goto_curse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_curse = new Intent(MainActivity.this,Curse.class);
                startActivity(goto_curse);
            }
        });

        btn_goto_zodiac = findViewById(R.id.ib_zodiac);


        btn_goto_zodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_zodiac = new Intent(MainActivity.this,Zodiac.class);
                startActivity(goto_zodiac);
            }
        });

        btn_goto_bestiary = findViewById(R.id.ib_bestiary);

        btn_goto_bestiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_bestiary = new Intent(MainActivity.this,Bestiary.class);
                startActivity(goto_bestiary);
            }
        });



    }
}