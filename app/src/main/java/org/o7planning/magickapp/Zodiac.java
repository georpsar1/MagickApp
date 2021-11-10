package org.o7planning.magickapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Zodiac extends AppCompatActivity {

    Button btn_zodiac_get;
    String sign = "";
    String date = "";
    String url = "https://aztro.sameerkumar.website/?sign=aries&day=today";


    Spinner spinner;

    TextView tv_date_range;
    TextView tv_current_date;
    TextView tv_description;
    TextView tv_compat;
    TextView tv_mood;
    TextView tv_color;
    TextView tv_lucky_num;
    TextView tv_lucky_time;


    RadioGroup radioGroup;
    RadioButton radioButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac);

        spinner = findViewById(R.id.spinner_signs);

        tv_date_range = findViewById(R.id.tv_zodiac_date_range);
        tv_current_date = findViewById(R.id.tv_zodiac_current_date);
        tv_description = findViewById(R.id.tv_zodiac_description);
        tv_compat = findViewById(R.id.tv_zodiac_compat);
        tv_mood = findViewById(R.id.tv_zodiac_mood);
        tv_color = findViewById(R.id.tv_zodiac_color);
        tv_lucky_num = findViewById(R.id.tv_zodiac_lucky_number);
        tv_lucky_time = findViewById(R.id.tv_zodiac_lucky_time);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.signs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sign = parent.getItemAtPosition(position).toString().toLowerCase();
                //Toast.makeText(Zodiac.this, sign, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radioGroup = findViewById(R.id.zodiac_radiogroup);












        btn_zodiac_get = findViewById(R.id.btn_zodiac_get);
        btn_zodiac_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //int radioId = radioGroup.getCheckedRadioButtonId();
                //radioButton.findViewById(radioId);
                //date = radioButton.getText().toString();
                int checkedId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(checkedId);
                date = radioButton.getText().toString().toLowerCase();








                RequestQueue queue = Volley.newRequestQueue(Zodiac.this);
                url = "https://aztro.sameerkumar.website/?sign="+sign+"&day=" + date;
                //Toast.makeText(Zodiac.this, url, Toast.LENGTH_SHORT).show();

                JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url,null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Toast.makeText(Zodiac.this, response, Toast.LENGTH_SHORT).show();
                        //tv_zodiac.setText(response.toString());
                        try {
                            tv_date_range.setText((response.getString("date_range")));
                            tv_current_date.setText((response.getString("current_date")));
                            tv_description.setText((response.getString("description")));
                            tv_compat.setText((response.getString("compatibility")));
                            tv_mood.setText((response.getString("mood")));
                            tv_color.setText((response.getString("color")));
                            tv_lucky_num.setText((response.getString("lucky_number")));
                            tv_lucky_time.setText((response.getString("lucky_time")));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(stringRequest);

            }
        });






    }




}