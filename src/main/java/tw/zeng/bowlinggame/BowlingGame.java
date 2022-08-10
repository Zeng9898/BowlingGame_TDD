package tw.zeng.bowlinggame;

public class BowlingGame {
    private Frame[] frames;
    private int whichFrame;
    private String whichRoll;
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
        whichRoll = "first";
        frames = new Frame[FRAME_SIZE];
        for (int i = 0; i < 9; i++) {
            frames[i] = new Frame();
        }
        frames[9] = new TenthFrame();
    }

    public void updateGame() {
        if (whichFrame < 10 && whichRoll == "first" && frames[whichFrame - 1].getScoreType().equals("normal")) {
            whichRoll = "second";
        } else if (whichFrame < 10 && whichRoll == "first" && frames[whichFrame - 1].getScoreType().equals("strike")) {
            whichFrame++;
        } else if (whichFrame < 10 && whichRoll == "second") {
            whichFrame++;
            whichRoll = "first";
        } else if (whichFrame == 10 && whichRoll == "first" && frames[whichFrame - 1].getScoreType().equals("normal")) {
            whichRoll = "second";
        } else if (whichFrame == 10 && whichRoll == "first" && frames[whichFrame - 1].getScoreType().equals("strike")) {
            whichRoll = "second";
            frames[whichFrame - 1].setPins(10);
        } else if (whichFrame == 10 && whichRoll == "second" && frames[whichFrame - 1].getScoreType().equals("normal")) {
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

    public boolean isGameOver() {
        return isGameOver;
    }

    public int getWhichFrame() {
        return whichFrame;
    }

    public void setWhichFrame(int whichFrame) {
        this.whichFrame = whichFrame;
    }

    public String getWhichRoll() {
        return whichRoll;
    }

    public void setWhichRoll(String whichRoll) {
        this.whichRoll = whichRoll;
    }

    public Frame[] getFrames() {
        return frames;
    }
}
