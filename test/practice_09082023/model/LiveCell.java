package practice_09082023.model;

public class LiveCell extends AbstractCell implements Cell {

    public LiveCell(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isAliveInNextGeneration(int liveNeighbours) {
        return !(liveNeighbours < 2) && !(liveNeighbours > 3);
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
