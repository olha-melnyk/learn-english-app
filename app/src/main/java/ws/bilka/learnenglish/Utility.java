package ws.bilka.learnenglish;

import java.util.ArrayList;
import java.util.List;

// Temp solution, will be replaced with Database implementation

public class Utility {
    private static List<Topic> sTopics = new ArrayList<>();

    static {
        Topic animalsTopic = new Topic("Animals", "твари");
        Topic eatTopic = new Topic("Food", "еда");
        Topic mathematicsTopic = new Topic("Mathematics", "Математика");
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
