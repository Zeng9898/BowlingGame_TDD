package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TenthFrameTest {
    @Test
    void givenATenthFrame_whenCallGetRoll_thenShouldReturnTheRightRoll() {
        //given
        Frame frame = new TenthFrame();
        //when
        Roll firstRoll = frame.getRoll(RollType.FIRST);
        Roll secondRoll = frame.getRoll(RollType.SECOND);
        Roll extraRoll = frame.getRoll(RollType.EXTRA);
        //then
        assertEquals(RollType.FIRST, firstRoll.getRollType());
        assertEquals(RollType.SECOND, secondRoll.getRollType());
        assertEquals(RollType.EXTRA, extraRoll.getRollType());
    }

//    @Test
//    void givenTenthFrame_whenCallGetRollWithWrongArgument_thenShouldThrowException() {
//        var frame = new TenthFrame();
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            Roll firstRoll = frame.getRoll("wrongArgument");
//        });
//    }

//    @Test
//    void givenATenthFrameNormal_whenCallUpdateFrameScoreWithUpdatePins_thenShouldDoTheRightUpdate() {
//        var frame = new TenthFrame();
//        for (int pins1 = 0; pins1 < 10; pins1++) {
//            for (int pins2 = 0; pins2 <= 10 - pins1 - 1; pins2++) {
//                frame.getRoll(RollType.FIRST).setRollScore(pins1);
//                frame.updatePins(pins1);
//                frame.updateFrameScore(pins1);
//                frame.getRoll(RollType.SECOND).setRollScore(pins2);
//                //when
//                frame.updatePins(pins2);
//                frame.updateFrameScore(pins2);
//                System.out.println(pins1);
//                System.out.println(pins2);
//                //then
//                assertEquals(pins1 + pins2, frame.getScore());
//                assertEquals(10 - (pins1 + pins2), frame.getPins());
//                System.out.printf("第一投分數：%d 第二投分數：%d %n", pins1, pins2);
//                System.out.printf("得分：%d %n", frame.getFrameScore());
//                System.out.printf("剩餘瓶數：%d %n", frame.getPins());
//                frame.setPins(10);
//            }
//        }
//    }

//    @Test
//    void givenTenthFrameFirstRollStrike_whenCallUpdateFrameScoreWithUpdatePins_thenShouldDoTheRightUpdate() {
//        //given
//        Frame frame = new TenthFrame();
//        final int strike = 10;
//        frame.getRoll(RollType.FIRST).setRollScore(strike);
//        frame.updateFrameScore(strike);
//        frame.updatePins(strike);
//        frame.setPins(strike);
//        for (int pins2 = 0; pins2 < 10; pins2++) {
//            for (int pins3 = 0; pins3 <= 10 - pins2; pins3++) {
//                frame.getRoll(RollType.SECOND).setRollScore(pins2);
//                //when
//                frame.updateFrameScore(pins2);
//                frame.updatePins(pins2);
//                frame.getRoll(RollType.EXTRA).setRollScore(pins3);
//                frame.updateFrameScore(pins3);
//                frame.updatePins(pins3);
//                //then
//                assertEquals(strike + pins2 + pins3, frame.getScore());
//                assertEquals(10 - (pins2 + pins3), frame.getPins());
//                frame.setPins(10);
//            }
//        }
//    }

//    @Test
//    void givenTenthFrameSpare_whenCallUpdateFrameScoreWithUpdatePins_thenShouldDoTheRightUpdate() {
//        //given
//        Frame frame = new TenthFrame();
//        for (int pins1 = 0; pins1 < 10; pins1++) {
//            frame.getRoll(RollType.FIRST).setRollScore(pins1);
//            frame.updateFrameScore(pins1);
//            frame.updatePins(pins1);
//            frame.getRoll(RollType.SECOND).setRollScore(10 - pins1);
//            frame.updateScoreTypeByRollType(RollType.SECOND);
//            frame.updatePins(10 - pins1);
//            //System.out.printf("---pins1：%d%n", pins1);
//            //System.out.printf("---pins2：%d%n", frame.getRoll("second").getRollScore());
//            for (int pins3 = 0; pins3 <= 10; pins3++) {
//                //System.out.printf("pins3：%d%n", pins3);
//                frame.setPins(10);
//                frame.getRoll(RollType.EXTRA).setRollScore(pins3);
//                //when
//                frame.updateScoreTypeByRollType(RollType.EXTRA);
//                frame.updatePins(pins3);
//                //then
//                assertEquals(10 + pins3, frame.getScore());
//                assertEquals(10 - pins3, frame.getPins());
//            }
//            frame.updatePins(10);
//        }
//    }
}