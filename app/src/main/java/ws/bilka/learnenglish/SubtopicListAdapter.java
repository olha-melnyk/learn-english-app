package ws.bilka.learnenglish;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ws.bilka.learnenglish.model.Subtopic;

public class SubtopicListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Subtopic> mSubtopicList;

    public SubtopicListAdapter(Context context, List<Subtopic> subtopicList) {
        this.mContext = context;
        this.mSubtopicList = subtopicList;
    }

    @Override
    public int getCount() {
        return mSubtopicList.size();
    }

    @Override
    public Object getItem(int position) {
        return mSubtopicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Subtopic subtopic = mSubtopicList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_subtopic_item, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.list_item_title_textview);
        TextView titleTranslation = (TextView) convertView.findViewById(R.id.list_item_title_translate_textview);

        title.setText(subtopic.getSubtopicName());
        titleTranslation.setText(subtopic.getSubtopicTranslation());

        return convertView;
    }

    public Context getContext() {
        return mContext;
    }
}
