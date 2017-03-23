package org.attentiveness.news.data.source.local;

import android.provider.BaseColumns;

public class StoriesPersistenceContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private StoriesPersistenceContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class StoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "story";
        public static final String COLUMN_NAME_STORY_ID = "storyId";
        public static final String COLUMN_NAME_TITLE = "title";
    }

}
