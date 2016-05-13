package ws.bilka.learnenglish.model;

import java.util.ArrayList;
import java.util.List;

public class Subtopic {
    private final String mSubtopicName;
    private final String mSubtopicTranslation;
    private List<Word> mWordList = new ArrayList<>();

    public Subtopic(String subtopicName, String subtopicTranslation) {
        mSubtopicName = subtopicName;
        mSubtopicTranslation = subtopicTranslation;
    }

    public String getSubtopicName() {
        return mSubtopicName;
    }

    public String getSubtopicTranslation() {
        return mSubtopicTranslation;
    }

    public void addWord(Word word) {
        mWordList.add(word);
    }

    public List<Word> getWords() {
        return mWordList;
    }
}
