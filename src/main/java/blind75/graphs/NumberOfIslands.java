package blind75.graphs;

public class NumberOfIslands {
    private static final char LAND = '1';
    private static final char WATER = '0';

    public int numIslands(char[][] grid) {
        int count = 0;
        int length = grid.length;
        int width = grid[0].length;
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == LAND) {
                    markAsWater(grid, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    private void markAsWater(char[][] grid, int row, int col) {
        if (!(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
                && grid[row][col] == LAND) {
            grid[row][col] = WATER;
            markAsWater(grid, row - 1, col);
            markAsWater(grid, row + 1, col);
            markAsWater(grid, row, col - 1);
            markAsWater(grid, row, col + 1);
        }
    }
}
