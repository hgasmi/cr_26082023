package com.gol;

public class ArraysTraining {

    public static void main(String[] args) {
        new ArraysTraining().run();
//        new ArraysTraining().example1();
    }
    
    public void run() {
        int width = 8;
        int height = 5;
        
        int[][] board = new int[width][height];

        board[3][2] = 1;
        board[5][3] = 1;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(board[x][y]);
            }

            System.out.println();
        }
    }

    public void example1() {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 } };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }
}
