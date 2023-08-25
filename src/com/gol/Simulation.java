package com.gol;

public class Simulation {

    int height;
    int width;
    int[][] board;

    public Simulation(int width, int height) {
        this.height = height;
        this.width = width;

        board = new int[width][height];
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation(8, 5);

        simulation.setAlive(2, 2);
        simulation.setAlive(3, 2);
        simulation.setAlive(4, 2);

        for (int i = 0; i < 10; i++) {
            simulation.printBoard();
            simulation.step();
        }
    }

    public void printBoard() {
        for (int y = 0; y < height; y++) { // rows
            String line = "|";
            for (int x = 0; x < width; x++) { // columns
                if (board[x][y] == 0) {
                    line += ".";
                } else {
                    line += "*";
                }
            }

            line += "|";
            System.out.println(line);
        }

        System.out.println("\n");
    }

    public void setAlive(int x, int y) {
        board[x][y] = 1;
    }

    public void setDead(int x, int y) {
        board[x][y] = 0;
    }

    public int countAliveNeighbours(int x, int y) {
        int count = 0;

        count += getState(x - 1,y - 1);
        count += getState(x,y - 1);
        count += getState(x + 1,y - 1);

        count += getState(x - 1,y);
        count += getState(x + 1,y);

        count += getState(x - 1,y + 1);
        count += getState(x,y + 1);
        count += getState(x + 1,y + 1);

        return count;
    }

    public void step() {
        int[][] newBoard = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int aliveNeighbours = this.countAliveNeighbours(x, y);

                if(getState(x, y) == 1) {
                    if(aliveNeighbours < 2) {
                        newBoard[x][y] = 0;
                    } else if(aliveNeighbours == 2 || aliveNeighbours == 3) {
                        newBoard[x][y] = 1;
                    } else if(aliveNeighbours > 3) {
                        newBoard[x][y] = 0;
                    }
                } else {
                    if(aliveNeighbours == 3) {
                        newBoard[x][y] = 1;
                    }
                }
            }
        }

        this.board = newBoard;
    }

    public int getState(int x, int y) {
        if(x < 0 || x >= width) {
            return 0;
        }

        if(y < 0 || y >= height) {
            return 0;
        }

        return this.board[x][y];
    }
}
