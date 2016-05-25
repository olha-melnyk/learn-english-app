package ws.bilka.learnenglish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class StatsFragment extends Fragment {
    private static final String TAG = StatsFragment.class.getSimpleName();

    private static final String ARG_NUM_OF_RIGHT_ANSWERS = "right";
    private static final String ARG_NUM_OF_WRONG_ANSWERS = "wrong";
    private static final String ARG_SUBTOPIC_ID = "subtopic_id";

    private int mRightAnswers;
    private int mWrongAnswers;
    private long mSubtopicId;

    public StatsFragment() {
        // Required empty public constructor
    }

    public static StatsFragment newInstance(int rightAnswer, int wrongAnswer, long subtopicId) {

        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NUM_OF_RIGHT_ANSWERS, rightAnswer);
        args.putInt(ARG_NUM_OF_WRONG_ANSWERS, wrongAnswer);
        args.putLong(ARG_SUBTOPIC_ID, subtopicId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRightAnswers = getArguments().getInt(ARG_NUM_OF_RIGHT_ANSWERS);
            mWrongAnswers = getArguments().getInt(ARG_NUM_OF_WRONG_ANSWERS);
            mSubtopicId = getArguments().getLong(ARG_SUBTOPIC_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {

        View viewStats = inflater.inflate(R.layout.fragment_stats, container, false);

        TextView rightTextView = (TextView) viewStats.findViewById(R.id.numberOfRightAnswer);
        TextView wrongTextView = (TextView) viewStats.findViewById(R.id.numberOfWrongAnswer);

        rightTextView.setText(Integer.toString(mRightAnswers));
        wrongTextView.setText(Integer.toString(mWrongAnswers));

        final long subtopic = mSubtopicId;

        final Button tryButton = (Button) viewStats.findViewById(R.id.tryAgainBtn);
        tryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CardActivity.class);
                intent.putExtra("subtopic_id", subtopic);
                startActivity(intent);
            }
        });

        final Button goodButton = (Button)viewStats.findViewById(R.id.goodBtn);
        goodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("subtopic_id", subtopic);
                startActivity(intent);
            }
        });
        return viewStats;
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
