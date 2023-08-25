package practice_07082023;

public class Simulation {

    int rows, columns;
    int[][] board;

    int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public Simulation(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new int[rows][columns];
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                printCell(i, j);
            }
            System.out.println();
        }
    }

    private void printCell(int i, int j) {
        if(board[i][j] == 0) {
            System.out.print("-");
        } else {
            System.out.print("+");
        }
    }

    public void step() {
        int[][] newBoard = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                updateCell(newBoard, row, col, countNeigboursAlive(row, col));
            }
        }

        this.board = newBoard;
    }

    private void updateCell(int[][] newBoard, int row, int col, int neigboursAlive) {
        if(getState(row, col) == 1) {
            updateLiveCell(newBoard, row, col, neigboursAlive);
        } else if (getState(row, col) == 0) {
            updateDeadCell(newBoard, row, col, neigboursAlive);
        }
    }

    public void updateLiveCell(int[][] newBoard, int row, int col, int neighboursAlive) {
        if(neighboursAlive < 2 || neighboursAlive > 3) {
            newBoard[row][col] = 0;
        } else {
            newBoard[row][col] = board[row][col];
        }
    }

    public void updateDeadCell(int[][] newBoard, int row, int col, int neighboursAlive) {
        if(neighboursAlive == 3) {
            newBoard[row][col] = 1;
        } else {
            newBoard[row][col] = board[row][col];
        }
    }

    public void setAlive(int x, int y) {
        board[x][y] = 1;
    }

    private int countNeigboursAlive(int row, int col) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
                count += getState(row + dx[i], col + dy[i]);
        }

        return count;
    }

    private int getState(int row, int col) {
        if(row < 0 || row >= rows || col < 0 || col >= columns) {
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
            simulation.step();
            System.out.println();
        }

    }
}
