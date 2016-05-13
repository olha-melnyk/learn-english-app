package ws.bilka.learnenglish;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CardPageFragment extends Fragment {

    private static final String ARG_WORD = "word";
    private static final String ARG_TRANSCRIPTION = "transcription";
    private static final String ARG_TRANSLATE = "translation";
    private static final String ARG_EXAMPLE = "example";

    private String mWord;
    private String mTranscription;
    private String mTranslation;
    private String mExample;

    public CardPageFragment () {
    }

    public static CardPageFragment newInstance(String word, String transcription, String translation, String example) {
        CardPageFragment fragment = new CardPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_WORD,word);
        args.putString(ARG_TRANSCRIPTION, transcription);
        args.putString(ARG_TRANSLATE, translation);
        args.putString(ARG_EXAMPLE, example);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mWord = getArguments().getString(ARG_WORD);
            mTranscription = getArguments().getString(ARG_TRANSCRIPTION);
            mTranslation = getArguments().getString(ARG_TRANSLATE);
            mExample = getArguments().getString(ARG_EXAMPLE);
        }
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater. inflate(R. layout.fragment_card, container,false );

        TextView wordEngTextView = (TextView)rootView.findViewById(R.id.textEngWord);
        wordEngTextView.setText(mWord);

        TextView wordTranscriptionTextView = (TextView)rootView.findViewById(R.id.textTranscription);
        wordTranscriptionTextView.setText(mTranscription);

        TextView wordTranslationTextView = (TextView)rootView.findViewById(R.id.textRusWord);
        wordTranslationTextView.setText(mTranslation);

        TextView wordExampleTextView = (TextView)rootView.findViewById(R.id.textExample);
        wordExampleTextView.setText(mExample);

        return rootView;
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
