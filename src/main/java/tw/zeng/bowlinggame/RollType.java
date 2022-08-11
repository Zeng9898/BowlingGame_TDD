package tw.zeng.bowlinggame;

public enum RollType {
    FIRST(1),
    SECOND(2),
    EXTRA(3);

    private final int rollType;

    RollType(int type) {
        this.rollType = type;
    }

    public int getType() {
        return rollType;
    }

}
