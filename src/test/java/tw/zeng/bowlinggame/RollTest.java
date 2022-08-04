package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RollTest {

    @Test
    void givenAFirstRollWith10Pins_whenDoRandomThrow_thenRollScoreShouldBetween1and10(){
        //given
        var roll = new Roll("first");
        int pins = 10;
        //when
        roll.randomThrow(pins + 1);
        int score = roll.getRollScore();
        //then
        assertTrue(score >= 0 && score <= pins);
    }
    @Test
    void givenARollNotFirstSecondExtra_thenShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            var roll = new Roll("whatever");
        });
    }
}