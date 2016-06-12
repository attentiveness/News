package org.attentiveness.news.data.source.local;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.attentiveness.news.data.News;

import java.util.ArrayList;
import java.util.List;

public class NewsDao {

    private static NewsDao INSTANCE = null;

    private SQLiteDatabase mDatabase;

    private NewsDao(Context context) {
        DBHelper helper = new DBHelper(context);
        this.mDatabase = helper.getWritableDatabase();
    }

    public static NewsDao getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new NewsDao(context);
        }
        return INSTANCE;
    }

    public void insert(News news) {
        ContentValues values = entityToContentValue(news);
        mDatabase.insertOrThrow(DBHelper.TABLE_NAME, null, values);
    }

    public void update(News news) {
        ContentValues values = entityToContentValue(news);
        mDatabase.update(DBHelper.TABLE_NAME, values, "nid = ? or title = ?", new String[]{news.getId(), news.getTitle()});
    }

    public void delete(String newsId, String title) {
        mDatabase.delete(DBHelper.TABLE_NAME, "nid = ? or title = ?", new String[]{newsId, title});
    }

    public void deleteByChannel(String channelId) {
        mDatabase.delete(DBHelper.TABLE_NAME, "channel_id = ?", new String[]{channelId});
    }

    public void deleteAll() {
        mDatabase.delete(DBHelper.TABLE_NAME, null, null);
    }

    public News query(String newsId, String title) {
        Cursor cursor = mDatabase.query(DBHelper.TABLE_NAME, null, "nid = ? or title = ?", new String[]{newsId, title}, null, null, null);
        News news = null;
        if (cursor.moveToFirst()) {
            news = cursorToEntity(cursor);
        }
        cursor.close();
        return news;
    }

    public List<News> queryByChannel(String channelId) {
        Cursor cursor = mDatabase.query(DBHelper.TABLE_NAME, null, "channel_id = ?", new String[]{channelId}, null, null, null);
        List<News> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            list.add(cursorToEntity(cursor));
        }
        cursor.close();
        return list;
    }

    public List<News> queryAll() {
        Cursor cursor = mDatabase.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);
        List<News> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            list.add(cursorToEntity(cursor));
        }
        cursor.close();
        return list;
    }

    public void close() {
        mDatabase.close();
    }

    private ContentValues entityToContentValue(News news) {
        ContentValues values = new ContentValues();
        values.put("nid", news.getId());
        values.put("channel_id", news.getChannelId());
        values.put("channel_name", news.getChannelName());
        values.put("title", news.getTitle());
        values.put("description", news.getDesc());
        values.put("image_url", news.getImgUrls() != null && news.getImgUrls().length > 0 ? news.getImgUrls()[0].getUrl() : "");
        values.put("source", news.getSource());
        values.put("pub_date", news.getPubDate());
        values.put("link", news.getLink());
        return values;
    }

    private News cursorToEntity(Cursor cursor) {
        News news = new News();
        news.setId(cursor.getString(cursor.getColumnIndex("nid")));
        news.setChannelId(cursor.getString(cursor.getColumnIndex("channel_id")));
        news.setChannelName(cursor.getString(cursor.getColumnIndex("channel_name")));
        news.setTitle(cursor.getString(cursor.getColumnIndex("title")));
        news.setDesc(cursor.getString(cursor.getColumnIndex("description")));

        String url = cursor.getString(cursor.getColumnIndex("image_url"));
        News.ImageUrl imageUrl = news.new ImageUrl();
        imageUrl.setUrl(url);
        news.setImgUrls(new News.ImageUrl[]{imageUrl});

        news.setSource(cursor.getString(cursor.getColumnIndex("source")));
        news.setPubDate(cursor.getString(cursor.getColumnIndex("pub_date")));
        news.setLink(cursor.getString(cursor.getColumnIndex("link")));
        return news;
    }


}
