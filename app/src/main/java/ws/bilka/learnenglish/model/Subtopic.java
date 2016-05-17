package ws.bilka.learnenglish.model;

public class Subtopic {
    private final long mId;
    private final String mSubtopicName;
    private final String mSubtopicTranslation;

    public Subtopic(long id, String subtopicName, String subtopicTranslation) {
        mId = id;
        mSubtopicName = subtopicName;
        mSubtopicTranslation = subtopicTranslation;
    }

    public long getId() {
        return mId;
    }

    public String getSubtopicName() {
        return mSubtopicName;
    }

    public String getSubtopicTranslation() {
        return mSubtopicTranslation;
    }
}
