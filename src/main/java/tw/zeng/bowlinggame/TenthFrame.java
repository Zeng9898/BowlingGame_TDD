package tw.zeng.bowlinggame;

public class TenthFrame extends Frame {
    private Roll extraRoll = new Roll(RollType.EXTRA);

    @Override
    public Roll getRoll(RollType type) {
        if (type == RollType.FIRST) {
            return firstRoll;
        } else if (type == RollType.SECOND) {
            return secondRoll;
        } else if (type == RollType.EXTRA) {
            return extraRoll;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void updateFrameScore() {
        frameScore = firstRoll.getRollScore() + secondRoll.getRollScore() + extraRoll.getRollScore();
    }
}
