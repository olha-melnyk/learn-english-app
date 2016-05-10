package ws.bilka.learnenglish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SubtopicListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Topic> mTopicList;

    public SubtopicListAdapter(Context context, List<Topic> topicList) {
        this.mContext = context;
        this.mTopicList = topicList;
    }

    @Override
    public int getCount() {
        return mTopicList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTopicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Topic topic = mTopicList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_subtopic_item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.list_item_title_textview);
        TextView titleTranslation = (TextView) convertView.findViewById(R.id.list_item_title_translate_textview);

        title.setText(topic.getTopic());
        titleTranslation.setText(topic.getTopic());

        return convertView;
    }

    public Context getContext() {
        return mContext;
    }
}
