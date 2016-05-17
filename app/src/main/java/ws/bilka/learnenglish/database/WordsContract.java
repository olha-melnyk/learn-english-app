package ws.bilka.learnenglish.database;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class WordsContract {
    public static final String CONTENT_AUTHORITY = "ws.bilka.learnenglish";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_TOPIC = TopicEntry.TABLE_NAME;
    public static final String PATH_SUBTOPIC = SubtopicEntry.TABLE_NAME;
    public static final String PATH_WORD = WordEntry.TABLE_NAME;

    public static final class TopicEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOPIC).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOPIC;
        public static final String TABLE_NAME = "topic";

        public static final String COLUMN_TOPIC_ID = "_id";
        public static final String COLUMN_TOPIC_NAME = "name";
        public static final String COLUMN_TOPIC_TRANSLATION = "translation";

        public static Uri buildTopicUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static final class SubtopicEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_SUBTOPIC).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SUBTOPIC;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SUBTOPIC;

        public static final String TABLE_NAME = "subtopic";
        public static final String COLUMN_TOPIC_KEY = "topic_id";
        public static final String COLUMN_SUBTOPIC_ID = "_id";
        public static final String COLUMN_SUBTOPIC_NAME = "name";
        public static final String COLUMN_SUBTOPIC_TRANSLATION = "translation";

        public static Uri buildSubtopicUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static final class WordEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_WORD).build();
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_WORD;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_WORD;

        public static final String TABLE_NAME = "word";
        public static final String COLUMN_WORD_ID = "_id";
        public static final String COLUMN_SUBTOPIC_KEY = "subtopic_id";
        public static final String COLUMN_WORD_ORIGIN = "origin";
        public static final String COLUMN_TRANSCRIPTION = "transcription";
        public static final String COLUMN_TRANSLATION = "translation";
        public static final String COLUMN_EXAMPLE= "example";

        public static Uri buildWordUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

    }
}
