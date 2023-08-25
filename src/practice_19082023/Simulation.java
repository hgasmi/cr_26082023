package practice_19082023;

import practice_19082023.domain.Board;
import practice_19082023.domain.Game;
import practice_19082023.generate.RandomCellPopulator;
import practice_19082023.rules.GoLRuleBook;

public class Simulation {
    public static void main(String[] args) {
        Game game = new Game(new Board(new RandomCellPopulator(8, 5)), new GoLRuleBook());

        Board board = game.currentBoard();

        for (int i = 0; i < 7; i++) {
            game.nextGeneration();
            board = game.currentBoard();
            board.print();
        }
    }
}
