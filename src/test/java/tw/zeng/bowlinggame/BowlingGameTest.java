package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    @Test
    void givenABowlingGameWithAllStrike_whenCallApplyBonus_thenShouldDoTheRightUpdate() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        Frame[] frames = bowlingGame.getFrames();
        for (int i = 0; i <= 9; i++) {
            frames[i].getRoll("first").setRollScore(10);
            frames[i].refreshPins(10);
            frames[i].refreshFrameScore();
        }
    }
//    @Test
//    void givenBowlingGameInFrame1to10InFirstRollWithNoStrike_whenCallRefreshGame_shouldBeSecondRoll() {
//        //given
//        BowlingGame bowlingGame = new BowlingGame();
//        bowlingGame.start();
//        for (int i = 1; i < 10; i++) {
//            bowlingGame.setWhichFrame(i);
//            bowlingGame.setWhichRoll("first");
//
//            bowlingGame.refreshGame();
//            assertEquals("second", bowlingGame.getWhichRoll());
//        }
//    }
//
//    @Test
//    void givenBowlingGameInFrame1to9InSecondRoll_whenCallRefreshGame_shouldBeNextFrameAndFirstRoll() {
//        BowlingGame bowlingGame = new BowlingGame();
//        bowlingGame.start();
//        for (int frame = 1; frame < 9; frame++) {
//            bowlingGame.setWhichFrame(frame);
//            bowlingGame.setWhichRoll("second");
//            bowlingGame.refreshGame();
//            assertEquals(i + 1, bowlingGame.getWhichFrame());
//            assertEquals("first", bowlingGame.getWhichRoll());
//        }
//    }

//    @Test
//    void givenBowlingGameInFrame10AndIn_whenCallIsGameOver_shouldReturnFalse() {
//        //given
//        var bowlingGame = new BowlingGame();
//        bowlingGame.start();
//        for(int i = 1; i <= 9; i++){
//            bowlingGame.setWhichFrame(i);
//            assertEquals(false, bowlingGame.isGameOver());
//        }
//    }
//    @Test
//    void givenBowlingGameWithLastRoll_whenCallIsGameover_shouldReturnFalseWhenGameIsProceeding() {
//        //given
//        var bowlingGame = new BowlingGame();
//        bowlingGame.start();
//        Frame frames = bowlingGame.getFrames();
//        frames[8].
//        //when
//        boolean gameOver = bowlingGame.isGameOver();
//        //then
//        assertEquals(false, gameOver);
//    }
}