package ws.bilka.learnenglish.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import ws.bilka.learnenglish.R;

public class WordsProvider extends ContentProvider {

    private WordsSQLiteDbHelper mWordsSQLiteDbHelper;

    static final int TOPIC = 100;
    static final int TOPIC_WITH_SUBTOPIC = 101;
    static final int TOPIC_WITH_SUBTOPIC_AND_WORD = 102;


    static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = WordsContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, WordsContract.PATH_TOPIC,TOPIC );
        matcher.addURI(authority, WordsContract.PATH_TOPIC + "/*", TOPIC_WITH_SUBTOPIC);
        matcher.addURI(authority, WordsContract.PATH_TOPIC + "/*/#", TOPIC_WITH_SUBTOPIC_AND_WORD);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        mWordsSQLiteDbHelper = new WordsSQLiteDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = mWordsSQLiteDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WordsContract.TopicEntry.COLUMN_TOPIC_ID, TOPIC );
        contentValues.put(WordsContract.TopicEntry.COLUMN_TOPIC_NAME, R.id.list_item_topic_textView);
        contentValues.put(WordsContract.TopicEntry.COLUMN_TOPIC_TRANSLATION, R.id.list_item_title_translate_textview);

        long newRowId;
        newRowId = db.insert(
                WordsContract.TopicEntry.TABLE_NAME,
                WordsContract.TopicEntry.COLUMN_TOPIC_NAME,
                values);
        return insert(uri,values);

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
