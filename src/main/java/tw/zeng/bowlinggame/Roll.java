package tw.zeng.bowlinggame;


import java.util.Random;

public class Roll {
    private int rollScore = -1;
    private final String whichRoll;
    Roll(String whichRoll){
        if(whichRoll.equals("first") || whichRoll.equals("second") || whichRoll.equals("extra")) {
            this.whichRoll = whichRoll;
        } else{
            throw new IllegalArgumentException();
        }
    }
    void randomThrow(int pins){
        Random rand = new Random();
        this.rollScore = rand.nextInt(pins);
    }
    public int getRollScore() {
        return rollScore;
    }
    public String getWhichRoll()  { return whichRoll; }
}
