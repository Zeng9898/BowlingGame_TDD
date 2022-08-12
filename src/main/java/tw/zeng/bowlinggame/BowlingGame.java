package tw.zeng.bowlinggame;

public class BowlingGame {
    private Frame[] frames;
    private int whichFrame;
    private RollType whichRoll;
    private boolean isGameOver = false;
    public static final int FRAME_SIZE = 10;


//    public BowlingGame () {
//        frames = new Frame[FRAME_SIZE];
//    }
//    private void startGame() {
//        for (int i = 0; i<= 10 ; i++) {
//            Frame f = frames[i];
//            f.....
//        }
//    }


    public void start() {
        whichFrame = 1;
        whichRoll = RollType.FIRST;
        frames = new Frame[FRAME_SIZE];
        for (int i = 0; i < 9; i++) {
            frames[i] = new Frame();
        }
        frames[9] = new TenthFrame();
    }

    public void updateGame() {
        if (whichFrame < 10 && whichRoll == RollType.FIRST && frames[whichFrame - 1].getScoreType().equals("normal")) {
            whichRoll = RollType.SECOND;
        } else if (whichFrame < 10 && whichRoll == RollType.FIRST && frames[whichFrame - 1].getScoreType().equals("strike")) {
            whichFrame++;
        } else if (whichFrame < 10 && whichRoll == RollType.SECOND) {
            whichFrame++;
            whichRoll = RollType.FIRST;
        } else if (whichFrame == 10 && whichRoll == RollType.FIRST && frames[whichFrame - 1].getScoreType().equals("normal")) {
            whichRoll = RollType.SECOND;
        } else if (whichFrame == 10 && whichRoll == RollType.FIRST && frames[whichFrame - 1].getScoreType().equals("strike")) {
            whichRoll = RollType.SECOND;
            frames[whichFrame - 1].setPins(10);
        } else if (whichFrame == 10 && whichRoll == RollType.SECOND && frames[whichFrame - 1].getScoreType().equals("normal")) {
            isGameOver = true;
        } else if (whichFrame == 10 && whichRoll == RollType.SECOND && frames[whichFrame - 1].getScoreType().equals("spare")) {
            whichRoll = RollType.EXTRA;
            frames[whichFrame - 1].setPins(10);
        } else if (whichFrame == 10 && whichRoll == RollType.SECOND && frames[whichFrame - 1].getFrameScore() == 20 && frames[whichFrame - 1].getScoreType().equals("strike")) {
            whichRoll = RollType.EXTRA;
            frames[whichFrame - 1].setPins(10);
        } else if (whichFrame == 10 && whichRoll == RollType.SECOND && frames[whichFrame - 1].getFrameScore() < 20 && frames[whichFrame - 1].getScoreType().equals("strike")) {
            whichRoll = RollType.EXTRA;
        } else if (whichFrame == 10 && whichRoll == RollType.EXTRA) {
            isGameOver = true;
        }

//        if (whichFrame < 10 && whichRoll == "first") {
//            if (frames[whichFrame - 1].getScoreType().equals("normal")) {
//                whichRoll = "second";
//            } else if (frames[whichFrame - 1].getScoreType().equals("strike")) {
//                whichFrame++;
//            }
//        } else if (whichFrame < 10 && whichRoll == "second") {
//            whichFrame++;
//            whichRoll = "first";
//        } else if (whichFrame == 10 && whichRoll == "first") {
//            if (frames[whichFrame - 1].getScoreType().equals("normal")) {
//                whichRoll = "second";
//            }
//        }
    }

    public void updateBonus() {
        for (int frame = 0; frame < whichFrame - 1; frame++) {
            if (frames[frame].getScoreType().equals("strike")
                    && frames[frame + 1].getRoll(RollType.FIRST).getRollScore() != -1
                    && frames[frame + 1].getRoll(RollType.SECOND).getRollScore() != -1) {

                int bonus = frames[frame + 1].getRoll(RollType.FIRST).getRollScore() + frames[frame + 1].getRoll(RollType.SECOND).getRollScore();
                frames[frame].setBonus(bonus);
            } else if (frames[frame].getScoreType().equals("strike")
                    && frames[frame + 1].getRoll(RollType.FIRST).getRollScore() != -1
                    && frames[frame + 1].getRoll(RollType.SECOND).getRollScore() == -1
                    && frames[frame + 2].getRoll(RollType.FIRST).getRollScore() != -1) {

                int bonus = frames[frame + 1].getRoll(RollType.FIRST).getRollScore() + frames[frame + 2].getRoll(RollType.FIRST).getRollScore();
                frames[frame].setBonus(bonus);

            } else if (frames[frame].getScoreType().equals("strike")
                    && frames[frame + 1].getRoll(RollType.FIRST).getRollScore() != -1
                    && frames[frame + 1].getRoll(RollType.SECOND).getRollScore() == -1) {

                int bonus = frames[frame + 1].getRoll(RollType.FIRST).getRollScore();
                frames[frame].setBonus(bonus);

            } else if (frames[frame].getScoreType().equals("spare") && frames[frame + 1].getRoll(RollType.FIRST).getRollScore() != -1) {
                int bonus = frames[frame + 1].getRoll(RollType.FIRST).getRollScore();
                frames[frame].setBonus(bonus);
            }
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public int getWhichFrame() {
        return whichFrame;
    }

    public void setWhichFrame(int whichFrame) {
        this.whichFrame = whichFrame;
    }

    public RollType getWhichRoll() {
        return whichRoll;
    }

    public void setWhichRoll(RollType whichRoll) {
        this.whichRoll = whichRoll;
    }

    public Frame[] getFrames() {
        return frames;
    }
}
