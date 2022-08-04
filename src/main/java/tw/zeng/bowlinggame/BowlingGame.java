package tw.zeng.bowlinggame;

public class BowlingGame {
    private Frame[] frames;
    private int whichFrame;
    private String whichRoll;

    public void start(int whichFrame, String whichRoll) {
        this.whichFrame = whichFrame;
        this.whichRoll = whichRoll;
        frames = new Frame[10];
    }

    public boolean gameEndOrNot() {
        if (whichFrame < 10) {
            return false;
        } else {
            String lastFrameType = frames[9].getScoreType();
            if (whichRoll.equals("extra")) {
                return true;
            } else if (frames[9].getScoreType().equals("normal")) {
                return true;
            } else {
                return false;
            }
        }
    }


}
