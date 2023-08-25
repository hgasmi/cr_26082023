package practice_09082023.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Board {
    private final Population population;

    public Board(int width, int height) {
        this.population = new Population(width, height);
    }

    public Set<Cell> getLiveNeighbours(Cell cell) {
        Set<Cell> neighbours = new HashSet<>();
        Set<Cell> neighborhood = getNeighborhood(cell);

        for(Cell c: neighborhood) {
            if(c instanceof LiveCell) {
                neighbours.add(c);
            }
        }

        neighbours.remove(cell);

        return neighbours;
    }

    private Set<Cell> getNeighborhood(Cell cell) {
        Set<Cell> neighborhood = new HashSet<>();

        // TODO: move loop to Population
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                Cell c = population.getCell(cell.getLocation().getX() + dx, cell.getLocation().getY() + dy);
                neighborhood.add(c);
            }
        }

        return neighborhood;
    }

    public Board nextIteration() {
        Board board = new Board(population.width, population.height);
        Population newPopulation = board.getPopulation();

        for (Iterator<Cell> it = this.population.cloneCells(); it.hasNext(); ) {
            Cell c = it.next();

            int liveNeighbours = getLiveNeighbours(c).size();

            if(c.isAliveInNextGeneration(liveNeighbours)) {
                newPopulation.setCellAlive(c);
            } else {
                newPopulation.setCellDead(c);
            }
        }

        return board;
    }

    public void print() {
        population.print();
    }

    public void addCell(int x, int y) {
        population.setCellAlive(new LiveCell(x, y));
    }

    public Population getPopulation() {
        return population;
    }
}
