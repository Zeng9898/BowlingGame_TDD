package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {
    @Test
    void givenAFrame_whenCallGetRoll_thenShouldReturnTheRightRoll() {
        //given
        var frame = new Frame();
        //when
        Roll firstRoll = frame.getRoll("first");
        Roll secondRoll = frame.getRoll("second");
        //then
        assertEquals("first", firstRoll.getWhichRoll());
        assertEquals("second", secondRoll.getWhichRoll());
    }

    @Test
    void givenAFrame_whenCallGetRollWithWrongArgument_thenShouldThrowIllegalArgumentException() {
        //given
        var frame = new Frame();
        //when then
        assertThrows(IllegalArgumentException.class, () -> {
            Roll firstRoll = frame.getRoll("whatever");
        });
    }

    @Test
    void givenAFrameAfterSecondRoll_whenCallUpdateFrameScoreAndUpdatePins_thenShouldDoTheRightUpdate() {
        //given
        var frame = new Frame();
        for (int pins1 = 0; pins1 <= 9; pins1++) {
            frame.getRoll("first").setRollScore(pins1);
            frame.updatePins(pins1);
            frame.updateFrameScore();
            int pins2 = frame.getRoll("second").randomThrow(frame.getPins());
            //when
            frame.updatePins(pins2);
            frame.updateFrameScore();
            //then
            assertEquals(pins1 + pins2, frame.getFrameScore());
            assertEquals(10 - (pins1 + pins2), frame.getPins());
//            System.out.printf("第一投分數：%d 第二投分數：%d %n", pins1, pins2);;
//            System.out.printf("得分：%d %n", frame.getFrameScore());
//            System.out.printf("剩餘瓶數：%d %n", frame.getPins());
            frame.setPins(10);
        }
    }

    @Test
    void givenAFrameAfterFirstRoll_whenCallUpdateFrameScoreAndUpdatePins_thenShouldDoTheRightUpdate() {
        //given
        var frame = new Frame();
        for (int pins = 0; pins <= 10; pins++) {
            frame.getRoll("first").setRollScore(pins);
            //when
            frame.updatePins(pins);
            frame.updateFrameScore();
            //then
            assertEquals(pins, frame.getFrameScore());
            assertEquals(10 - pins, frame.getPins());
//            System.out.printf("分數：%d %n",pins);
//            System.out.printf("得分：%d %n",frame.getFrameScore());
//            System.out.printf("剩餘瓶數：%d %n",frame.getPins());
            frame.setPins(10);
        }
    }

    @Test
    void givenAFrameWith10ScoreInFirstRoll_whenCallUpdateScoreType_thenTheFrameTypeShouldbeStrike() {
        //given
        Frame frame = new Frame();
        frame.getRoll("first").setRollScore(10);
        //when
        frame.updateScoreType();
        //then
        assertEquals("strike", frame.getScoreType());
    }

    @Test
    void givenAFrameWith10ScoreInTwoRolls_whenCallUpdateScoreType_thenTheScoreTypeShouldbeSpare() {
        //given
        Frame frame = new Frame();
        for (int first = 0; first < 10; first++) {
            frame.getRoll("first").setRollScore(first);
            frame.getRoll("second").setRollScore(10 - first);
            frame.updateFrameScore();
            //when
            frame.updateScoreType();
            //then
            assertEquals("spare", frame.getScoreType());
        }
    }

    @Test
    void givenAFrameWithLessThan10ScoreInTwoRolls_whenCallUpdateScoreType_thenTheScoreTypeShouldbeNormal() {
        //given
        Frame frame = new Frame();
        frame.getRoll("first").setRollScore(0);

        for (int k = 0; k <= 9; k++) {
            frame.getRoll("second").setRollScore(k);
            frame.updateFrameScore();
            //when
            frame.updateScoreType();
            //then
            assertEquals("normal", frame.getScoreType());
        }
    }

//    @Test
//    void givenAFrameAfterNotStrikeFirstRoll_whenCallRefreshScoreType_thenScoreTypeShouldbeNull() {
//        Frame frame = new Frame();
//        for (int i = 0; i < 10; i++) {
//            frame.getRoll("first").setRollScore(i);
//            frame.refreshScoreType();
//
//        }
//
//    }
}