package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    @Test
    void givenFrame1to10FirstRollNotStrike_whenCallRefreshGame_thenShouldDoTheRightUpdate() {
        //given
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        final int notStrikeNum = 5;
        for (int frame = 0; frame < 10; frame++) {
            bowlingGame.setWhichFrame(frame + 1);
            bowlingGame.setWhichRoll("first");
            bowlingGame.getFrames()[frame].getRoll("first").setRollScore(notStrikeNum);
            bowlingGame.getFrames()[frame].updateFrameScore();
            bowlingGame.getFrames()[frame].updatePins(notStrikeNum);
            bowlingGame.getFrames()[frame].updateScoreType();
            //when
            bowlingGame.refreshGame();
            //then
            assertEquals("second", bowlingGame.getWhichRoll());

            assertEquals(frame + 1, bowlingGame.getWhichFrame());

        }
    }

    @Test
    void givenFrame1to10FirstRollStrike_whenCallRefreshGame_thenShouldDoTheRightUpdate() {
        //given
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        final int strike = 10;
        for (int frame = 0; frame < 10; frame++) {
            bowlingGame.setWhichFrame(frame + 1);
            bowlingGame.setWhichRoll("first");
            bowlingGame.getFrames()[frame].getRoll("first").setRollScore(strike);
            bowlingGame.getFrames()[frame].updateFrameScore();
            bowlingGame.getFrames()[frame].updatePins(strike);
            bowlingGame.getFrames()[frame].updateScoreType();
            //when
            bowlingGame.refreshGame();
            //then
            assertEquals("first", bowlingGame.getWhichRoll());

            assertEquals(frame + 2, bowlingGame.getWhichFrame());

        }
    }
//    @Test
//    void givenFrame1to9AfterSecondRoll_whenCallRefreshGame_thenShouldDoTheRightUpdate(){
//        //given
//        BowlingGame bowlingGame = new BowlingGame();
//        bowlingGame.start();
//        final int notStrikeNum = 5;
//        for (int frame = 0; frame < 9; frame++) {
//            bowlingGame.setWhichFrame(frame + 1);
//            bowlingGame.setWhichRoll("first");
//            bowlingGame.getFrames()[frame].getRoll("first").setRollScore(notStrikeNum);
//            bowlingGame.getFrames()[frame].updateFrameScore();
//            bowlingGame.getFrames()[frame].updatePins(notStrikeNum);
//            bowlingGame.getFrames()[frame].updateScoreType();
//            //when
//            bowlingGame.refreshGame();
//            //then
//            assertEquals("first", bowlingGame.getWhichRoll());
//
//            assertEquals(frame + 2, bowlingGame.getWhichFrame());
//
//        }
//    }
}