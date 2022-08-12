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
            bowlingGame.setWhichRoll(RollType.FIRST);
            bowlingGame.getFrames()[frame].getRoll(RollType.FIRST).setRollScore(notStrikeNum);
            bowlingGame.getFrames()[frame].updateFrameScore(notStrikeNum);
            bowlingGame.getFrames()[frame].updatePins(notStrikeNum);
            bowlingGame.getFrames()[frame].updateScoreTypeByRollType(RollType.FIRST);
            //when
            bowlingGame.updateGame();
            //then
            assertEquals(RollType.SECOND, bowlingGame.getWhichRoll());
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
            bowlingGame.setWhichRoll(RollType.FIRST);
            bowlingGame.getFrames()[frame].getRoll(RollType.FIRST).setRollScore(strike);
            bowlingGame.getFrames()[frame].updateFrameScore(strike);
            bowlingGame.getFrames()[frame].updatePins(strike);
            bowlingGame.getFrames()[frame].updateScoreTypeByRollType(RollType.FIRST);
            //when
            bowlingGame.updateGame();
            //then
            assertEquals(RollType.FIRST, bowlingGame.getWhichRoll());
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
            bowlingGame.setWhichRoll(RollType.FIRST);
            bowlingGame.getFrames()[frame].getRoll(RollType.FIRST).setRollScore(notStrikeNum);
            bowlingGame.getFrames()[frame].updateFrameScore(notStrikeNum);
            bowlingGame.getFrames()[frame].updatePins(notStrikeNum);
            bowlingGame.getFrames()[frame].updateScoreTypeByRollType(RollType.FIRST);
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            bowlingGame.updateGame();
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            int score = bowlingGame.getFrames()[frame].getRoll(RollType.SECOND).randomThrow(bowlingGame.getFrames()[frame].getPins());
            bowlingGame.getFrames()[frame].updateFrameScore(score);
            bowlingGame.getFrames()[frame].updatePins(notStrikeNum);
            bowlingGame.getFrames()[frame].updateScoreTypeByRollType(RollType.SECOND);
            //when
            bowlingGame.updateGame();
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            //System.out.println("--------------------");
            //then
            assertEquals(RollType.FIRST, bowlingGame.getWhichRoll());

            assertEquals(frame + 2, bowlingGame.getWhichFrame());
        }
    }

    @Test
    void givenTenthFrameFirstRollNotStrike_whenCallUpdateGame_thenShouldBeFrameTenAndRollSecond() {
        //given
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        bowlingGame.setWhichFrame(10);
        bowlingGame.setWhichRoll(RollType.FIRST);
        for (int pins = 0; pins < 10; pins++) {
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            bowlingGame.getFrames()[9].getRoll(RollType.FIRST).setRollScore(pins);
            bowlingGame.getFrames()[9].updateFrameScore(pins);
            bowlingGame.getFrames()[9].updatePins(pins);
            bowlingGame.getFrames()[9].updateScoreTypeByRollType(RollType.FIRST);
            //when
            bowlingGame.updateGame();
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            //then
            assertEquals(10, bowlingGame.getWhichFrame());
            assertEquals(RollType.SECOND, bowlingGame.getWhichRoll());
            bowlingGame.setWhichFrame(10);
            bowlingGame.setWhichRoll(RollType.FIRST);
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
        bowlingGame.setWhichRoll(RollType.FIRST);
        //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
        bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(strike);
        bowlingGame.getFrames()[whichFrame - 1].updateFrameScore(strike);
        bowlingGame.getFrames()[whichFrame - 1].updatePins(strike);
        bowlingGame.getFrames()[whichFrame - 1].updateScoreTypeByRollType(RollType.FIRST);
        //System.out.println(bowlingGame.getFrames()[whichFrame - 1].getScoreType());
        //when
        bowlingGame.updateGame();
        //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
        //then
        assertEquals(whichFrame, bowlingGame.getWhichFrame());
        assertEquals(RollType.SECOND, bowlingGame.getWhichRoll());
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
            bowlingGame.setWhichRoll(RollType.FIRST);
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateFrameScore(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updatePins(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateScoreTypeByRollType(RollType.FIRST);
            bowlingGame.updateGame();
            for (int pins2 = 0; pins2 < 10 - pins1 - 1; pins2++) {
                bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(pins2);
                bowlingGame.getFrames()[whichFrame - 1].updateFrameScore(pins2);
                bowlingGame.getFrames()[whichFrame - 1].updatePins(pins2);
                bowlingGame.getFrames()[whichFrame - 1].updateScoreTypeByRollType(RollType.SECOND);
                bowlingGame.updateGame();
                assertTrue(bowlingGame.isGameOver());
            }
            bowlingGame.setWhichFrame(whichFrame);
            bowlingGame.setWhichRoll(RollType.FIRST);
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
            bowlingGame.setWhichRoll(RollType.FIRST);
            //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateFrameScore(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updatePins(pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateScoreTypeByRollType(RollType.FIRST);
            bowlingGame.updateGame();

            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(10 - pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateFrameScore(10 - pins1);
            bowlingGame.getFrames()[whichFrame - 1].updatePins(10 - pins1);
            bowlingGame.getFrames()[whichFrame - 1].updateScoreTypeByRollType(RollType.SECOND);
            //when
            bowlingGame.updateGame();
            //then
            assertEquals(10, bowlingGame.getWhichFrame());
            assertEquals(RollType.EXTRA, bowlingGame.getWhichRoll());
            assertEquals(10, bowlingGame.getFrames()[whichFrame - 1].getPins());

            bowlingGame.setWhichFrame(whichFrame);
            bowlingGame.setWhichRoll(RollType.FIRST);
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(0);
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(0);
        }
    }

    @Test
    void givenTenthFrameFirstRollStrikeAndSecondRollGet10Score_whenCallUpdateGame_thenShouldBeFrameTenAndRollExtraAndTenPins() {
        //given
        final int whichFrame = 10;
        final int strike = 10;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        bowlingGame.setWhichFrame(whichFrame);
        bowlingGame.setWhichRoll(RollType.FIRST);
        //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
        bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(strike);
        bowlingGame.getFrames()[whichFrame - 1].updateFrameScore(strike);
        bowlingGame.getFrames()[whichFrame - 1].updatePins(strike);
        bowlingGame.getFrames()[whichFrame - 1].updateScoreTypeByRollType(RollType.FIRST);
        bowlingGame.updateGame();

        bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(strike);
        bowlingGame.getFrames()[whichFrame - 1].updateFrameScore(strike);
        bowlingGame.getFrames()[whichFrame - 1].updatePins(strike);
        bowlingGame.getFrames()[whichFrame - 1].updateScoreTypeByRollType(RollType.SECOND);
        //when
        bowlingGame.updateGame();
        //then
        assertEquals(10, bowlingGame.getWhichFrame());
        assertEquals(RollType.EXTRA, bowlingGame.getWhichRoll());
        assertEquals(10, bowlingGame.getFrames()[whichFrame - 1].getPins());
    }

    @Test
    void givenTenthFrameFirstRollStrikeAndSecondRollLessThan10Score_whenCallUpdateGame_thenShouldBeFrameTenAndRollExtraAndTLeftPins() {
        //given
        final int whichFrame = 10;
        final int strike = 10;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        bowlingGame.setWhichFrame(whichFrame);
        bowlingGame.setWhichRoll(RollType.FIRST);
        //System.out.printf("frame:%d, roll:%s%n", bowlingGame.getWhichFrame(), bowlingGame.getWhichRoll());
        bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.FIRST).setRollScore(strike);
        bowlingGame.getFrames()[whichFrame - 1].updateFrameScore(strike);
        bowlingGame.getFrames()[whichFrame - 1].updatePins(strike);
        bowlingGame.getFrames()[whichFrame - 1].updateScoreTypeByRollType(RollType.FIRST);
        bowlingGame.updateGame();
        for (int pins2 = 0; pins2 < 10; pins2++) {
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(pins2);
            bowlingGame.getFrames()[whichFrame - 1].updateFrameScore(pins2);
            bowlingGame.getFrames()[whichFrame - 1].updatePins(pins2);
            bowlingGame.getFrames()[whichFrame - 1].updateScoreTypeByRollType(RollType.SECOND);
            //when
            bowlingGame.updateGame();
            //then
            assertEquals(10, bowlingGame.getWhichFrame());
            assertEquals(RollType.EXTRA, bowlingGame.getWhichRoll());
            assertEquals(10 - pins2, bowlingGame.getFrames()[whichFrame - 1].getPins());

            bowlingGame.setWhichRoll(RollType.SECOND);
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.SECOND).setRollScore(0);
            bowlingGame.getFrames()[whichFrame - 1].setPins(10);
        }
    }

    @Test
    void givenTenthFrameExtraRoll_whenCallUpdateGame_thenShouldBeFrameTenAndRollExtraAndTLeftPins() {
        //given
        final int whichFrame = 10;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        bowlingGame.setWhichFrame(whichFrame);
        bowlingGame.setWhichRoll(RollType.EXTRA);
        for (int pins3 = 0; pins3 <= 10; pins3++) {
            bowlingGame.getFrames()[whichFrame - 1].getRoll(RollType.EXTRA).setRollScore(pins3);
            bowlingGame.getFrames()[whichFrame - 1].updateFrameScore(pins3);
            bowlingGame.getFrames()[whichFrame - 1].updatePins(pins3);
            bowlingGame.getFrames()[whichFrame - 1].updateScoreTypeByRollType(RollType.EXTRA);
            //when
            bowlingGame.updateGame();
            //then
            assertTrue(bowlingGame.isGameOver());
        }
    }

    @Test
    void givenBowlingGameInSecondFrameFirstRollAndFirstFrameStrike_whenCallUpdateBonus_thenFirstFrameBonusShouldUpdate() {
        //given
        final int strike = 10;
        final int dummyNum = 5;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        bowlingGame.getFrames()[0].getRoll(RollType.FIRST).setRollScore(strike);
        bowlingGame.getFrames()[0].updateFrameScore(strike);
        bowlingGame.getFrames()[0].updatePins(strike);
        bowlingGame.getFrames()[0].updateScoreTypeByRollType(RollType.FIRST);
        bowlingGame.updateGame();
        bowlingGame.getFrames()[1].getRoll(RollType.FIRST).setRollScore(dummyNum);
        bowlingGame.getFrames()[1].updateFrameScore(dummyNum);
        bowlingGame.getFrames()[1].updatePins(dummyNum);
        bowlingGame.getFrames()[1].updateScoreTypeByRollType(RollType.FIRST);
        //when
        bowlingGame.updateBonus();
        //then
        assertEquals(dummyNum, bowlingGame.getFrames()[0].getBonus());
    }

    @Test
    void givenBowlingGameInSecondFrameSecondRollAndFirstFrameStrike_whenCallUpdateBonus_thenFirstFrameBonusShouldUpdateCorrectly() {
        //given
        final int strike = 10;
        final int dummyNum = 3;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        bowlingGame.getFrames()[0].getRoll(RollType.FIRST).setRollScore(strike);
        bowlingGame.getFrames()[0].updateFrameScore(strike);
        bowlingGame.getFrames()[0].updatePins(strike);
        bowlingGame.getFrames()[0].updateScoreTypeByRollType(RollType.FIRST);
        bowlingGame.updateGame();
        bowlingGame.getFrames()[1].getRoll(RollType.FIRST).setRollScore(dummyNum);
        bowlingGame.getFrames()[1].updateFrameScore(dummyNum);
        bowlingGame.getFrames()[1].updatePins(dummyNum);
        bowlingGame.getFrames()[1].updateScoreTypeByRollType(RollType.FIRST);
        bowlingGame.updateGame();
        bowlingGame.getFrames()[1].getRoll(RollType.SECOND).setRollScore(dummyNum);
        bowlingGame.getFrames()[1].updateFrameScore(dummyNum);
        bowlingGame.getFrames()[1].updatePins(dummyNum);
        bowlingGame.getFrames()[1].updateScoreTypeByRollType(RollType.SECOND);
        bowlingGame.updateGame();
        //when
        bowlingGame.updateBonus();
        //then
        assertEquals(dummyNum + dummyNum, bowlingGame.getFrames()[0].getBonus());
    }

    @Test
    void givenBowlingGameInThirdFrameFirstRollAndFirstFrameStrikeSecondFrameStrike_whenCallUpdateBonus_thenFirstFrameBonusShouldUpdateCorrectly() {
        //given
        final int strike = 10;
        final int dummyNum = 3;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        bowlingGame.getFrames()[0].getRoll(RollType.FIRST).setRollScore(strike);
        bowlingGame.getFrames()[0].updateFrameScore(strike);
        bowlingGame.getFrames()[0].updatePins(strike);
        bowlingGame.getFrames()[0].updateScoreTypeByRollType(RollType.FIRST);
        bowlingGame.updateGame();
        bowlingGame.getFrames()[1].getRoll(RollType.FIRST).setRollScore(strike);
        bowlingGame.getFrames()[1].updateFrameScore(strike);
        bowlingGame.getFrames()[1].updatePins(strike);
        bowlingGame.getFrames()[1].updateScoreTypeByRollType(RollType.FIRST);
        bowlingGame.updateGame();
        bowlingGame.getFrames()[2].getRoll(RollType.FIRST).setRollScore(dummyNum);
        bowlingGame.getFrames()[2].updateFrameScore(dummyNum);
        bowlingGame.getFrames()[2].updatePins(dummyNum);
        bowlingGame.getFrames()[2].updateScoreTypeByRollType(RollType.FIRST);
        bowlingGame.updateGame();

        //when
        bowlingGame.updateBonus();
        //then
        assertEquals(strike + dummyNum, bowlingGame.getFrames()[0].getBonus());
    }

    @Test
    void givenBowlingGameInSecondFrameFirstRollAndFirstFrameSpare_whenCallUpdateBonus_thenFirstFrameBonusShouldUpdateCorrectly() {
        //given
        final int dummyNum = 3;
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
        bowlingGame.getFrames()[0].getRoll(RollType.FIRST).setRollScore(dummyNum);
        bowlingGame.getFrames()[0].updateFrameScore(dummyNum);
        bowlingGame.getFrames()[0].updatePins(dummyNum);
        bowlingGame.getFrames()[0].updateScoreTypeByRollType(RollType.FIRST);
        bowlingGame.updateGame();
        bowlingGame.getFrames()[0].getRoll(RollType.SECOND).setRollScore(10 - dummyNum);
        bowlingGame.getFrames()[0].updateFrameScore(dummyNum);
        bowlingGame.getFrames()[0].updatePins(10 - dummyNum);
        bowlingGame.getFrames()[0].updateScoreTypeByRollType(RollType.SECOND);
        bowlingGame.updateGame();
        bowlingGame.getFrames()[1].getRoll(RollType.FIRST).setRollScore(dummyNum);
        bowlingGame.getFrames()[1].updateFrameScore(dummyNum);
        bowlingGame.getFrames()[1].updatePins(dummyNum);
        bowlingGame.getFrames()[1].updateScoreTypeByRollType(RollType.FIRST);
        bowlingGame.updateGame();

        //when
        bowlingGame.updateBonus();
        //then
        assertEquals(dummyNum, bowlingGame.getFrames()[0].getBonus());
    }

//    @Test
//    void givenNewBowlingGameAllStrike_whenCallScore_thenShouldReturnTheTotalScore() {
//        //given
//        BowlingGame bowlingGame = new BowlingGame();
//        bowlingGame.start();
//        final int strike = 10;
//        for (int frame = 0; frame < 10; frame++) {
//            Frame f = bowlingGame.getFrames()[bowlingGame.getWhichFrame() - 1];
//            f.getRoll(bowlingGame.getWhichRoll()).setRollScore(strike);
//            f.updateFrameScore();
//            f.updateScoreType();
//            f.updatePins(strike);
//            bowlingGame.updateBonus();
//            bowlingGame.updateGame();
//        }
//        assertEquals();
//    }
}