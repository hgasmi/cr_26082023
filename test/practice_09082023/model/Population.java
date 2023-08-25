package practice_09082023.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Population {
    private final Set<Cell> cells = new HashSet<>();
    public final int width;
    public final int height;

    public Population(int width, int height) {
        this.width = width;
        this.height = height;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells.add(new DeadCell(j, i));
            }
        }
    }

    public void setCellAlive(Cell cell) {
        Cell c = getCell(cell.getLocation().getX(), cell.getLocation().getY());
        cells.remove(c);

        cells.add(new LiveCell(cell.getLocation().getX(), cell.getLocation().getY()));
    }

    public void setCellDead(Cell cell) {
        cells.add(new DeadCell(cell.getLocation().getX(), cell.getLocation().getY()));
    }

    public Iterator cloneCells() {
        Set<Cell> clonedCells = new HashSet<>();

        for (Cell cell : cells) {
            clonedCells.add(cell);
        }

        return clonedCells.iterator();
    }

    public Cell getCell(int x, int y) {
        for(Cell c : cells) {
            if(c.getLocation().getX() == x && c.getLocation().getY() == y) {
                return c;
            }
        }
        
        return null;
    }

    public void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(getCell(j, i).isAlive()) {
                    System.out.print("+");
                } else {
                    System.out.print("-");
                }
            }

            System.out.println();
        }

        System.out.println();
    }
}
