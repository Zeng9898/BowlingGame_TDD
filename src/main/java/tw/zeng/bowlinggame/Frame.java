package tw.zeng.bowlinggame;

public class Frame {
    private int frameScore;
    private String scoreType;
    private int pins = 10;
    private Roll firstRoll = new Roll("first");
    private Roll secondRoll = new Roll("second");

    public Roll getRoll(String whichRoll) {
        if (whichRoll.equals("first")) {
            return firstRoll;
        } else if (whichRoll.equals("second")) {
            return secondRoll;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getScoreType() {
        return scoreType;
    }
}
