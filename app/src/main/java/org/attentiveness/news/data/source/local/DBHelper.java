package org.attentiveness.news.data.source.local;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "News.db";

    static final String TABLE_NEWS_NAME = "News";
    private static final String TABLE_NEWS_CREATE = "CREATE TABLE " + TABLE_NEWS_NAME + "("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nid TEXT,"
            + "channel_id TEXT,"
            + "channel_name TEXT,"
            + "title TEXT,"
            + "description TEXT,"
            + "image_url TEXT,"
            + "source TEXT,"
            + "pub_date TEXT,"
            + "link TEXT"
            + ");";
    private static final String TABLE_NEWS_DROP = "DROP TABLE IF EXISTS " + TABLE_NEWS_NAME;

    static final String TABLE_CHANNEL_NAME = "Channel";
    private static final String TABLE_CHANNEL_CREATE = "CREATE TABLE " + TABLE_CHANNEL_NAME + "("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nid TEXT,"
            + "channel_id TEXT,"
            + "channel_name TEXT,"
            + "title TEXT,"
            + "description TEXT,"
            + "image_url TEXT,"
            + "source TEXT,"
            + "pub_date TEXT,"
            + "link TEXT"
            + ");";
    private static final String TABLE_CHANNEL_DROP = "DROP TABLE IF EXISTS " + TABLE_NEWS_NAME;

    static final String TABLE_MY_CHANNEL_NAME = "MyChannel";
    private static final String TABLE_MY_CHANNEL_CREATE = "CREATE TABLE " + TABLE_NEWS_NAME + "("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nid TEXT,"
            + "channel_id TEXT,"
            + "channel_name TEXT,"
            + "title TEXT,"
            + "description TEXT,"
            + "image_url TEXT,"
            + "source TEXT,"
            + "pub_date TEXT,"
            + "link TEXT"
            + ");";
    private static final String TABLE_MY_CHANNEL_DROP = "DROP TABLE IF EXISTS " + TABLE_NEWS_NAME;

    DBHelper(Context context) {
        this(context, DATABASE_NAME, null, 1);
    }

    private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_NEWS_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TABLE_NEWS_DROP);
        onCreate(db);
    }
}
