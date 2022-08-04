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
        assertEquals( "second", secondRoll.getWhichRoll());
    }
    @Test
    void givenAFrame_whenCallGetRollWithWrongArgument_thenShouldThrowException() {
        var frame = new Frame();

        assertThrows(IllegalArgumentException.class, () -> {
            Roll firstRoll = frame.getRoll("whatever");
        });
    }
}