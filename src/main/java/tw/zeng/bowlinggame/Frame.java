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

    public void refreshFrameScore() {
        frameScore = firstRoll.getRollScore() + secondRoll.getRollScore();
    }

    public void refreshPins(int pins) {
        this.pins -= pins;
    }

    public void refreshScoreType() {
        if (firstRoll.getRollScore() == 10) {
            scoreType = "strike";
        } else if (frameScore == 10) {
            scoreType = "spare";
        } else {
            scoreType = "normal";
        }
    }

    public void updateBonus() {

    }

    public String getScoreType() {
        return scoreType;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public int getPins() {
        return pins;
    }

}
