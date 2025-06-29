package blind75.backtracking;

import java.util.LinkedList;
import java.util.List;

public class WordSearch {
    //O(m*n*3^(l-1))
    //space - O(n) for stack and m*n for extra space (bool array used) or l (hashmap used)
    public boolean exist(char[][] board, String word) {
        int length = board.length;
        int width = board[0].length;
        boolean[][] visitedCells = new boolean[length][width];
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                if (wordExists(row, col, 0, board, word, visitedCells, length, width)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordExists(int row, int col, int index, char[][] board, String word, boolean[][] visitedCells,
                               int length, int width) {
        if (word.charAt(index) == board[row][col]) {
            if (index == word.length() - 1) {
                return true;
            }
            visitedCells[row][col] = true;
            List<int[]> neighbours = getNeighbours(row, col, length, width);
            for (int[] neighbour : neighbours) {
                if (!visitedCells[neighbour[0]][neighbour[1]] &&
                        wordExists(neighbour[0], neighbour[1], index + 1, board, word, visitedCells,
                                length, width)) {
                    return true;
                }
            }
            visitedCells[row][col] = false;
            return false;
        }
        return false;
    }

    private List<int[]> getNeighbours(int row, int col, int length, int width) {
        List<int[]> neighbours = new LinkedList<>();
        if (row - 1 >= 0) {
            neighbours.add(new int[] {row - 1, col});
        }
        if (row + 1 < length) {
            neighbours.add(new int[] {row + 1, col});
        }
        if (col - 1 >= 0) {
            neighbours.add(new int[] {row, col - 1});
        }
        if (col + 1 < width) {
            neighbours.add(new int[] {row, col + 1});
        }
        return neighbours;
    }
}
