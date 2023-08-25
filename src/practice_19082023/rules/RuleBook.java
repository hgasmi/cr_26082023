package practice_19082023.rules;

import practice_19082023.domain.Cell;

public interface RuleBook {
    Cell lookup(Cell cell, int neighbourCount);
}
