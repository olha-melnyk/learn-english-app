package ws.bilka.learnenglish;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ws.bilka.learnenglish.database.WordsContract;
import ws.bilka.learnenglish.database.WordsSQLiteDbHelper;
import ws.bilka.learnenglish.model.Subtopic;
import ws.bilka.learnenglish.model.Topic;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new TopicPagerAdapter(getSupportFragmentManager(), this, loadTopics());
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private List<Topic> loadTopics() {
        WordsSQLiteDbHelper dbHelper = new WordsSQLiteDbHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.query(
                WordsContract.TopicEntry.TABLE_NAME + ", " + WordsContract.SubtopicEntry.TABLE_NAME,
                new String[]{
                    "topic." + WordsContract.TopicEntry.COLUMN_TOPIC_NAME,
                    "topic." + WordsContract.TopicEntry.COLUMN_TOPIC_TRANSLATION,
                    "subtopic." + WordsContract.SubtopicEntry.COLUMN_SUBTOPIC_ID,
                    "subtopic." + WordsContract.SubtopicEntry.COLUMN_SUBTOPIC_NAME,
                    "subtopic." + WordsContract.SubtopicEntry.COLUMN_SUBTOPIC_TRANSLATION},
                    "subtopic." + WordsContract.SubtopicEntry.COLUMN_TOPIC_KEY + " = " +
                    "topic." + WordsContract.TopicEntry.COLUMN_TOPIC_ID,
                    null,
                    null,
                    null,
                    null
        );

        boolean hasNext = cursor.moveToNext();

        HashMap<String, Topic> map = new HashMap<>();

        while(hasNext) {
            String topicName = cursor.getString(0);
            String topicTranslation = cursor.getString(1);

            long subtopicId = cursor.getLong(2);
            String subtopicName = cursor.getString(3);
            String subtopicTranslation = cursor.getString(4);

            Subtopic subtopic = new Subtopic(subtopicId, subtopicName, subtopicTranslation);

            if(map.containsKey(topicName)) {
                map.get(topicName).addSubtopic(subtopic);
            } else {
                Topic topic = new Topic(topicName, topicTranslation);
                topic.addSubtopic(subtopic);
                map.put(topicName, topic);
            }
            hasNext = cursor.moveToNext();
        }
        cursor.close();
        database.close();
        return new ArrayList<Topic>(map.values());
    }

}
