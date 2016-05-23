package ws.bilka.learnenglish;

import android.content.Context;
import android.content.Intent;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ws.bilka.learnenglish.database.WordsContract;
import ws.bilka.learnenglish.database.WordsSQLiteDbHelper;
import ws.bilka.learnenglish.model.Word;

public class CardActivity extends AppCompatActivity {

    private static final String TAG = CardActivity.class.getSimpleName();

    private ViewPager mViewPager;
    private static final int NUM_OF_RESPONSES = 6;
    private int[] numOfRightAnswers = new int[1];
    private int[] numOfWrongAnswers = new int[1];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final long subtopicId = getIntent().getLongExtra("subtopic_id", -1);
        setContentView(R.layout.activity_card_slide);
        mViewPager = (ViewPager) findViewById(R.id.pagerCard);

        final List<Word> words = loadWords(subtopicId);
        AnswerClickHandler answerClickHandler = new AnswerClickHandler() {
            @Override
            public void onClick(String answer) {
                int currentPosition = mViewPager.getCurrentItem();
                String rightAnswer = words.get(currentPosition % words.size()).getTranslation();

                if (answer.equals(rightAnswer)) {
                    numOfRightAnswers[0]++;
                } else {
                    numOfWrongAnswers[0]++;
                }

                int nextItemPosition = currentPosition + 1;
                if (nextItemPosition == words.size()) {
                    Intent gameStatsIntent = new Intent(CardActivity.this, StatsFragment.class);
                    gameStatsIntent.putExtra("right", numOfRightAnswers[0]);
                    gameStatsIntent.putExtra("wrong", numOfWrongAnswers[0]);
                    gameStatsIntent.putExtra("subtopic", subtopicId);
                    startActivity(gameStatsIntent);
                } else {
                    mViewPager.setCurrentItem(nextItemPosition);
                }
            }
        };
        final PagerAdapter pagerAdapter = new CardPagerAdapter(getSupportFragmentManager(), this, loadWords(subtopicId), answerClickHandler);
        mViewPager.setAdapter(pagerAdapter);

//        final View nextButton = findViewById(R.id.btnNext);
//        nextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
//            }
//        });
//
//        final View prevButton = findViewById(R.id.btnPrev);
//        prevButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
//            }
//        });
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
        while (hasNext) {
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
            startActivity(new Intent(CardActivity.this, MainActivity.class));
        }
    }

    private class CardPagerAdapter extends FragmentStatePagerAdapter {
        private Context mContext;
        private List<Word> mWordList;
        private LayoutInflater mInflater;

        private AnswerClickHandler mAnswerClickHandler;
        private Random mRand = new Random();
        private RandomHelper mRandom = new RandomHelper();

        public CardPagerAdapter(FragmentManager fm, Context context, List<Word> wordList, AnswerClickHandler answerClickHandler) {
            super(fm);
            mContext = context;
            mWordList = wordList;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mAnswerClickHandler = answerClickHandler;
        }

        @Override
        public Fragment getItem(int position) {

            int index = position % mWordList.size();

            String[] possibleAnswers = new String[NUM_OF_RESPONSES];
            List<Word> words = new LinkedList<>(mWordList);

            Collections.shuffle(Arrays.asList(possibleAnswers));

            if (position < mWordList.size()) {
                String word = mWordList.get(index).getOrigin();
                String transcription = mWordList.get(index).getTranscription();
                String translation = mWordList.get(index).getTranslation();
                String example = mWordList.get(index).getExample();
                return CardPageFragment.newInstance(word, transcription, translation, example);
            } else if(position < mWordList.size() * 2) {
                possibleAnswers[0] = words.remove(index).getTranslation();
                for (int i = 1; i < NUM_OF_RESPONSES; i++) {
                    int randIndex = mRand.nextInt(words.size());
                    possibleAnswers[i] = words.remove(randIndex).getTranslation();
                }
                String nameWord = mWordList.get(index).getOrigin();
                ChooseFragment chooseFragment = ChooseFragment.newInstance(nameWord, possibleAnswers);
                chooseFragment.setAnswerClickHandler(mAnswerClickHandler);
                return chooseFragment;

            } else if (position < mWordList.size() * 3) {
                String word = mWordList.get(index).getOrigin();
                int randInd = mRandom.randInt(mWordList.size(), index);
                String[] answers = new String[]{mWordList.get(index).getTranslation(), mWordList.get(randInd).getTranslation()};
                Collections.shuffle(Arrays.asList(answers));
                TrueFalseFragment trueFalseFragment = TrueFalseFragment.newInstance(word, answers[0], answers[1]);
                trueFalseFragment.setAnswerClickHandler(mAnswerClickHandler);
                return trueFalseFragment;
            } else {
                return StatsFragment.newInstance(numOfRightAnswers[0], numOfWrongAnswers[0]);
            }
        }

        @Override
        public int getCount() {
            return mWordList.size() * 3 + 1;
        }
    }
}
