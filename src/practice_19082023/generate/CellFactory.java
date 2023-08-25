package practice_19082023.generate;

import practice_19082023.domain.Cell;
import practice_19082023.domain.DeadCell;
import practice_19082023.domain.LiveCell;

public class CellFactory {

    private static Cell ALIVE = new LiveCell();
    private static Cell DEAD = new DeadCell();

    public static Cell alive() {
        return ALIVE;
    }

    public static Cell dead() {
        return DEAD;
    }

    public static Cell cellFromString(final String strRep) {
        return "A".equals(strRep.trim()) ? alive() : dead();
    }
}
