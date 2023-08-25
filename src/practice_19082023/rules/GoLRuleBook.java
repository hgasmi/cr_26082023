package practice_19082023.rules;

import practice_19082023.domain.Cell;

import java.util.HashMap;
import java.util.Map;

import static practice_19082023.generate.CellFactory.alive;
import static practice_19082023.generate.CellFactory.dead;

public class GoLRuleBook implements RuleBook {

    private static final Map<Cell, Map<Integer, Cell>> RULES = new HashMap<>();

    static {
        Map<Integer, Cell> liveCellsRules = new HashMap<>();
        liveCellsRules.put(0, dead());
        liveCellsRules.put(1, dead());
        liveCellsRules.put(2, alive());
        liveCellsRules.put(3, alive());
        liveCellsRules.put(4, dead());
        liveCellsRules.put(5, dead());
        liveCellsRules.put(6, dead());
        liveCellsRules.put(7, dead());
        liveCellsRules.put(8, dead());

        Map<Integer, Cell> deadCellsRules = new HashMap<>();
        deadCellsRules.put(0, dead());
        deadCellsRules.put(1, dead());
        deadCellsRules.put(2, dead());
        deadCellsRules.put(3, alive());
        deadCellsRules.put(4, dead());
        deadCellsRules.put(5, dead());
        deadCellsRules.put(6, dead());
        deadCellsRules.put(7, dead());
        deadCellsRules.put(8, dead());

        RULES.put(alive(), liveCellsRules);
        RULES.put(dead(), deadCellsRules);
    }

    @Override
    public Cell lookup(Cell cell, int neighbourCount) {
        return RULES.get(cell).get(neighbourCount);
    }
}
