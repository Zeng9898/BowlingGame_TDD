package tw.zeng.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {
    @Test
    void givenNewBowlingGame_whenCallGameEndOrNot_shouldReturnFalseWhenGameIsProceeding() {
        //given
        var bowlingGame = new BowlingGame();
        bowlingGame.start(1, "first");
        //when
        boolean gameOver = bowlingGame.gameEndOrNot();
        //then
        assertEquals(false, gameOver);
    }
//    @Test
//    void givenNewBowlingGameWithLastRoll_whenCallGameEndOrNot_shouldReturnFalseWhenGameIsProceeding() {
//        //given
//        var bowlingGame = new BowlingGame();
//        bowlingGame.start(10, "second");
//        //when
//        boolean gameOver = bowlingGame.gameEndOrNot();
//        //then
//        assertEquals(false, gameOver);
//    }
}