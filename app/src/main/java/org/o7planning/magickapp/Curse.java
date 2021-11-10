package org.o7planning.magickapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.Random;

public class Curse extends AppCompatActivity {

    Button btn_curse;
    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curse);
        CurseDialog curseDialog = new CurseDialog(Curse.this);
        //curse text possibly based on entered stuff
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        btn_curse = findViewById(R.id.btn_curse);

        String failureMessages[] = {"Curse intercepted by Turkish drone.","Curse missed; hit a passerby.","Curse accidentally hit a bird..."};
        String successMessages[] = {"They won't know what hit them!","That'll teach them!","They'll think twice about messing with you!"};


        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, Curse.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.curse_icon)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setPriority(Notification.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        btn_curse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curseDialog.startCursingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        curseDialog.dismissDialog();
                        //Toast.makeText(Curse.this, "Cursing successful! That'll teach them!", Toast.LENGTH_SHORT).show();
                        Random random = new Random();
                        String success = "";
                        String success_message;

                        if (random.nextInt(2)==0) {
                            success = "Curse Successful";
                            success_message = successMessages[random.nextInt(successMessages.length)];
                        }else {
                            success = "Curse Failure";
                            success_message = failureMessages[random.nextInt(failureMessages.length)];
                        }




                        builder.setContentTitle(success);
                        builder.setContentText(success_message);
                        notificationManager.notify(3, builder.build());

                    }

                },4000);


            }
        });





    }
}