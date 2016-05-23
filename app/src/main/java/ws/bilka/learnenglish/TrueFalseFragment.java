package ws.bilka.learnenglish;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TrueFalseFragment extends Fragment {
    private static final String ARG_WORD = "word";
    private static final String ARG_ANSWER1 = "answer1";
    private static final String ARG_ANSWER2 = "answer2";
    private AnswerClickHandler mAnswerClickHandler = null;


    private String mWords;
    private String mAnswer1;
    private String mAnswer2;

    private OnFragmentInteractionListener mListener;

    public TrueFalseFragment() {
        // Required empty public constructor
    }

    public static TrueFalseFragment newInstance(String word, String answer1, String answer2) {
        TrueFalseFragment fragment = new TrueFalseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_WORD, word);
        args.putString(ARG_ANSWER1, answer1);
        args.putString(ARG_ANSWER2, answer2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mWords = getArguments().getString(ARG_WORD);
            mAnswer1 = getArguments().getString(ARG_ANSWER1);
            mAnswer2 = getArguments().getString(ARG_ANSWER2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_true_false, container, false);

        final TextView name = (TextView) view.findViewById(R.id.trueFalseOriginTextView);
        name.setText(mWords);

        final TextView translation = (TextView) view.findViewById(R.id.trueFalseTranslationTextView);
        translation.setText(mAnswer1);

        Button trueButton = (Button) view.findViewById(R.id.trueAnswerBtn);
        Button falseButton = (Button) view.findViewById(R.id.falseAnswerBtn);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerClickHandler != null)
                    mAnswerClickHandler.onClick(mAnswer1);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerClickHandler != null)
                    mAnswerClickHandler.onClick(mAnswer2);
            }
        });

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void setAnswerClickHandler(AnswerClickHandler answerClickHandler) {
        mAnswerClickHandler = answerClickHandler;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
