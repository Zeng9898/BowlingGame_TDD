package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollTest {

    @Test
    void givenARoll_whenDoRandomThrow_thenRollScoreShouldBetween0andLeftPinsCount() {
        //given
        Frame frame = new Frame();
        var firstRoll = new Roll(RollType.SECOND);
        //when
        frame.setPins(5);
        firstRoll.randomThrow(frame.getPins());
        frame.setPins(10);
        firstRoll.randomThrow(frame.getPins());

        int firstScore = firstRoll.getRollScore();
        int secondScore = firstRoll.getRollScore();

        //then
        assertTrue(firstScore >= 0 && firstScore <= frame.getPins());
        assertTrue(secondScore >= 0 && secondScore <= frame.getPins());
    }
//
//    @Test
//    void givenNewRoll_whenArgumentIsNotFirstOrSecondOrExtra_thenShouldThrowIllegalArgumentException() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            var roll = new Roll("whatever");
//        });
//    }

}