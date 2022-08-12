package tw.zeng.bowlinggame;

public class Frame {

    protected int score;
    protected int bonus;
    protected ScoreType scoreType;
    protected int pins = 10;
    public static final int MAX_PINS = 10;
    protected Roll firstRoll = new Roll(RollType.FIRST);
    protected Roll secondRoll = new Roll(RollType.SECOND);


    public Roll getRoll(RollType type) {
        if (type == RollType.FIRST) {
            return firstRoll;
        } else {
            return secondRoll;
        }
    }

    public void updateFrameScore(int pins) {
//        if (firstRoll.getRollScore() != -1 && secondRoll.getRollScore() != -1) {
//            frameScore = firstRoll.getRollScore() + secondRoll.getRollScore();
//        } else if (firstRoll.getRollScore() != -1 && secondRoll.getRollScore() == -1) {
//            frameScore = firstRoll.getRollScore();
//        } else {
//            frameScore = 0;
//        }

        this.score += pins;
    }

    public void updatePins(int pins) {
        this.pins -= pins;
    }

    public void updateScoreTypeByRollType(RollType rollType) {
        if (rollType == RollType.FIRST && this.getScore() == MAX_PINS) {
            scoreType = ScoreType.STRIKE;
        } else if (this.getScore() == MAX_PINS) {
            scoreType = ScoreType.SPARE;
        } else {
            scoreType = ScoreType.NORMAL;
        }
//        if (firstRoll.getRollScore() == MAX_PINS) {
//            scoreType = ScoreType.STRIKE.getType();
//        } else if (this.getScore() == MAX_PINS) {
//            scoreType = ScoreType.SPARE.getType();
//        } else {
//            scoreType = ScoreType.NORMAL.getType();
//        }
    }


    public ScoreType getScoreType() {
        return scoreType;
    }

    public int getScore() {
        return score;
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
