package practice_19082023.generate;

import practice_19082023.domain.Cell;

import java.security.SecureRandom;
import java.util.Random;

import static practice_19082023.generate.CellFactory.alive;
import static practice_19082023.generate.CellFactory.dead;

public class RandomCellPopulator implements Populator {

    private int rows;
    private int columns;
    private SecureRandom secureRandom = new SecureRandom();

    public RandomCellPopulator(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

    }

    @Override
    public Cell[][] populate() {
        Cell[][] cells = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = secureRandom.nextBoolean() ? alive() : dead();
            }
        }

        return cells;
    }
}
