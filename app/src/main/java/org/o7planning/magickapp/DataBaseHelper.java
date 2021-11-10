package org.o7planning.magickapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "BESTIARY";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_BEAST_NAME = "BEAST_NAME";
    public static final String COLUMN_BEAST_DESCRIPTION = "BEAST_DESCRIPTION";
    public static final String COLUMN_BEAST_PHOTOURL = "BEAST_PHOTOURL";





    public DataBaseHelper(@Nullable Context context) {

        super(context, "bestiary.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_BEAST_NAME + " TEXT, " + COLUMN_BEAST_DESCRIPTION + " TEXT, " + COLUMN_BEAST_PHOTOURL + " TEXT)";
        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Beast b) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_BEAST_NAME,b.getName());
        cv.put(COLUMN_BEAST_DESCRIPTION,b.getDescription());
        cv.put(COLUMN_BEAST_PHOTOURL,b.getImageURL());

        long insert = db.insert(TABLE_NAME,null,cv);
        if (insert == -1) {
            return false;
        }else {
            return true;
        }


    }

    List<Beast> getAll(){

        List<Beast> beastList = new ArrayList<>();

        String queryString = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString,null);

        if(cursor.moveToFirst()){

            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String desc = cursor.getString(2);
                String photourl = cursor.getString(3);

                Beast beast = new Beast(id,name,desc,photourl);
                beastList.add(beast);

            }while (cursor.moveToNext());
        }else {


        }

        cursor.close();
        db.close();

        return beastList;


    }

    public void deleteOne(Beast beast) {
        SQLiteDatabase db = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + beast.getId();
        Cursor cursor = db.rawQuery(deleteQuery, null);

    }

    public boolean deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        String nukeQuery = "DELETE FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(nukeQuery, null);
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }
}
