package tools.blocks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RockScissorsPaperTest {
    private final String PLAYER_ONE_WINS_WITH_ROCK = "PLAYER ONE SHAPE: ROCK, PLAYER TWO SHAPE: SCISSORS. ROCK beats SCISSORS. FIRST PLAYER WINS.\n";
    private final String PLAYER_ONE_LOOSE_WITH_ROCK = "PLAYER ONE SHAPE: ROCK, PLAYER TWO SHAPE: PAPER. PAPER beats ROCK. SECOND PLAYER WINS.\n";
    private final String PLAYER_ONE_WINS_WITH_SCISSORS = "PLAYER ONE SHAPE: SCISSORS, PLAYER TWO SHAPE: PAPER. SCISSORS beats PAPER. FIRST PLAYER WINS.\n";
    private final String PLAYER_ONE_LOOSE_WITH_SCISSORS = "PLAYER ONE SHAPE: SCISSORS, PLAYER TWO SHAPE: ROCK. ROCK beats SCISSORS. SECOND PLAYER WINS.\n";
    private final String PLAYER_ONE_WINS_WITH_PAPER= "PLAYER ONE SHAPE: PAPER, PLAYER TWO SHAPE: ROCK. PAPER beats ROCK. FIRST PLAYER WINS.\n";
    private final String PLAYER_ONE_LOOSE_WITH_PAPER = "PLAYER ONE SHAPE: PAPER, PLAYER TWO SHAPE: SCISSORS. SCISSORS beats PAPER. SECOND PLAYER WINS.\n";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldPrintAllResults() {

    }
}