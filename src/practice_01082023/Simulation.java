package practice_01082023;

public class Simulation {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] boardCopy = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boardCopy[r][c] = board[r][c];

                int countAlive = 0;

                int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
                int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

                for (int i = 0; i < 8; i++) {
                    if(isSafe(rows, cols, r + dx[i], c + dy[i]) && boardCopy[r + dx[i]][c + dy[i]] == 1) {
                        countAlive++;
                    }
                }

                if(countAlive < 2 || countAlive > 3 && boardCopy[r][c] == 1) {
                    board[r][c] = 0;
                } else if(countAlive == 3 && boardCopy[r][c] == 0) {
                    board[r][c] = 1;
                }
            }
        }
    }

    private boolean isSafe(int rows, int cols, int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
