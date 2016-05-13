package ws.bilka.learnenglish;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

public class CardActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String subtopic = getIntent().getStringExtra("subtopic");
        String topic = getIntent().getStringExtra("topic");
        setContentView(R.layout.activity_card_slide);

        mViewPager = (ViewPager) findViewById(R.id.pagerCard);
        final PagerAdapter pagerAdapter = new CardPagerAdapter (getSupportFragmentManager(), CardActivity.this, Utility.getWords(topic, subtopic));
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
            Fragment fragment = new CardPageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("word", mWordList.get(position).getOrigin());
            bundle.putString("transcription", mWordList.get(position).getTranscription());
            bundle.putString("translation", mWordList.get(position).getTranslation());
            bundle.putString("example", mWordList.get(position).getExample());
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return mWordList.size();
        }
    }
}
