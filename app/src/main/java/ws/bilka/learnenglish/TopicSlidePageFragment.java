package ws.bilka.learnenglish;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TopicSlidePageFragment extends Fragment {
    private static final String ARG_TOPIC = "topic";
    private static final String ARG_TRANSLATION = "translation";
    private static final String ARG_IMAGE_DRAWABLE_ID = "image";

    private String mTopic;
    private String mTranslation;
    private int mImageResourceId;

    public TopicSlidePageFragment() {
    }

    public static TopicSlidePageFragment newInstance(String topic, String translation, int image) {
        TopicSlidePageFragment fragment = new TopicSlidePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TOPIC, topic);
        args.putString(ARG_TRANSLATION, translation);
        args.putInt(ARG_IMAGE_DRAWABLE_ID, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTopic = getArguments().getString(ARG_TOPIC);
            mTranslation = getArguments().getString(ARG_TRANSLATION);
            mImageResourceId = getArguments().getInt(ARG_IMAGE_DRAWABLE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic_slide_page, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_item_pager);

        TextView topicName = (TextView) view.findViewById(R.id.list_item_topic_textView);
        TextView topicTranslation = (TextView) view.findViewById(R.id.list_item_words_textView);
        ImageView imageView = (ImageView) view.findViewById(R.id.list_item_icon);

        topicName.setText(mTopic);
        topicTranslation.setText(mTranslation);
        imageView.setImageResource(mImageResourceId);

        SubtopicListAdapter adapter = new SubtopicListAdapter(this.getContext(), Utility.getTopics());
        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
