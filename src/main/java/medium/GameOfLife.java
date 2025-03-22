package medium;

import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        new GameOfLife().gameOfLife(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int val = board[row][col];
                int countLiveNeighbours = countLiveNeighbours(board, row, col);
                if (val == 0) {
                    if (countLiveNeighbours == 3) {
                        board[row][col] = 2;
                    }
                } else {
                    if (countLiveNeighbours < 2 || countLiveNeighbours > 3) {
                        board[row][col] = 3;
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int val = board[row][col];
                if (val == 2) {
                    board[row][col] = 1;
                }
                if (val == 3) {
                    board[row][col] = 0;
                }
            }
        }
    }

    private int countLiveNeighbours(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        int countLiveNeighbours = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (!((i == row && j == col) || i < 0 || j < 0 || i == rows || j == cols)) {
                    int val = board[i][j];
                    if (val == 1 || val == 3) {
                        countLiveNeighbours++;
                    }
                }
            }
        }
        return countLiveNeighbours;
    }
}
