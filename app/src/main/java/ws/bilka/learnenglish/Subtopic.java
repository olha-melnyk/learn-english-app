package ws.bilka.learnenglish;

import java.util.ArrayList;
import java.util.List;

public class Subtopic {
    private final String mSubtopic;
    private final String mTranslationSubtopic;
    private List<Word> mWordList = new ArrayList<>();

    public Subtopic(String subtopic, String translationSubtopic) {
        mSubtopic = subtopic;
        mTranslationSubtopic = translationSubtopic;
    }

    public String getSubtopic() {
        return mSubtopic;
    }

    public String getTranslationSubtopic() {
        return mTranslationSubtopic;
    }

    public void addWord(Word word) {
        mWordList.add(word);
    }

    public List<Word> getWordList() {
        return mWordList;
    }
}
