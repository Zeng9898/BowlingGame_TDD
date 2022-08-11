package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    @Test
    void givenFrame1to9FirstRollNotStrike_whenCallUpdateGame_thenShouldBeSameFrameSecondRoll() {
        //given
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        final int notStrikeNum = 5;
        for (int frame = 0; frame < 9; frame++) {
            bowlingGame.setWhichFrame(frame + 1);
            bowlingGame.setWhichRoll("first");
            bowlingGame.getFrames()[frame].getRoll(RollType.FIRST).setRollScore(notStrikeNum);
            bowlingGame.getFrames()[frame].updateFrameScore();
            bowlingGame.getFrames()[frame].updatePins(notStrikeNum);
            bowlingGame.getFrames()[frame].updateScoreType();
            //when
            bowlingGame.updateGame();
            //then
            assertEquals("second", bowlingGame.getWhichRoll());
            assertEquals(frame + 1, bowlingGame.getWhichFrame());

        }
    }

    @Test
    void givenFrame1to9FirstRollStrike_whenCallRefreshGame_thenShouldBeNextFrameAndFirstRoll() {
        //given
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        final int strike = 10;
        for (int frame = 0; frame < 9; frame++) {
            bowlingGame.setWhichFrame(frame + 1);
            bowlingGame.setWhichRoll("first");
            bowlingGame.getFrames()[frame].getRoll(RollType.FIRST).setRollScore(strike);
            bowlingGame.getFrames()[frame].updateFrameScore();
            bowlingGame.getFrames()[frame].updatePins(strike);
            bowlingGame.getFrames()[frame].updateScoreType();
            //when
            bowlingGame.updateGame();
            //then
            assertEquals("first", bowlingGame.getWhichRoll());
            assertEquals(frame + 2, bowlingGame.getWhichFrame());
        }
    }

    @Test
    void givenFrame1to9InSecondRoll_whenCallRefreshGame_thenShouldBeNextFrameFirstRoll() {
        //given
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        final int notStrikeNum = 5;
        for (int frame = 0; frame < 9; frame++) {
            bowlingGame.setWhichFrame(frame + 1);
            bowlingGame.setWhichRoll("first");
            bowlingGame.getFrames()[frame].getRoll(RollType.FIRST).setRollScore(notStrikeNum);
            bowlingGame.getFrames()[frame].updateFrameScore();
            bowlingGame.getFrames()[frame].updatePins(notStrikeNum);
            bowlingGame.getFrames()[frame].updateScoreType();
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            bowlingGame.updateGame();
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            bowlingGame.getFrames()[frame].getRoll(RollType.SECOND).randomThrow(bowlingGame.getFrames()[frame].getPins());
            bowlingGame.getFrames()[frame].updateFrameScore();
            bowlingGame.getFrames()[frame].updatePins(notStrikeNum);
            bowlingGame.getFrames()[frame].updateScoreType();
            //when
            bowlingGame.updateGame();
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            //System.out.println("--------------------");
            //then
            assertEquals("first", bowlingGame.getWhichRoll());

            assertEquals(frame + 2, bowlingGame.getWhichFrame());
        }
    }

    @Test
    void givenTenthFrameFirstRollNotStrike_whenCallUpdateGame_thenShouldBeFrameTenAndRollSecond() {
        //given
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        bowlingGame.setWhichFrame(10);
        bowlingGame.setWhichRoll("first");
        for (int pins = 0; pins < 10; pins++) {
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            bowlingGame.getFrames()[9].getRoll(RollType.FIRST).setRollScore(pins);
            bowlingGame.getFrames()[9].updateFrameScore();
            bowlingGame.getFrames()[9].updatePins(pins);
            bowlingGame.getFrames()[9].updateScoreType();
            //when
            bowlingGame.updateGame();
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            //then
            assertEquals(10, bowlingGame.getWhichFrame());
            assertEquals("second", bowlingGame.getWhichRoll());
            bowlingGame.setWhichFrame(10);
            bowlingGame.setWhichRoll("first");
        }
    }

    @Test
    void givenTenthFrameFirstRollStrike_whenCallUpdateGame_thenShouldBeFrameTenAndRollSecondAndTenPins() {
        //given
        final int strike = 10;
        final int whichFrame = 10;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        bowlingGame.setWhichFrame(whichFrame);
        bowlingGame.setWhichRoll("first");
        //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
        bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(strike);
        bowlingGame.getFrames()[whichFrame - 1].updateFrameScore();
        bowlingGame.getFrames()[whichFrame - 1].updatePins(strike);
        bowlingGame.getFrames()[whichFrame - 1].updateScoreType();
        //System.out.println(bowlingGame.getFrames()[whichFrame - 1].getScoreType());
        //when
        bowlingGame.updateGame();
        //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
        //then
        assertEquals(whichFrame, bowlingGame.getWhichFrame());
        assertEquals("second", bowlingGame.getWhichRoll());
        assertEquals(10, bowlingGame.getFrames()[whichFrame - 1].getPins());
    }

    @Test
    void givenTenthFrameNormal_whenCallUpdateGame_thenIsGameOverShouldBeTrue() {
        //given
        final int whichFrame = 10;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        for (int pins1 = 0; pins1 < 10; pins1++) {
            bowlingGame.setWhichFrame(whichFrame);
            bowlingGame.setWhichRoll("first");
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateFrameScore();
            bowlingGame.getFrames()[whichFrame - 1].updatePins(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateScoreType();
            bowlingGame.updateGame();
            for (int pins2 = 0; pins2 < 10 - pins1 - 1; pins2++) {
                bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(pins2);
                bowlingGame.getFrames()[whichFrame - 1].updateFrameScore();
                bowlingGame.getFrames()[whichFrame - 1].updatePins(pins2);
                bowlingGame.getFrames()[whichFrame - 1].updateScoreType();
                bowlingGame.updateGame();
                assertEquals(true, bowlingGame.isGameOver());
            }
            bowlingGame.setWhichFrame(whichFrame);
            bowlingGame.setWhichRoll("first");
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(0);
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(0);
        }
    }

    @Test
    void givenTenthFrameSpare_whenCallUpdateGame_thenShouldBeFrameTenAndRollExtraAndTenPins() {
        //given
        final int whichFrame = 10;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        for (int pins1 = 0; pins1 < 10; pins1++) {
            bowlingGame.setWhichFrame(whichFrame);
            bowlingGame.setWhichRoll("first");
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateFrameScore();
            bowlingGame.getFrames()[whichFrame - 1].updatePins(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateScoreType();
            bowlingGame.updateGame();

            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(10 - pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateFrameScore();
            bowlingGame.getFrames()[whichFrame - 1].updatePins(10 - pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateScoreType();
            //when
            bowlingGame.updateGame();
            //then
            assertEquals(10, bowlingGame.getWhichFrame());
            assertEquals("extra", bowlingGame.getWhichRoll());
            assertEquals(10, bowlingGame.getFrames()[whichFrame - 1].getPins());

            bowlingGame.setWhichFrame(whichFrame);
            bowlingGame.setWhichRoll("first");
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(0);
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(0);
        }
    }
    @Test
    void givenTenthFrameFirstRollStrikeAndSecondRollStrike_whenCallUpdateGame_thenShouldBeFrameTenAndRollExtraAndTenPins() {
        //given
        final int whichFrame = 10;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        for (int pins1 = 0; pins1 < 10; pins1++) {
            bowlingGame.setWhichFrame(whichFrame);
            bowlingGame.setWhichRoll("first");
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateFrameScore();
            bowlingGame.getFrames()[whichFrame - 1].updatePins(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateScoreType();
            bowlingGame.updateGame();

            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(10 - pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateFrameScore();
            bowlingGame.getFrames()[whichFrame - 1].updatePins(10 - pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateScoreType();
            //when
            bowlingGame.updateGame();
            //then
            assertEquals(10, bowlingGame.getWhichFrame());
            assertEquals("extra", bowlingGame.getWhichRoll());
            assertEquals(10, bowlingGame.getFrames()[whichFrame - 1].getPins());

            bowlingGame.setWhichFrame(whichFrame);
            bowlingGame.setWhichRoll("first");
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(0);
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(0);
        }
    }

}