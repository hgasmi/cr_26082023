package FRSD_book.chapter1;

import java.util.HashSet;
import java.util.Set;

public class World {
    Set<Cell> cells = new HashSet<>();

    public void setLivingAt(int row, int col) {
        cells.add(new Cell(row, col));
    }

    public boolean isEmpty() {
        return cells.size() == 0;
    }

    public boolean aliveAt(int row, int col) {
        return cells.contains(new Cell(row, col));
    }
}
