package ws.bilka.learnenglish;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class StatsFragment extends Fragment {

    private static final String ARG_NUM_OF_RIGHT_ANSWERS = "right";
    private static final String ARG_NUM_OF_WRONG_ANSWERS = "wrong";

    private int mRightAnswers;
    private int mWrongAnswers;

    public StatsFragment() {
        // Required empty public constructor
    }

    public static StatsFragment newInstance(int rightAnswer, int wrongAnswer) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NUM_OF_RIGHT_ANSWERS, rightAnswer);
        args.putInt(ARG_NUM_OF_WRONG_ANSWERS, wrongAnswer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRightAnswers = getArguments().getInt(ARG_NUM_OF_RIGHT_ANSWERS);
            mWrongAnswers = getArguments().getInt(ARG_NUM_OF_WRONG_ANSWERS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View viewStats = inflater.inflate(R.layout.fragment_stats, container, false);

        TextView rightTextView = (TextView) viewStats.findViewById(R.id.numberOfRightAnswer);
        TextView wrongTextView = (TextView) viewStats.findViewById(R.id.numberOfWrongAnswer);

        rightTextView.setText(Integer.toString(mRightAnswers));
        wrongTextView.setText(Integer.toString(mWrongAnswers));

        final Button tryButton = (Button) viewStats.findViewById(R.id.tryAgainBtn);
        tryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final Button goodButton = (Button)viewStats.findViewById(R.id.goodBtn);
        goodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
