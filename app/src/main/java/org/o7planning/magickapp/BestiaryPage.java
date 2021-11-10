package org.o7planning.magickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BestiaryPage extends AppCompatActivity {

    String img_url;
    TextView tv_name;
    TextView tv_desc;
    ImageView iv_bpage_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestiary_page);

        tv_name = findViewById(R.id.tv_bpage_name);
        tv_desc = findViewById(R.id.tv_bpage_desc);
        iv_bpage_img = findViewById(R.id.iv_bpage);

        tv_name.setText(getIntent().getStringExtra("beast_name"));
        tv_desc.setText(getIntent().getStringExtra("beast_description"));
        tv_desc.setMovementMethod(new ScrollingMovementMethod());
        img_url = getIntent().getStringExtra("image_url");
        Glide.with(this).load(img_url).into(iv_bpage_img);

    }


}