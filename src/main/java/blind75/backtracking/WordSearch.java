package blind75.backtracking;

import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WordSearch {
    static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Cell point)) {
                return false;
            }
            return row == point.row && col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    
    public boolean exist(char[][] board, String word) {
        int length = board.length;
        int width = board[0].length;
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                if (wordExists(new Cell(row, col), 0, board, word, new HashSet<>())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordExists(Cell cell, int index, char[][] board, String word, Set<Cell> visitedCells) {
        if (index >= word.length()) {
            return true;
        }

        if (word.charAt(index) == board[cell.row][cell.col]) {
            visitedCells.add(cell);
            List<Cell> neighbours = getNeighbours(cell, board.length, board[0].length);
            if (neighbours.isEmpty()) {
                return true;
            }
            for (Cell neighbour : neighbours) {
                if (!visitedCells.contains(neighbour) && wordExists(neighbour, index + 1, board, word, visitedCells)) {
                    return true;
                }
            }
            visitedCells.remove(cell);
            return false;
        }
        return false;
    }

    private List<Cell> getNeighbours(Cell cell, int length, int width) {
        List<Cell> neighbours = new LinkedList<>();
        if (cell.row - 1 >= 0) {
            neighbours.add(new Cell(cell.row - 1, cell.col));
        }
        if (cell.row + 1 < length) {
            neighbours.add(new Cell(cell.row + 1, cell.col));
        }
        if (cell.col - 1 >= 0) {
            neighbours.add(new Cell(cell.row, cell.col - 1));
        }
        if (cell.col + 1 < width) {
            neighbours.add(new Cell(cell.row, cell.col + 1));
        }
        return neighbours;
    }
}
