package practice_3_TDD.model;

import java.util.HashSet;
import java.util.Set;

public class Board {
    private Set<Cell> cells = new HashSet<>();

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public Set<Cell> getNeighbours(Cell cell) {
        Set<Cell> neighbours = new HashSet<>();
        Set<Cell> neighborhood = getNeighborhood(cell);

        for(Cell c: neighborhood) {
            if(isAlive(c)) {
                neighbours.add(c);
            }
        }

        neighbours.remove(cell);

        return neighbours;
    }

    private Set<Cell> getNeighborhood(Cell cell) {
        Set<Cell> neighborhood = new HashSet<>();

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                Cell c = new Cell(cell.x + dx, cell.y + dy);
                neighborhood.add(c);
            }
        }

        return neighborhood;
    }

    public boolean isAlive(Cell c) {
        return cells.contains(c);
    }

    public Board nextIteration() {
        Board board = new Board();

        for(Cell c: cells) {
            if(getNeighbours(c).size() == 2 || getNeighbours(c).size() == 3) {
                board.addCell(c);
            }
        }

        return board;
    }
}
