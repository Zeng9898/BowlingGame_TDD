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
    void givenAFrame_whenCallGetRollWithWrongArgument_thenShouldThrowException() {
        var frame = new Frame();

        assertThrows(IllegalArgumentException.class, () -> {
            Roll firstRoll = frame.getRoll("whatever");
        });
    }

    @Test
    void givenAFrame_whenAfterSecondRollAndCallRefreshFrameScoreWithRefreshPins_thenShouldDoTheRightUpdate() {
        //given
        var frame = new Frame();
        int pins1 = frame.getRoll("first").randomThrow(frame.getPins());
        frame.refreshPins(pins1);
        frame.refreshFrameScore();
        int pins2 = frame.getRoll("second").randomThrow(frame.getPins());
        //when
        frame.refreshPins(pins2);
        frame.refreshFrameScore();
        //then
        assertEquals(pins1 + pins2, frame.getFrameScore());
        assertEquals(10 - (pins1 + pins2), frame.getPins());
    }

    @Test
    void givenAFrame_whenAfterFirstRollAndCallRefreshFrameScoreWithRefreshPins_thenShouldDoTheRightUpdate() {
        //given
        var frame = new Frame();
        int pins = frame.getRoll("first").randomThrow(frame.getPins());
        frame.refreshPins(pins);
        frame.refreshFrameScore();
        //then
        assertEquals(pins, frame.getFrameScore());
        assertEquals(10 - pins, frame.getPins());
    }

    @Test
    void givenAFrameWith10ScoreInFirstRoll_whenCallRefreshScoreType_thenTheFrameTypeShouldbeStrike() {
        Frame frame = new Frame();
        frame.getRoll("first").setRollScore(10);

        frame.refreshScoreType();

        assertEquals("strike", frame.getScoreType());
    }

    @Test
    void givenAFrameWith10ScoreInTwoRolls_whenCallRefreshScoreType_thenTheScoreTypeShouldbeSpare() {
        Frame frame = new Frame();
        frame.getRoll("first").setRollScore(6);
        frame.getRoll("second").setRollScore(4);
        frame.refreshFrameScore();

        frame.refreshScoreType();

        assertEquals("spare", frame.getScoreType());
    }

    @Test
    void givenAFrameWithLessThan10ScoreInTwoRolls_whenCallRefreshScoreType_thenTheScoreTypeShouldbeSpare() {
        Frame frame = new Frame();
        frame.getRoll("first").setRollScore(0);

        for (int k = 1; k <= 9; k++) {
            frame.getRoll("second").setRollScore(k);
            frame.refreshFrameScore();

            frame.refreshScoreType();

            assertEquals("normal", frame.getScoreType());
        }
    }

}