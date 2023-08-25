package practice_19082023.domain;

import practice_19082023.rules.RuleBook;

public class Game {

    private RuleBook ruleBook;
    private Board board;

    public Game(Board board, RuleBook ruleBook) {
        this.board = board;
        this.ruleBook = ruleBook;
    }

    public Game nextGeneration() {
        return next();
    }

    private Game next() {
        Cell[][] state = board.state();
        int rows = state.length;
        int columns = state[0].length;

        Cell[][] nextGen = new Cell[rows][columns];

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                int neighbourCount = board.getNumOfNeighbours(j, i);
                Cell currentCell = state[j][i];
                Cell nextCell = ruleBook.lookup(currentCell, neighbourCount);
                nextGen[j][i] = nextCell;
            }
        }

        board.setCells(nextGen);

        return this;
    }

    public Board currentBoard() {
        return board.clone();
    }
}
