package practice_19082023.domain;

import practice_19082023.exception.InvalidCellsException;
import practice_19082023.generate.Populator;

import java.util.Arrays;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class Board implements Cloneable {
    private int rows;
    private int columns;

    private Cell[][] cells;

    public Board(Populator populator) {
        this(populator.populate());
    }

    public Board(Cell[][] cells) {
        initCells(cells);
        this.rows = this.cells.length;
        this.columns = this.cells[0].length;
    }

    private void initCells(Cell[][] cells) {
        if(cells == null) {
            throw new InvalidCellsException("Null passed to cells");
        }

        this.cells = cloneCells(cells);
    }

    private static Cell[][] cloneCells(Cell[][] cells) {
        Cell[][] newCells = new Cell[cells.length][cells[0].length];

        for (int i = 0; i < cells.length; i++) {
            System.arraycopy(cells[i], 0, newCells[i], 0, cells[0].length);
        }

        return newCells;
    }

    @Override
    public Board clone() {
        return new Board(cloneCells(cells));
    }

    public void setCells(Cell[][] cells) {
        initCells(cells);
    }

    public Cell[][] state() {
        return cloneCells(this.cells);
    }

    public void print() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                System.out.print(cells[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }

    public Integer getNumOfNeighbours(Integer rowIndex, Integer columnIndex) {
        Integer count = 0;
        for (Integer i = columnIndex - 1; i <= columnIndex + 1; i++) {
            for (Integer j = rowIndex - 1; j <= rowIndex + 1; j++) {
                count += isSafe(j, i) ? decideToCount(cells[j][i]) : 0;
            }
        }

        count -= decideToCount(cells[rowIndex][columnIndex]); // Subtract itself

        return count;
    }

    private boolean isSafe(int row, int col) {
        return (row >= 0 && row < rows) && (col >= 0 && col < columns);
    }

    private Integer decideToCount(Cell cell) {
        return cell.isAlive() ? 1 : 0;
    }

    @Override
    public String toString() {
        return Arrays.stream(cells)
                .map(row -> "[" + Arrays.stream(row)
                        .map(Object::toString)
                        .collect(joining(" ")) + "]"
                )
                .collect(joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return rows == board.rows && columns == board.columns && Arrays.equals(cells, board.cells);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.hashCode(cells);
        return result;
    }
}
