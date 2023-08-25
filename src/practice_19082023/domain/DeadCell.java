package practice_19082023.domain;

public class DeadCell implements Cell {

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public String toString() {
        return "-";
    }
}
