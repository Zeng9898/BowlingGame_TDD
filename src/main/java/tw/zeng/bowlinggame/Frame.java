package tw.zeng.bowlinggame;

import javax.lang.model.type.NullType;

public class Frame {

    protected int frameScore;
    protected String scoreType = null;
    protected int pins = 10;
    protected Roll firstRoll = new Roll("first");
    protected Roll secondRoll = new Roll("second");

    public Roll getRoll(String whichRoll) {
        if (whichRoll.equals("first")) {
            return firstRoll;
        } else if (whichRoll.equals("second")) {
            return secondRoll;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void updateFrameScore() {
        frameScore = firstRoll.getRollScore() + secondRoll.getRollScore();
    }

    public void updatePins(int pins) {
        this.pins -= pins;
    }

    public void updateScoreType() {
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
    public void setPins(int pins) {
        this.pins = pins;
    }

}
