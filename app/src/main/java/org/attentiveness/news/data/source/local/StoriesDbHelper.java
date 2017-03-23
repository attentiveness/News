package org.attentiveness.news.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StoriesDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Stories.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String BOOLEAN_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + StoriesPersistenceContract.StoryEntry.TABLE_NAME + " (" +
                    StoriesPersistenceContract.StoryEntry._ID + TEXT_TYPE + " PRIMARY KEY," +
                    StoriesPersistenceContract.StoryEntry.COLUMN_NAME_STORY_ID + BOOLEAN_TYPE + COMMA_SEP +
                    StoriesPersistenceContract.StoryEntry.COLUMN_NAME_TITLE + TEXT_TYPE +
                    " )";

    public StoriesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public StoriesDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
    }
}
