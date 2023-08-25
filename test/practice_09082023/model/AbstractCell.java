package practice_09082023.model;

import FRSD_book.chapter2.good.Location;

import java.util.Objects;

public class AbstractCell implements Cell {

    public final int x;
    public final int y;

    private final Location location;

    public AbstractCell(int x, int y) {
        this.x = x;
        this.y = y;

        location = new Location(x, y);
    }

    @Override
    public boolean isAliveInNextGeneration(int liveNeighbours) {
        return false;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCell cell = (AbstractCell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
