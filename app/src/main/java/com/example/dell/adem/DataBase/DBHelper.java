package com.example.dell.adem.DataBase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 2/26/2017.
 */

public class DBHelper extends SQLiteOpenHelper {



    public static final String DATABASE_NAME= "UserPostDataBase";

    public static final String TABLE_NAME = "UserPost";
    public static final String COL_ID = "_ID";
    public static final String COL_CAPTION = "Caption";
    public static final String COL_LIST_IMAGES = "List_Imnages";
    public static final String COL_LIST_VIDEOS = "List_Videos";
    public static final String COL_LOCATION = "Location";
    public static final String COL_EMOTION = "Emotion";
    public static final String COL_FRIEND_TAG = "FriendTag";
    public static final String COL_HASHTAG = "HashTag";

    public static final int INDEX_ID = 0;
    public static final int INDEX_CAPTION = 1;
    public static final int INDEX_LIST_IMAGES = 2;
    public static final int INDEX_LIST_VIDEOS = 3;
    public static final int INDEX_LOCATION = 4;
    public static final int INDEX_EMOTION = 5;
    public static final int INDEX_FRIENG_TAG = 6;
    public static final int INDEX_HASHTAG = 7;



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("CREATE TABLE if not exists "+TABLE_NAME+"("+
            COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_CAPTION + " TEXT, "+
            COL_LIST_IMAGES + " TEXT, "+
            COL_LIST_VIDEOS + " TEXT, "+
            COL_LOCATION + " TEXT, "+
            COL_EMOTION + " TEXT, "+
            COL_FRIEND_TAG + " TEXT, "+
            COL_HASHTAG + " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME );
        onCreate(sqLiteDatabase);
    }
}
