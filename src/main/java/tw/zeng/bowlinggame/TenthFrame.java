package tw.zeng.bowlinggame;

public class TenthFrame extends Frame {
    private Roll extraRoll = new Roll("extra");
    @Override
    public Roll getRoll(String whichRoll) {
        if (whichRoll.equals("first")) {
            return firstRoll;
        } else if (whichRoll.equals("second")) {
            return secondRoll;
        } else if (whichRoll.equals("extra")) {
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
