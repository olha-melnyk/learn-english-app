package ws.bilka.learnenglish;

public class Topic {

    private final String mTopic;
    private final String mTranslateTopic;


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
}
