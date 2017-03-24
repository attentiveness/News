package org.attentiveness.news.data.source.local;

import android.provider.BaseColumns;

final class StoriesPersistenceContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private StoriesPersistenceContract() {
    }

    /* Inner class that defines the table contents */
    static abstract class StoryEntry implements BaseColumns {
        static final String TABLE_NAME = "story";
        static final String COLUMN_NAME_STORY_ID = "storyId";
        static final String COLUMN_NAME_TITLE = "title";
    }

}
