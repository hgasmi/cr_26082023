package practice_09082023;

import practice_09082023.model.*;

public class Simulation {

    public static void main(String[] args) {

        // TODO: make it work, it is not working now
        Board board = new Board(8, 5);

        board.addCell(2, 1);
        board.addCell(2, 2);
        board.addCell(2, 3);

        Game game = new Game(board);

        for (int i = 0; i < 10; i++) {
            Board nextBoard = game.nextIteration();
            nextBoard.print();
        }
    }
}
