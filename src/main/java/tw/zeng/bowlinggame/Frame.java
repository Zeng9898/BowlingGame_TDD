package tw.zeng.bowlinggame;

import javax.lang.model.type.NullType;

public class Frame {

    protected int frameScore;
    protected String scoreType;
    protected int pins = 10;
    protected Roll firstRoll = new Roll(RollType.FIRST);
    protected Roll secondRoll = new Roll(RollType.SECOND);

    public Roll getRoll(RollType type) {
        if (type == RollType.FIRST) {
            return firstRoll;
        } else if (type == RollType.SECOND) {
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
        } else if (firstRoll.getRollScore() + secondRoll.getRollScore() == 10) {
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
