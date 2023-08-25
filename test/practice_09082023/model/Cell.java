package practice_09082023.model;

import FRSD_book.chapter2.good.Location;

public interface Cell extends Cloneable {
    boolean isAliveInNextGeneration(int liveNeighbours);
    Location getLocation();
    boolean isAlive();
}
