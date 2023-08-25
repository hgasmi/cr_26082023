package hgasmi.practice_28072023;

public class Simulation {

    int rows, columns;
    int[][] board;

    public Simulation(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        board = new int[rows][columns];
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(board[i][j] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }

    public void nextGeneration() {
        int[][] newBoard = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {

                int neighboursAlive = countNeigboursAlive(row,col);

                if(getState(row,col) == 1) {
                    if(neighboursAlive < 2) {
                        newBoard[row][col] = 0;
                    } else if (neighboursAlive == 2 || neighboursAlive == 3) {
                        newBoard[row][col] = 1;
                    } else if (neighboursAlive > 3) {
                        newBoard[row][col] = 0;
                    }
                } else if (neighboursAlive == 3) {
                    newBoard[row][col] = 1;
                }
            }
        }

        this.board = newBoard;
    }

    private int countNeigboursAlive(int row, int col) {
        int count = 0;

        count += getState(row - 1, col - 1);
        count += getState(row, col - 1);
        count += getState(row + 1, col - 1);

        count += getState(row - 1, col);
        count += getState(row + 1, col);

        count += getState(row - 1, col + 1);
        count += getState(row, col + 1);
        count += getState(row + 1, col + 1);

        return count;
    }

    private int getState(int row, int col) {
        if(row < 0 || row >= rows) {
            return 0;
        }

        if(col < 0 || col >= columns) {
            return 0;
        }

        return board[row][col];
    }

    public void setCell(int rows, int columns, int value) {
        board[rows][columns] = value;
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation(5, 8);

        simulation.setCell(2, 3, 1);
        simulation.setCell(2, 4, 1);
        simulation.setCell(2, 5, 1);

        for (int i = 0; i < 10; i++) {
            simulation.printBoard();
            simulation.nextGeneration();
            System.out.println();
        }

    }
}
