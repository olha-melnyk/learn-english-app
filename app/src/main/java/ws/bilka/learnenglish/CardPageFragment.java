package ws.bilka.learnenglish;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CardPageFragment extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater. inflate(R. layout.fragment_card, container,false );

        Bundle bundle = this.getArguments();
        String word = bundle.getString("word");
        TextView wordEngTextView = (TextView)rootView.findViewById(R.id.textEngWord);
        wordEngTextView.setText(word);

        String transcription = bundle.getString("transcription");
        TextView wordTranscriptionTextView = (TextView)rootView.findViewById(R.id.textTranscription);
        wordTranscriptionTextView.setText(transcription);

        String translation = bundle.getString("translation");
        TextView wordTranslationTextView = (TextView)rootView.findViewById(R.id.textRusWord);
        wordTranslationTextView.setText(translation);

        String example = bundle.getString("example");
        TextView wordExampleTextView = (TextView)rootView.findViewById(R.id.textExample);
        wordExampleTextView.setText(example);

        return rootView ;
    }

}
