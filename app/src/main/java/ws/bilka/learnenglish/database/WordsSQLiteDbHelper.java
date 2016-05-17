package ws.bilka.learnenglish.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.IOException;
import java.io.InputStream;

import ws.bilka.learnenglish.R;

public class WordsSQLiteDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "LearnEnglishApp.db";
    private static final String TAG = WordsSQLiteDbHelper.class.getSimpleName();

    private Context mContext;

    public WordsSQLiteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteWordDatabase) {

        final String SQL_CREATE_TOPIC_TABLE = "CREATE TABLE " + WordsContract.TopicEntry.TABLE_NAME + " (" +
                WordsContract.TopicEntry.COLUMN_TOPIC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WordsContract.TopicEntry.COLUMN_TOPIC_NAME + " TEXT NOT NULL, " +
                WordsContract.TopicEntry.COLUMN_TOPIC_TRANSLATION + " TEXT NOT NULL " +
                ");";

        final String SQL_CREATE_SUBTOPIC_TABLE = "CREATE TABLE " + WordsContract.SubtopicEntry.TABLE_NAME + " (" +
                WordsContract.SubtopicEntry.COLUMN_SUBTOPIC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WordsContract.SubtopicEntry.COLUMN_TOPIC_KEY + " INTEGER NOT NULL, " +
                WordsContract.SubtopicEntry.COLUMN_SUBTOPIC_NAME + " TEXT NOT NULL, " +
                WordsContract.SubtopicEntry.COLUMN_SUBTOPIC_TRANSLATION + " TEXT NOT NULL " +
                ");";

        final String SQL_CREATE_WORD_TABLE = "CREATE TABLE " + WordsContract.WordEntry.TABLE_NAME + " (" +
                WordsContract.WordEntry.COLUMN_WORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WordsContract.WordEntry.COLUMN_SUBTOPIC_KEY + " INTEGER NOT NULL, " +
                WordsContract.WordEntry.COLUMN_WORD_ORIGIN + " TEXT NOT NULL, " +
                WordsContract.WordEntry.COLUMN_TRANSCRIPTION + " TEXT NOT NULL, " +
                WordsContract.WordEntry.COLUMN_TRANSLATION + " TEXT NOT NULL, " +
                WordsContract.WordEntry.COLUMN_EXAMPLE + " TEXT NOT NULL " +
                ");";

        sqLiteWordDatabase.execSQL(SQL_CREATE_TOPIC_TABLE);
        sqLiteWordDatabase.execSQL(SQL_CREATE_SUBTOPIC_TABLE);
        sqLiteWordDatabase.execSQL(SQL_CREATE_WORD_TABLE);

        Log.i(TAG, "Database onCreate");

        try {
            InputStream inputStream = mContext.getResources().openRawResource(R.raw.db);
            LineIterator lineIterator = IOUtils.lineIterator(inputStream, "UTF8");
            while (lineIterator.hasNext()) {
                String line = lineIterator.nextLine();
                sqLiteWordDatabase.execSQL(line);
            }
            lineIterator.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteWordDatabase , int oldVersion, int newVersion) {

        sqLiteWordDatabase.execSQL("DROP TABLE IF EXISTS " + WordsContract.TopicEntry.TABLE_NAME);
        sqLiteWordDatabase.execSQL("DROP TABLE IF EXISTS " + WordsContract.SubtopicEntry.TABLE_NAME);
        sqLiteWordDatabase.execSQL("DROP TABLE IF EXISTS " + WordsContract.WordEntry.TABLE_NAME);
        onCreate(sqLiteWordDatabase);
    }


}
