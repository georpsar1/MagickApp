package org.o7planning.magickapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class CurseDialog {

    private Activity activity;
    private AlertDialog dialog;

    CurseDialog(Activity myActivity){
        activity = myActivity;

    }

    void startCursingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();

    }

    void dismissDialog(){
        dialog.dismiss();
    }

}
