package ws.bilka.learnenglish;

public class Subtopic {
    private final String mSubtopic;
    private final String mTranslationSubtopic;

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
}
