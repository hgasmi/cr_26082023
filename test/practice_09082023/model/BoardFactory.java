package practice_09082023.model;

public class BoardFactory {
    public static Board createBlockBoard(int width, int height) {
        Board board = new Board(width, height);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board.addCell(i, j);
            }
        }

        return board;
    }
}
