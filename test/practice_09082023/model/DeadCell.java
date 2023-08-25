package practice_09082023.model;

public class DeadCell extends AbstractCell implements Cell {

    public DeadCell(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isAliveInNextGeneration(int liveNeighbours) {
        return liveNeighbours == 3;
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
