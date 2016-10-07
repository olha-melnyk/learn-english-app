package ws.bilka.learnenglish;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ws.bilka.learnenglish.database.WordsContract;
import ws.bilka.learnenglish.database.WordsSQLiteDbHelper;
import ws.bilka.learnenglish.model.Subtopic;
import ws.bilka.learnenglish.model.Topic;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActionBarAndNavigation();

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new TopicPagerAdapter(getSupportFragmentManager(), this, loadTopics());
        Log.i(TAG, "topic " + loadTopics());
        mPager.setAdapter(mPagerAdapter);
    }

    private void initActionBarAndNavigation() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
