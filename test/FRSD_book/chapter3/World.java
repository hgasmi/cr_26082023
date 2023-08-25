package FRSD_book.chapter3;


import java.util.HashSet;
import java.util.Set;

public class World {
    private Set<Cell> cells = new HashSet<>();

    public boolean isEmpty() {
        return cells.size() == 0;
    }

    public void setLivingAt(Location location) {
        cells.add(new Cell(location));
    }
}
