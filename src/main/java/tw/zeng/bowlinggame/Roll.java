package tw.zeng.bowlinggame;


import java.util.Random;

public class Roll {

    private int rollScore = 0;
    private final String whichRoll;

    Roll(String whichRoll) {
        if (whichRoll.equals("first") || whichRoll.equals("second") || whichRoll.equals("extra")) {
            this.whichRoll = whichRoll;
        } else {
            throw new IllegalArgumentException();
        }
    }

    int randomThrow(int pins) {
        Random rand = new Random();
        this.rollScore = rand.nextInt(pins + 1);
        return this.rollScore;
    }

    public int getRollScore() {
        return rollScore;
    }

    public void setRollScore(int rollScore) {
        this.rollScore = rollScore;
    }

    public String getWhichRoll() {
        return whichRoll;
    }
}
