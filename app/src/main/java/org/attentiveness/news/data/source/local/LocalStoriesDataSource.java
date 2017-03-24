package org.attentiveness.news.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import org.attentiveness.news.data.Story;
import org.attentiveness.news.data.source.StoriesDataSource;

import java.util.ArrayList;
import java.util.List;

public class LocalStoriesDataSource implements StoriesDataSource {

    private static LocalStoriesDataSource INSTANCE;

    private StoriesDbHelper mDbHelper;

    // Prevent direct instantiation.
    private LocalStoriesDataSource(@NonNull Context context) {
        mDbHelper = new StoriesDbHelper(context);
    }

    public static LocalStoriesDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new LocalStoriesDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void getStories(@NonNull LoadStoriesCallback callback) {
        List<Story> storyList = new ArrayList<>();
        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        String[] projections = {
                StoriesPersistenceContract.StoryEntry.COLUMN_NAME_STORY_ID,
                StoriesPersistenceContract.StoryEntry.COLUMN_NAME_TITLE};
        Cursor cursor = database.query(StoriesPersistenceContract.StoryEntry.TABLE_NAME, projections, null, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int storyId = cursor.getInt(cursor.getColumnIndexOrThrow(StoriesPersistenceContract.StoryEntry.COLUMN_NAME_STORY_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(StoriesPersistenceContract.StoryEntry.COLUMN_NAME_TITLE));
                Story story = new Story(storyId, title);
                storyList.add(story);
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        database.close();
        if (storyList.size() == 0) {
            callback.onDataNotAvailable();
        } else {
            callback.onStoriesLoaded(storyList);
        }
    }

    @Override
    public void getStory(int storyId, @NonNull GetStoryCallback callback) {
        Story story = null;
        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        String[] projections = {
                StoriesPersistenceContract.StoryEntry.COLUMN_NAME_STORY_ID,
                StoriesPersistenceContract.StoryEntry.COLUMN_NAME_TITLE};
        String selection = StoriesPersistenceContract.StoryEntry.COLUMN_NAME_STORY_ID + " = ?";
        String[] selectionArgs = {storyId + ""};
        Cursor cursor = database.query(StoriesPersistenceContract.StoryEntry.TABLE_NAME, projections, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            String title = cursor.getString(cursor.getColumnIndexOrThrow(StoriesPersistenceContract.StoryEntry.COLUMN_NAME_TITLE));
            story = new Story(storyId, title);
        }
        if (cursor != null) {
            cursor.close();
        }
        database.close();
        if (story == null) {
            callback.onDataNotAvailable();
        } else {
            callback.onStoryLoaded(story);
        }
    }

    @Override
    public void saveStory(@NonNull Story story) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(StoriesPersistenceContract.StoryEntry.COLUMN_NAME_STORY_ID, story.getId());
        contentValues.put(StoriesPersistenceContract.StoryEntry.COLUMN_NAME_TITLE, story.getTitle());
        database.insertOrThrow(StoriesPersistenceContract.StoryEntry.TABLE_NAME, null, contentValues);
        database.close();
    }

    @Override
    public void refreshStories() {
        //do nothing
    }

    @Override
    public void deleteAllStories() {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        database.delete(StoriesPersistenceContract.StoryEntry.TABLE_NAME, null, null);
        database.close();
    }

    @Override
    public void deleteStory(int storyId) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        String whereClause = StoriesPersistenceContract.StoryEntry.COLUMN_NAME_STORY_ID + " = ?";
        String[] whereArgs = {storyId + ""};
        database.delete(StoriesPersistenceContract.StoryEntry.TABLE_NAME, whereClause, whereArgs);
        database.close();
    }
}
