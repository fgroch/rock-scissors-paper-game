package tools.blocks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class RockScissorsPaperTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream systemOut = System.out;
    private final String PLAYER_ONE_WINS_WITH_ROCK = "PLAYER ONE SHAPE: ROCK, PLAYER TWO SHAPE: SCISSORS. ROCK beats SCISSORS. FIRST PLAYER WINS.\n";
    private final String PLAYER_ONE_LOOSE_WITH_ROCK = "PLAYER ONE SHAPE: ROCK, PLAYER TWO SHAPE: PAPER. PAPER beats ROCK. SECOND PLAYER WINS.\n";
    private final String PLAYER_ONE_WINS_WITH_SCISSORS = "PLAYER ONE SHAPE: SCISSORS, PLAYER TWO SHAPE: PAPER. SCISSORS beats PAPER. FIRST PLAYER WINS.\n";
    private final String PLAYER_ONE_LOOSE_WITH_SCISSORS = "PLAYER ONE SHAPE: SCISSORS, PLAYER TWO SHAPE: ROCK. ROCK beats SCISSORS. SECOND PLAYER WINS.\n";
    private final String PLAYER_ONE_WINS_WITH_PAPER= "PLAYER ONE SHAPE: PAPER, PLAYER TWO SHAPE: ROCK. PAPER beats ROCK. FIRST PLAYER WINS.\n";
    private final String PLAYER_ONE_LOOSE_WITH_PAPER = "PLAYER ONE SHAPE: PAPER, PLAYER TWO SHAPE: SCISSORS. SCISSORS beats PAPER. SECOND PLAYER WINS.\n";

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(out));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(systemOut);
    }

    @Test
    public void shouldPrintAllResults() {

    }

    @Test
    public void shouldPrintAllWinResult() {
        String consoleOut = "";
        RockScissorsPaper.Shape rockShape = RockScissorsPaper.Shape.ROCK;
        RockScissorsPaper.Shape scissorsShape = RockScissorsPaper.Shape.SCISSORS;
        RockScissorsPaper.Shape paperShape = RockScissorsPaper.Shape.PAPER;

        RockScissorsPaper.printResult(rockShape, scissorsShape);
        consoleOut += PLAYER_ONE_WINS_WITH_ROCK;
        assertEquals(consoleOut, out.toString());
        RockScissorsPaper.printResult(rockShape, paperShape);
        consoleOut += PLAYER_ONE_LOOSE_WITH_ROCK;
        assertEquals(consoleOut, out.toString());
        RockScissorsPaper.printResult(scissorsShape, paperShape);
        consoleOut += PLAYER_ONE_WINS_WITH_SCISSORS;
        assertEquals(consoleOut, out.toString());
        RockScissorsPaper.printResult(scissorsShape, rockShape);
        consoleOut += PLAYER_ONE_LOOSE_WITH_SCISSORS;
        assertEquals(consoleOut, out.toString());
        RockScissorsPaper.printResult(paperShape, rockShape);
        consoleOut += PLAYER_ONE_WINS_WITH_PAPER;
        assertEquals(consoleOut, out.toString());
        RockScissorsPaper.printResult(paperShape, scissorsShape);
        consoleOut += PLAYER_ONE_LOOSE_WITH_PAPER;
        assertEquals(consoleOut, out.toString());
    }

    @Test
    public void shouldCreateShapesFromOrdinal() {
        RockScissorsPaper.Shape shape = RockScissorsPaper.Shape.fromOrdinal(RockScissorsPaper.Shape.ROCK.ordinal());
        assertEquals(RockScissorsPaper.Shape.ROCK, shape);
        shape = RockScissorsPaper.Shape.fromOrdinal(RockScissorsPaper.Shape.SCISSORS.ordinal());
        assertEquals(RockScissorsPaper.Shape.SCISSORS, shape);
        shape = RockScissorsPaper.Shape.fromOrdinal(RockScissorsPaper.Shape.PAPER.ordinal());
        assertEquals(RockScissorsPaper.Shape.PAPER, shape);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhileWrongOrdinal() {
        RockScissorsPaper.Shape.fromOrdinal(4);
    }

    @Test
    public void shouldCheckWins() {
        RockScissorsPaper.Shape rockShape = RockScissorsPaper.Shape.ROCK;
        RockScissorsPaper.Shape scissorsShape = RockScissorsPaper.Shape.SCISSORS;
        RockScissorsPaper.Shape paperShape = RockScissorsPaper.Shape.PAPER;

        assertEquals(true, rockShape.isWin(scissorsShape));
        assertEquals(true, scissorsShape.isWin(paperShape));
        assertEquals(true, paperShape.isWin(rockShape));
        assertEquals(false, rockShape.isWin(rockShape));
        assertEquals(false, scissorsShape.isWin(scissorsShape));
        assertEquals(false, paperShape.isWin(paperShape));
        assertEquals(false, rockShape.isWin(paperShape));
        assertEquals(false, scissorsShape.isWin(rockShape));
        assertEquals(false, paperShape.isWin(scissorsShape));
    }
}