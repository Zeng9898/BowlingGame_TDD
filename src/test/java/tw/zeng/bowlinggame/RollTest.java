package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollTest {

    @Test
    void givenAFirstRollWith10Pins_whenDoRandomThrow_thenRollScoreShouldBetween0and10() {
        //given
        var roll = new Roll("first");
        for (int i = 0; i < 1000; i++) {
            int pins = 10;
            //when
            roll.randomThrow(pins);
            int score = roll.getRollScore();
            //then
            assertTrue(score >= 0 && score <= pins);
        }
    }

    @Test
    void givenARollNotFirstSecondExtra_thenShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            var roll = new Roll("whatever");
        });
    }
}