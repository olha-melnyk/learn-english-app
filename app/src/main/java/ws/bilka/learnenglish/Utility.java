package ws.bilka.learnenglish;

public class Utility {

    private Utility() {
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
                return R.drawable.colors;
            default:
                return R.drawable.nature;
        }
    }
}
