package ws.bilka.learnenglish;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import ws.bilka.learnenglish.model.Subtopic;
import ws.bilka.learnenglish.model.Topic;
import ws.bilka.learnenglish.model.Word;

// Temp solution, will be replaced with Database implementation

public class Utility {
    private static List<Topic> sTopics = new ArrayList<>();

    static {
        Topic animalsTopic = new Topic("Animals", "Животные");
            Subtopic fish = new Subtopic("Fish", "Рыба");
            animalsTopic.addSubtopic(fish);
                fish.addWord(new Word("bass", "[ba:s]", "окунь", " "));
                fish.addWord(new Word("carp", "[ca:p]", "карп", " "));
                fish.addWord(new Word("dolphin", "['dɔlfin]", "дельфин", " "));
                fish.addWord(new Word("eel", "['i:l]", "угорь", " "));
                fish.addWord(new Word("halibut", " ['hælibət]", "палтус", " "));
                fish.addWord(new Word("otter", "['ɔtə]", "выдра", " "));
                fish.addWord(new Word("plaice", "['pleis]", "камбала", " "));
                fish.addWord(new Word("salmon", " ['sæmən]", "лосось", " "));
                fish.addWord(new Word("sawfish", "['sɔ:fiʃ]", "рыба-пила", " "));
                fish.addWord(new Word("scallop", "['skɔləp]", "моллюск", " "));
                fish.addWord(new Word("seahorse", "['si:hɔ:s]", "морской конек", " "));
                fish.addWord(new Word("trout", "['traut]", "форель", " "));
                fish.addWord(new Word("whale", "['weil]", "кит", " "));
                fish.addWord(new Word("tuna/tuna fish", "['tuna]", "тунец", ""));

            Subtopic predators = new Subtopic("Predators", "Хищники");
            animalsTopic.addSubtopic(new Subtopic("Farm", "Ферма"));
            animalsTopic.addSubtopic(new Subtopic("Birds", "Птицы"));
            animalsTopic.addSubtopic(new Subtopic("Insects", "Насекомые"));
            animalsTopic.addSubtopic(new Subtopic("Rodents", "Грызуны"));
            animalsTopic.addSubtopic(new Subtopic("Reptiles", "Рептилии"));
            animalsTopic.addSubtopic(new Subtopic("Invertebrates", "Беспозвоночные"));
            animalsTopic.addSubtopic(new Subtopic("Mammals", "Млекопитающие"));

        Topic eatTopic = new Topic("Food", "еда");
            eatTopic.addSubtopic(new Subtopic("Vegetables", "Овощи"));
            Subtopic food = new Subtopic("Fruits", "Фрукты");
                food.addWord(new Word("banana", "[banana]", "банан", "I need more bananas!"));
                food.addWord(new Word("grapes", "[greip]", "виноград", "If you have diabetes or stomach ulcers stay away from grapes!"));
                food.addWord(new Word("grapefruit", "['greipfru:t]", "грейпфрут", "Grapefruit is one of the best fat burning foods out there."));
                food.addWord(new Word("pear", "[pɛː]", "груша", "Truthfully, I chose this because of the sides: sweet potatoes and pears."));
                food.addWord(new Word("apple", "[ˈap(ə)l]", "яблоко", "Cate picked a few apples from a fruit tree in the grove, wondering if they had any food to eat."));
                food.addWord(new Word("watermelon", "[ˈwɔːtəmɛlən]", "арбуз", "Where available raccoons may also eat peaches, plums, figs, citrus fruits, watermelons, beech nuts, and walnuts."));
                food.addWord(new Word("orange", "[ˈɒrɪn(d)ʒ]", "апельсин", "When an orange is juiced, fibre and other health-giving elements are left behind."));
                food.addWord(new Word("pineapple", "[ˈpʌɪnap(ə)l]", "ананас", "Fruit such as pineapples, coconuts, oranges, mangoes, bananas, apples, and lychees are subject to seasonal availability."));
                food.addWord(new Word("coconut", "[ˈkəʊkənʌt]", "кокос", "These layers surround the hard dark-brown shell, encasing the coconut seed."));
                food.addWord(new Word("peach", "[piːtʃ/]", "персик", "Popular fillings include stone fruits, like peaches and plums."));

            eatTopic.addSubtopic(new Subtopic("Sweets", "Сладости"));
            eatTopic.addSubtopic(new Subtopic("Products", "Продукты"));
            eatTopic.addSubtopic(new Subtopic("Meat", "Mясо"));

        Topic mathematicsTopic = new Topic("Mathematics", "Математика");
            mathematicsTopic.addSubtopic(new Subtopic("Цифры", "Digits"));

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
            if(topic.getTopicName().equals(topicName)) {
                return topic.getSubtopics();
            }
        }
        throw new NoSuchElementException();
    }

    public  static List<Word> getWords(String topicName, String subtopicName) {
        List<Subtopic> subtopics = getSubtopicByTopicName(topicName);
        for (Subtopic subtopic : subtopics) {
            if (subtopic.getSubtopicName().equals(subtopicName)) {
                return subtopic.getWords();
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
