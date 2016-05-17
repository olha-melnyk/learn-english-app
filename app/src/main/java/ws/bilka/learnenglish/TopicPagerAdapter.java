package ws.bilka.learnenglish;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import ws.bilka.learnenglish.model.Topic;

public class TopicPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private List<Topic> mTopics;

    public TopicPagerAdapter(FragmentManager fm, Context context, List<Topic> topics) {
        super(fm);
        this.mContext = context;
        this.mTopics = topics;
    }

    @Override
    public int getCount() {
        return mTopics.size();
    }

    @Override
    public Fragment getItem(int position) {
        Topic topic = mTopics.get(position);
        int iconResourceId = Utility.getIconResourceIdForTopic(topic.getTopicName());

        return TopicSlidePageFragment.newInstance(topic, iconResourceId);
    }
}
