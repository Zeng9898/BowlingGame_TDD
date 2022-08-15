package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {


    @Test
    void givenAFrame_whenCallGetRoll_thenShouldReturnTheRightRoll() {
        //given
        var frame = new Frame();
        //when
        Roll firstRoll = frame.getRoll(RollType.FIRST);
        Roll secondRoll = frame.getRoll(RollType.SECOND);
        //then
        assertEquals(RollType.FIRST, firstRoll.getRollType());  //原本是assertEquals(1, firstRoll.getRollType());
        assertEquals(RollType.SECOND, secondRoll.getRollType());
    }

//    @Test
//    void givenAFrame_whenCallGetRollWithWrongArgument_thenShouldThrowIllegalArgumentException() {
//        //given
//        var frame = new Frame();
//        //when then
//        assertThrows(IllegalArgumentException.class, () -> {
//            Roll firstRoll = frame.getRoll("whatever");
//        });
//    }

    @Test
    void givenAFrame_whenFinishARoll_thenFrameShouldUpdatePinsAndScore() {
        //givenAFrameAfterSecondRoll_whenCallUpdateFrameScoreAndUpdatePins_thenShouldDoTheRightUpdate
        //given
        var frame = new Frame();
        Roll roll = frame.getRoll(RollType.FIRST);
        int knockDownPins = roll.randomThrow(frame.getPins());
        //when
        frame.updatePins(knockDownPins);
        frame.updateFrameScore(knockDownPins);
//        frame.getRoll(RollType.FIRST).setRollScore(dummyNum);
//        frame.updatePins(dummyNum);
//        frame.updateFrameScore();

        //then
        assertEquals(knockDownPins, frame.getScore());
        assertEquals(Frame.MAX_PINS - knockDownPins, frame.getPins());
//            System.out.printf("第一投分數：%d 第二投分數：%d %n", pins1, pins2);;
//            System.out.printf("得分：%d %n", frame.getFrameScore());
//            System.out.printf("剩餘瓶數：%d %n", frame.getPins());
    }

    //與上面的測試同意
//    @Test
//    void givenAFrameAfterFirstRoll_whenCallUpdateFrameScoreAndUpdatePins_thenShouldDoTheRightUpdate() {
//        //given
//        var frame = new Frame();
//        for (int pins = 0; pins <= 10; pins++) {
//            frame.getRoll(RollType.FIRST).setRollScore(pins);
//            //when
//            frame.updatePins(pins);
//            frame.updateFrameScore();
//            //then
//            assertEquals(pins, frame.getFrameScore());
//            assertEquals(10 - pins, frame.getPins());
////            System.out.printf("分數：%d %n",pins);
////            System.out.printf("得分：%d %n",frame.getFrameScore());
////            System.out.printf("剩餘瓶數：%d %n",frame.getPins());
//            frame.setPins(10);
//        }
//    }

    @Test
    void givenAFrame_whenFirstRollKnockDownAllPins_thenTheFrameTypeShouldBeStrike() {
        //givenAFrameWithFirstRoll_whenRollKnockDownAllPins_thenTheFrameTypeShouldBeStrike()
        //given場景when發生事件then什麼結果
        //givenAFrameWith10ScoreInFirstRoll_whenCallUpdateScoreType_thenTheFrameTypeShouldbeStrike()
        //given
        Frame frame = new Frame();
        Roll roll = frame.getRoll(RollType.FIRST);
        roll.setRollScore(Frame.MAX_PINS);
        frame.updatePins(roll.getRollScore());
        frame.updateFrameScore(roll.getRollScore());
        //when
        frame.updateScoreTypeByRollType(roll.getRollType());
        //then
        assertEquals(ScoreType.STRIKE, frame.getScoreType());
    }

    @Test
    void givenAFrame_whenKnockDownAllPinsBySecondRoll_thenTheFrameTypeShouldBeSpare() {
        //givenAFrameWith10ScoreInTwoRolls_whenCallUpdateScoreType_thenTheScoreTypeShouldbeSpare()
        //given
        Frame frame = new Frame();
        Roll firstRoll = frame.getRoll(RollType.FIRST);
        Roll secondRoll = frame.getRoll(RollType.SECOND);
        Random rand = new Random();
        int firstKnockDownPins = firstRoll.randomThrow(9);
        frame.updatePins(firstKnockDownPins);
        frame.updateFrameScore(firstKnockDownPins);
        frame.updateScoreTypeByRollType(firstRoll.getRollType());

        //when
        int secondKnockDownPins = frame.getPins();
        System.out.println(secondKnockDownPins);
        frame.updatePins(secondKnockDownPins);
        frame.updateFrameScore(secondKnockDownPins);
        frame.updateScoreTypeByRollType(secondRoll.getRollType());
        //then
        assertEquals(ScoreType.SPARE, frame.getScoreType());
    }

    @Test
    void givenAFrame_whenKnockDownLessThanTenPinsBySecondRoll_thenTheFrameTypeShouldBeNormal() {
        //given
        Frame frame = new Frame();
        Roll firstRoll = frame.getRoll(RollType.FIRST);
        Roll secondRoll = frame.getRoll(RollType.SECOND);
        final int dummyNum = 3;
        firstRoll.setRollScore(dummyNum);
        frame.updatePins(dummyNum);
        frame.updateFrameScore(dummyNum);
        frame.updateScoreTypeByRollType(firstRoll.getRollType());
        //when
        secondRoll.setRollScore(dummyNum);
        frame.updatePins(dummyNum);
        frame.updateFrameScore(dummyNum);
        frame.updateScoreTypeByRollType(secondRoll.getRollType());
        //then
        assertEquals(ScoreType.NORMAL, frame.getScoreType());
    }
}