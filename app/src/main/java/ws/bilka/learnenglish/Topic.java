package ws.bilka.learnenglish;

import java.util.LinkedList;
import java.util.List;

public class Topic {

    private final String mTopic;
    private final String mTranslateTopic;
    private List<Subtopic> mSubtopics = new LinkedList<>();

    public Topic(String topic, String translateTopic) {
        mTopic = topic;
        mTranslateTopic = translateTopic ;
    }

    public String getTopic() {
        return mTopic;
    }

    public String getTranslateTopic() {
        return mTranslateTopic;
    }

    public void addSubTopicWords (Subtopic subtopicWords){
        mSubtopics.add(subtopicWords);
    }

    public List<Subtopic> getSubtopicList() {
        return mSubtopics;
    }
}
