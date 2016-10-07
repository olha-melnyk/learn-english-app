package ws.bilka.learnenglish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import ws.bilka.learnenglish.model.Subtopic;
import ws.bilka.learnenglish.model.Topic;

public class TopicSlidePageFragment extends Fragment {
    private static final String ARG_TOPIC = "topic";
    private static final String ARG_IMAGE_DRAWABLE_ID = "image";

    private static final String TAG = TopicSlidePageFragment.class.getSimpleName();
    private Topic mTopic;
    private int mImageResourceId;

    public TopicSlidePageFragment() {
    }

    public static TopicSlidePageFragment newInstance(Topic topic, int image) {
        TopicSlidePageFragment fragment = new TopicSlidePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TOPIC, new Gson().toJson(topic));
        args.putInt(ARG_IMAGE_DRAWABLE_ID, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        if (getArguments() != null) {
            mTopic = new Gson().fromJson(getArguments().getString(ARG_TOPIC), Topic.class);
            mImageResourceId = getArguments().getInt(ARG_IMAGE_DRAWABLE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic_slide_page, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_item_pager);

        final TextView topicName = (TextView) view.findViewById(R.id.list_item_topic_textView);
        TextView topicTranslation = (TextView) view.findViewById(R.id.list_item_words_textView);
        ImageView imageView = (ImageView) view.findViewById(R.id.list_item_icon);

        topicName.setText(mTopic.getTopicName());
        topicTranslation.setText(mTopic.getTopicTranslation());
        imageView.setImageResource(mImageResourceId);
        Log.i(TAG,mImageResourceId + "image");

        final List<Subtopic> subtopics = mTopic.getSubtopics();
        final SubtopicListAdapter adapter = new SubtopicListAdapter(this.getContext(), subtopics);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), CardActivity.class);
                Subtopic subtopic = subtopics.get(position);
                intent.putExtra("subtopic_id", subtopic.getId());
                startActivity(intent);
            }
        });
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
