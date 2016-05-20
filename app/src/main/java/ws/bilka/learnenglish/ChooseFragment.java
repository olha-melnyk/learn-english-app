package ws.bilka.learnenglish;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ChooseFragment extends Fragment {
    private static final String TAG = ChooseFragment.class.getName();

    private static final String ARG_WORD = "word";
    private static final String ARG_WORD_TRANSLATIONS = "translations";
    private AnswerClickHandler mAnswerClickHandler = null;

    private String mWords;
    private String[] mPossibleAnswers;

    public ChooseFragment() {
        // Required empty public constructor
    }

    public static ChooseFragment newInstance(String words, String[] possibleAnswers) {
        ChooseFragment fragment = new ChooseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_WORD, words);
        args.putStringArray(ARG_WORD_TRANSLATIONS, possibleAnswers);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mWords = getArguments().getString(ARG_WORD);
            mPossibleAnswers = getArguments().getStringArray(ARG_WORD_TRANSLATIONS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose, container, false);

        final TextView name = (TextView) view.findViewById(R.id.chooseWordTextView);
        name.setText(mWords);

        Button[] buttons = new Button[] {
                (Button) view.findViewById(R.id.btnChoose1),
                (Button) view.findViewById(R.id.btnChoose2),
                (Button) view.findViewById(R.id.btnChoose3),
                (Button) view.findViewById(R.id.btnChoose4),
                (Button) view.findViewById(R.id.btnChoose5),
                (Button) view.findViewById(R.id.btnChoose6)
        };

        for(int i=0; i<buttons.length; i++) {
            final Button button = buttons[i];
            button.setText(mPossibleAnswers[i]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mAnswerClickHandler != null)
                        mAnswerClickHandler.onClick(button.getText().toString());
                }
            });
        }
        return view;
    }

    public void setAnswerClickHandler(AnswerClickHandler answerClickHandler) {
        mAnswerClickHandler = answerClickHandler;
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
