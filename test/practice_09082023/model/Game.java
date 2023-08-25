package practice_09082023.model;

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
