package ws.bilka.learnenglish;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Temp solution, will be replaced with Database implementation

public class Utility {
    private static List<Topic> sTopics = new ArrayList<>();

    static {
        Topic animalsTopic = new Topic("Animals", "Животные");
            animalsTopic.addSubTopicWords(new Subtopic("Fish", "Рыба"));
            animalsTopic.addSubTopicWords(new Subtopic("Predators", "Хищники"));
            animalsTopic.addSubTopicWords(new Subtopic("Farm", "Ферма"));
            animalsTopic.addSubTopicWords(new Subtopic("Birds", "Птицы"));
            animalsTopic.addSubTopicWords(new Subtopic("Insects", "Насекомые"));
            animalsTopic.addSubTopicWords(new Subtopic("Rodents", "Грызуны"));
            animalsTopic.addSubTopicWords(new Subtopic("Reptiles", "Рептилии"));
            animalsTopic.addSubTopicWords(new Subtopic("Invertebrates", "Беспозвоночные"));
            animalsTopic.addSubTopicWords(new Subtopic("Mammals", "Млекопитающие"));

        Topic eatTopic = new Topic("Food", "еда");
            eatTopic.addSubTopicWords(new Subtopic("Vegetables", "Овощи"));
            eatTopic.addSubTopicWords(new Subtopic("Fruits", "Фрукты"));
            eatTopic.addSubTopicWords(new Subtopic("Sweets", "Сладости"));
            eatTopic.addSubTopicWords(new Subtopic("Products", "Продукты"));
            eatTopic.addSubTopicWords(new Subtopic("Meat", "Mясо"));

        Topic mathematicsTopic = new Topic("Mathematics", "Математика");
            mathematicsTopic.addSubTopicWords(new Subtopic("Цифры", "Digits"));

        Topic natureTopic = new Topic("Nature", "Природа");
        Topic humanTopic = new Topic("Person", "Человек");
        Topic transportTopic = new Topic("Transport", "Транспорт");
        Topic sportTopic = new Topic("Sport", "Спорт");
        Topic restTopic = new Topic("Rest", "Отдых");
        Topic healsTopic = new Topic("Health and beauty", "Здоровье и красота");
        Topic globeTopic = new Topic("Geography", "География");
        Topic clothesTopic = new Topic("Clothes", "Одежда");
        Topic homeTopic = new Topic("House", "Дом");
        Topic scienceTopic = new Topic("Science", "Наука");
        Topic familyTopic = new Topic("Family and friends", "Семья и друзья");
        Topic colorsTopic = new Topic("Colors and figures", "Цвета и фигуры");

        sTopics.add(animalsTopic);
        sTopics.add(eatTopic);
        sTopics.add(mathematicsTopic);
        sTopics.add(natureTopic);
        sTopics.add(humanTopic);
        sTopics.add(transportTopic);
        sTopics.add(sportTopic);
        sTopics.add(restTopic);
        sTopics.add(healsTopic);
        sTopics.add(globeTopic);
        sTopics.add(clothesTopic);
        sTopics.add(homeTopic);
        sTopics.add(scienceTopic);
        sTopics.add(familyTopic);
        sTopics.add(colorsTopic);
    }

    private Utility() {

    }

    public static List<Topic> getTopics() {
        return sTopics;
    }

    public static List<Subtopic> getSubtopicByTopicName(String topicName) {
        for(Topic topic : sTopics) {
            if(topic.getTopic().equals(topicName)) {
                return topic.getSubtopicList();
            }
        }
        throw new NoSuchElementException();
    }

    public static int getIconResourceIdForTopic(String topic) {
        switch (topic) {
            case "Animals":
                return R.drawable.squirrel;
            case "Food":
                return R.drawable.salat;
            case "Job":
                return R.drawable.job;
            case "Nature":
                return R.drawable.nature;
            case "Science":
                return R.drawable.science;
            case "Mathematics":
                return R.drawable.math;
            case "Person":
                return R.drawable.people;
            case "Transport":
                return R.drawable.transport;
            case "Sport":
                return R.drawable.downhill;
            case "Rest":
                return R.drawable.rest;
            case "Health and beauty":
                return R.drawable.beauty;
            case "Geography":
                return R.drawable.geography;
            case "Clothes":
                return R.drawable.clothes;
            case "House":
                return R.drawable.house;
            case "Family and friends":
                return R.drawable.family;
            case "Colors and figures":
                return R.drawable.color;
            default:
                return R.drawable.nature;
        }
    }
}
