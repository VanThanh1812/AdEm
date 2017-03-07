package com.example.dell.adem.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 2/26/2017.
 */

public class UserPostModify {
    DBHelper dbHelper;

    public UserPostModify(Context context)
    {
        dbHelper = new DBHelper(context);
    }

    public  void insertUserPost (UserPost userPost)
    {
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COL_CAPTION, userPost.getCaption());
        contentValues.put(DBHelper.COL_EMOTION, userPost.getEmotion());
        contentValues.put(DBHelper.COL_LOCATION, userPost.getLocation());
        contentValues.put(DBHelper.COL_FRIEND_TAG, userPost.getFriendtag());
        contentValues.put(DBHelper.COL_HASHTAG, userPost.getHashtag());
        contentValues.put(DBHelper.COL_LIST_IMAGES, userPost.getListimange());
        contentValues.put(DBHelper.COL_LIST_VIDEOS, userPost.getListvideo());
        db.close();
    }
    public  void deleteall(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DBHelper.TABLE_NAME, null, null);
        db.close();
    }

    public Cursor getAll(){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+DBHelper.TABLE_NAME, null);
        if (cursor==null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public void deleteById(int id){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.delete(DBHelper.TABLE_NAME,DBHelper.COL_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public  UserPost findByID(int ID){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+DBHelper.TABLE_NAME+ " WHERE "+DBHelper.COL_ID + "=?", new String[]{String.valueOf(ID)});
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new UserPost(cursor.getString(DBHelper.INDEX_CAPTION),
                cursor.getString(DBHelper.INDEX_EMOTION),
                cursor.getString(DBHelper.INDEX_LOCATION),
                cursor.getString(DBHelper.INDEX_HASHTAG),
                cursor.getString(DBHelper.INDEX_FRIENG_TAG),
                cursor.getString(DBHelper.INDEX_LIST_VIDEOS),
                cursor.getString(DBHelper.INDEX_LIST_VIDEOS));
    }

    public  void update (UserPost userPost, int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COL_CAPTION, userPost.getCaption());
        contentValues.put(DBHelper.COL_EMOTION, userPost.getEmotion());
        contentValues.put(DBHelper.COL_LOCATION, userPost.getLocation());
        contentValues.put(DBHelper.COL_FRIEND_TAG, userPost.getFriendtag());
        contentValues.put(DBHelper.COL_HASHTAG, userPost.getHashtag());
        contentValues.put(DBHelper.COL_LIST_IMAGES, userPost.getListimange());
        contentValues.put(DBHelper.COL_LIST_VIDEOS, userPost.getListvideo());
        db.update(DBHelper.TABLE_NAME, contentValues, DBHelper.COL_ID + "=?", new String[]{String.valueOf(id)});
        db.close();

    }

}
