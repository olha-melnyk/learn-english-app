package ws.bilka.learnenglish;

public class Word {
    private final String mOrigin;
    private final String mTranscription;
    private final String mTranslation;
    private final String mExample;

    public Word(String origin, String transcription, String translation, String example) {
        mOrigin = origin;
        mTranscription = transcription;
        mTranslation = translation;
        mExample = example;
    }

    public String getOrigin() {
        return mOrigin;
    }

    public String getTranscription() {
        return mTranscription;
    }

    public String getTranslation() {
        return mTranslation;
    }

    public String getExample() {
        return mExample;
    }
}
