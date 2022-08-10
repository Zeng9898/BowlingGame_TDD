package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TenthFrameTest {
    @Test
    void givenTenthFrame_whenCallGetRoll_thenShouldReturnTheRightRoll() {
        //given
        Frame frame = new TenthFrame();
        //when
        Roll firstRoll = frame.getRoll("first");
        Roll secondRoll = frame.getRoll("second");
        Roll extraRoll = frame.getRoll("extra");
        //then
        assertEquals("first", firstRoll.getWhichRoll());
        assertEquals("second", secondRoll.getWhichRoll());
        assertEquals("extra", extraRoll.getWhichRoll());
    }

    @Test
    void givenTenthFrame_whenCallGetRollWithWrongArgument_thenShouldThrowException() {
        var frame = new TenthFrame();

        assertThrows(IllegalArgumentException.class, () -> {
            Roll firstRoll = frame.getRoll("wrongArgument");
        });
    }

    @Test
    void givenATenthFrameNormal_whenCallUpdateFrameScoreWithUpdatePins_thenShouldDoTheRightUpdate() {
        var frame = new TenthFrame();
        for (int pins1 = 0; pins1 < 10; pins1++) {
            for (int pins2 = 0; pins2 <= 10 - pins1 - 1; pins2++) {
                frame.getRoll("first").setRollScore(pins1);
                frame.updatePins(pins1);
                frame.updateFrameScore();
                frame.getRoll("second").setRollScore(pins2);
                //when
                frame.updatePins(pins2);
                frame.updateFrameScore();
                //then
                assertEquals(pins1 + pins2, frame.getFrameScore());
                assertEquals(10 - (pins1 + pins2), frame.getPins());
//                System.out.printf("第一投分數：%d 第二投分數：%d %n", pins1, pins2);
//                System.out.printf("得分：%d %n", frame.getFrameScore());
//                System.out.printf("剩餘瓶數：%d %n", frame.getPins());
                frame.setPins(10);
            }
        }
    }

    @Test
    void givenTenthFrameFirstRollStrike_whenCallUpdateFrameScoreWithUpdatePins_thenShouldDoTheRightUpdate() {
        //given
        Frame frame = new TenthFrame();
        final int strike = 10;
        frame.getRoll("first").setRollScore(strike);
        frame.updateFrameScore();
        frame.updatePins(strike);
        frame.setPins(strike);
        for (int pins2 = 0; pins2 < 10; pins2++) {
            for (int pins3 = 0; pins3 <= 10 - pins2; pins3++) {
                frame.getRoll("second").setRollScore(pins2);
                //when
                frame.updateFrameScore();
                frame.updatePins(pins2);
                frame.getRoll("extra").setRollScore(pins3);
                frame.updateFrameScore();
                frame.updatePins(pins3);
                //then
                assertEquals(strike + pins2 + pins3, frame.getFrameScore());
                assertEquals(10 - (pins2 + pins3), frame.getPins());
                frame.setPins(10);
            }
        }
    }

    @Test
    void givenTenthFrameSpare_whenCallUpdateFrameScoreWithUpdatePins_thenShouldDoTheRightUpdate() {
        //given
        Frame frame = new TenthFrame();
        for (int pins1 = 0; pins1 < 10; pins1++) {
            frame.getRoll("first").setRollScore(pins1);
            frame.updateFrameScore();
            frame.updatePins(pins1);
            frame.getRoll("second").setRollScore(10 - pins1);
            frame.updateScoreType();
            frame.updatePins(10 - pins1);
            //System.out.printf("---pins1：%d%n", pins1);
            //System.out.printf("---pins2：%d%n", frame.getRoll("second").getRollScore());
            for (int pins3 = 0; pins3 <= 10; pins3++) {
                //System.out.printf("pins3：%d%n", pins3);
                frame.setPins(10);
                frame.getRoll("extra").setRollScore(pins3);
                //when
                frame.updateFrameScore();
                frame.updatePins(pins3);
                //then
                assertEquals(10 + pins3, frame.getFrameScore());
                assertEquals(10 - pins3, frame.getPins());
            }
            frame.updatePins(10);
        }
    }
}