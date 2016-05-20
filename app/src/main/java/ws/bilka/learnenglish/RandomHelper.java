package ws.bilka.learnenglish;

import java.util.Random;

public class RandomHelper {

    private final Random mRandom = new Random();

    public int randInt(int n, int except) {
        int rand = mRandom.nextInt(n);
        if(rand == except) {
            if(rand > 0) return except - 1;
            else return except + 1;
        } else {
            return rand;
        }
    }
}
