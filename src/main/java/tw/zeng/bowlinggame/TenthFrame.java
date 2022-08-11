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
        if (firstRoll.getRollScore() != -1 && secondRoll.getRollScore() != -1 && extraRoll.getRollScore() != -1) {
            frameScore = firstRoll.getRollScore() + secondRoll.getRollScore() + extraRoll.getRollScore();
        } else if (firstRoll.getRollScore() != -1 && secondRoll.getRollScore() != -1 && extraRoll.getRollScore() == -1){
            frameScore = firstRoll.getRollScore() + secondRoll.getRollScore();
        } else if (firstRoll.getRollScore() != -1 && secondRoll.getRollScore() == -1 && extraRoll.getRollScore() == -1){
            frameScore = firstRoll.getRollScore();
        } else {
            frameScore = 0;
        }
    }
}
