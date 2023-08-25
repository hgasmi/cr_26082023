package practice_3_TDD.model;

public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public Board nextIteration() {
        Board nextBoard = board.nextIteration();
        return nextBoard;
    }
}
