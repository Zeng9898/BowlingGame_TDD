package tw.zeng.bowlinggame;


import java.util.Random;

public class Roll {

    private int rollScore = 0;
    private int rollType;

    Roll(RollType type) {
        this.rollType = type.getType();
    }

    int randomThrow(int limitNum) {
        Random rand = new Random();
        this.rollScore = rand.nextInt(limitNum + 1);
        return this.rollScore;
    }

    public int getRollScore() {
        return rollScore;
    }

    public void setRollScore(int rollScore) {
        this.rollScore = rollScore;
    }

    public int getRollType() {
        return rollType;
    }
}
