package ws.bilka.learnenglish;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import ws.bilka.learnenglish.model.Topic;

public class TopicPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private List<Topic> mTopicList;

    public TopicPagerAdapter(FragmentManager fm, Context context, List<Topic> topicList) {
        super(fm);
        this.mContext = context;
        this.mTopicList = topicList;
    }

    @Override
    public int getCount() {
        return mTopicList.size();
    }

    @Override
    public Fragment getItem(int position) {
        String topic = mTopicList.get(position).getTopicName();
        String topicTranslate = mTopicList.get(position).getTopicTranslation();
        int iconResourceId = Utility.getIconResourceIdForTopic(topic);

        return TopicSlidePageFragment.newInstance(topic, topicTranslate, iconResourceId);
    }

}
