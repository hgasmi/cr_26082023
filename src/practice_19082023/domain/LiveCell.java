package practice_19082023.domain;

public class LiveCell implements Cell {

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public String toString() {
        return "+";
    }
}
