package ws.bilka.learnenglish.model;

import java.util.LinkedList;
import java.util.List;

public class Topic {

    private final String mTopicName;
    private final String mTopicTranslation;
    private List<Subtopic> mSubtopics = new LinkedList<>();

    public Topic(String topicName, String topicTranslation) {
        mTopicName = topicName;
        mTopicTranslation = topicTranslation;
    }

    public String getTopicName() {
        return mTopicName;
    }

    public String getTopicTranslation() {
        return mTopicTranslation;
    }

    public void addSubtopic(Subtopic subtopic) {
        mSubtopics.add(subtopic);
    }

    public List<Subtopic> getSubtopics() {
        return mSubtopics;
    }
}
