package practice_3_TDD;

import org.junit.Test;
import practice_3_TDD.model.Board;
import practice_3_TDD.model.Cell;
import practice_3_TDD.model.Game;

import java.util.Set;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void aSingleCellShouldHaveZeroNeighbours() {
        Board board = new Board();
        board.addCell(new Cell(0, 0));

        Set<Cell> neighbours = board.getNeighbours(new Cell(0, 0));

        assertEquals(0, neighbours.size());

    }

    @Test
    public void cellsNextToEachOtherShouldBeNeighbours() {
        Board board = new Board();

        Cell first = new Cell(0, 0);
        Cell second = new Cell(0, 1);

        board.addCell(first);
        board.addCell(second);

        Set<Cell> neighbourOfFirstCell = board.getNeighbours(first);
        Set<Cell> neighbourOfSecondCell = board.getNeighbours(second);

        assertArrayEquals(new Cell[] {second}, neighbourOfFirstCell.toArray());
        assertArrayEquals(new Cell[] { first}, neighbourOfSecondCell.toArray());
    }

    @Test
    public void twoCellsFarFromEachOtherShouldHaveZeroNeighbours() {
        Board board = new Board();
        board.addCell(new Cell(0, 0));
        board.addCell(new Cell(0, 100));

        Set<Cell> neighbours = board.getNeighbours(new Cell(0, 0));

        assertEquals(0, neighbours.size());
    }

    @Test
    public void aSingleCellShouldDieInTheNextIteration() {
        Board board = new Board();
        board.addCell(new Cell(0, 0));

        Game game = new Game(board);

        Board nextBoard = game.nextIteration();

        assertFalse(nextBoard.isAlive(new Cell(0, 0)));
    }

    @Test
    public void cellWithTwoNeighboursShouldLiveInNextIteration() {
        // given
        Board board = new Board();
        board.addCell(new Cell(0, 1));
        board.addCell(new Cell(1, 1));
        board.addCell(new Cell(1, 0));
        Game game = new Game(board);

        // when
        Board nextBoard = game.nextIteration();

        // then
        assertTrue(nextBoard.isAlive(new Cell(1, 1)));

    }

    @Test
    public void cellWithThreeNeighboursShouldLiveInNextIteration() {
        // given
        Board board = new Board();

        board.addCell(new Cell(0, 1));
        board.addCell(new Cell(1, 1));
        board.addCell(new Cell(1, 0));
        board.addCell(new Cell(0, 0));
        Game game = new Game(board);

        // when
        Board nextBoard = game.nextIteration();

        // then
        assertTrue(nextBoard.isAlive(new Cell(1, 1)));

    }

    @Test
    public void middleCellsOf3x3ShouldHaveEightNeighbours() {
        Board board = createBlockBoard(3, 3);

        Set<Cell> neighbours = board.getNeighbours(new Cell(1, 1));

        assertEquals(8, neighbours.size());
    }


    private Board createBlockBoard(int w, int h) {
        Board board = new Board();

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                board.addCell(new Cell(i, j));
            }
        }

        return board;
    }


}
