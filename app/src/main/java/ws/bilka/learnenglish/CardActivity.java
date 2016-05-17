package ws.bilka.learnenglish;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

import ws.bilka.learnenglish.database.WordsContract;
import ws.bilka.learnenglish.database.WordsSQLiteDbHelper;
import ws.bilka.learnenglish.model.Word;

public class CardActivity extends AppCompatActivity {

    private static final String TAG = CardActivity.class.getSimpleName();

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long subtopicId = getIntent().getLongExtra("subtopic_id", -1);
        setContentView(R.layout.activity_card_slide);

        mViewPager = (ViewPager) findViewById(R.id.pagerCard);
        final PagerAdapter pagerAdapter = new CardPagerAdapter (getSupportFragmentManager(), this, loadWords(subtopicId));
        mViewPager.setAdapter(pagerAdapter);

        final View nextButton = findViewById(R.id.btnNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }
        });

        final View prevButton = findViewById(R.id.btnPrev);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
            }
        });
    }

    private List<Word> loadWords(long subtopicId) {
        WordsSQLiteDbHelper dbHelper = new WordsSQLiteDbHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        List<Word> words = new LinkedList<>();
        Cursor cursor = database.query(
                WordsContract.WordEntry.TABLE_NAME,
                new String[]{
                        WordsContract.WordEntry.COLUMN_WORD_ORIGIN,
                        WordsContract.WordEntry.COLUMN_TRANSCRIPTION,
                        WordsContract.WordEntry.COLUMN_TRANSLATION,
                        WordsContract.WordEntry.COLUMN_EXAMPLE
                },
                WordsContract.WordEntry.COLUMN_SUBTOPIC_KEY + " = " + subtopicId,
                null,
                null,
                null,
                null
        );

        boolean hasNext = cursor.moveToFirst();
        while(hasNext) {
            String origin = cursor.getString(0);
            String transcription = cursor.getString(1);
            String translation = cursor.getString(2);
            String example = cursor.getString(3);

            words.add(new Word(origin, transcription, translation, example));
            hasNext = cursor.moveToNext();
        }

        cursor.close();
        database.close();
        return words;
    }

    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }

    private class CardPagerAdapter extends FragmentStatePagerAdapter {
        private Context mContext;
        private List<Word> mWordList;
        private LayoutInflater mInflater;

        public CardPagerAdapter(FragmentManager fm, Context context, List<Word> wordList) {
            super(fm);
            mContext = context;
            mWordList = wordList;
            mInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public Fragment getItem(int position) {
            String word = mWordList.get(position).getOrigin();
            String transcription = mWordList.get(position).getTranscription();
            String translation = mWordList.get(position).getTranslation();
            String example = mWordList.get(position).getExample();
            return CardPageFragment.newInstance(word, transcription, translation, example);
        }

        @Override
        public int getCount() {
            return mWordList.size();
        }
    }
}
