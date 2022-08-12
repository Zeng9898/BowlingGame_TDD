package tw.zeng.bowlinggame;

public enum ScoreType {
    NORMAL(1),
    SPARE(2),
    STRIKE(3);

    private final int scoreType;

    ScoreType(int type) {
        this.scoreType = type;
    }

    public int getType() {
        return scoreType;
    }
}
