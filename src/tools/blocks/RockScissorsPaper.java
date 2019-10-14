package tools.blocks;

import java.util.Random;

/**
 * @author fgroch@gmail.com
 */
public class RockScissorsPaper {
    private static String SHAPES_TEMPLATE = "PLAYER ONE SHAPE: %s, PLAYER TWO SHAPE: %s. ";
    private static String WIN_TEMPLATE = "%s beats %s. %s PLAYER WINS.";
    private static String DEUCE_TEMPLATE = "Deuce.";

    public static void main(String[] args) {
        Shape firstPlayerShape = Shape.ROCK;
        Random generator = new Random();
        for (int i = 0; i < 100; i++) {
            int ordinal = generator.nextInt(3);
            Shape secondPlayerShape = Shape.fromOrdinal(ordinal);
            printResult(firstPlayerShape, secondPlayerShape);
        }
    }

    /**
     * Enum that holds Shape and enable check wins over opponents shape. Could be created from [0-2] int range
     */
    enum Shape {
        ROCK,
        SCISSORS,
        PAPER;

        /**
         * Allows to create Shape from [0-2] int range
         * @param ordinal 0 - ROCK, 1 - SCISSORS, 2 - PAPER
         * @return Shape corresponding to the order
         */
        static Shape fromOrdinal(int ordinal) {
            if (ordinal ==  ROCK.ordinal()) {
                return ROCK;
            } else if (ordinal == SCISSORS.ordinal()) {
                return SCISSORS;
            } else if (ordinal == PAPER.ordinal()) {
                return PAPER;
            } else {
                throw new IllegalArgumentException();
            }
        }

        /**
         * Checks if the shape wins with opponent shape
         * @param opponentShape Opponent shape to check against
         * @return true if wins, false otherwise
         */
        boolean isWin(Shape opponentShape) {
            if (this == opponentShape) {
                return false;
            } else if (this == ROCK && opponentShape == SCISSORS) {
                return true;
            } else if (this == SCISSORS && opponentShape == PAPER) {
                return true;
            } else if (this == PAPER && opponentShape == ROCK) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Prints results of comparsion
     * @param firstShape first player shape
     * @param secondShape second player shape
     */
    static void printResult(Shape firstShape, Shape secondShape) {
        System.out.print(String.format(SHAPES_TEMPLATE, firstShape, secondShape));
        if (firstShape == secondShape) {
            System.out.println(DEUCE_TEMPLATE);
        } else if (firstShape.isWin(secondShape)) {
            System.out.println(String.format(WIN_TEMPLATE, firstShape, secondShape, "FIRST"));
        } else {
            System.out.println(String.format(WIN_TEMPLATE, secondShape, firstShape, "SECOND"));
        }
    }
}
