package org.attentiveness.news.data.source.local;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    final static String DATABASE_NAME = "News.db";
    final static String TABLE_NAME = "News";
    final static String TABLE_CREATE = "create table " + TABLE_NAME + "("
            + "_id integer primary key autoincrement,"
            + "nid text,"
            + "channel_id text,"
            + "channel_name text,"
            + "title text,"
            + "description text,"
            + "image_url text,"
            + "source text,"
            + "pub_date text,"
            + "link text"
            + ");";
    final static String TABLE_DROP = "drop table if exists " + TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TABLE_DROP);
        onCreate(db);
    }
}
