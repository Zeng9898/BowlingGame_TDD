package tw.zeng.bowlinggame;

import javax.lang.model.type.NullType;

public class Frame {

    protected int frameScore;
    protected int bonus;
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
        if (firstRoll.getRollScore() != -1 && secondRoll.getRollScore() != -1) {
            frameScore = firstRoll.getRollScore() + secondRoll.getRollScore();
        } else if (firstRoll.getRollScore() != -1 && secondRoll.getRollScore() == -1) {
            frameScore = firstRoll.getRollScore();
        } else {
            frameScore = 0;
        }
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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
