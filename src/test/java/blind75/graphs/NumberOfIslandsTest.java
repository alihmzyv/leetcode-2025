package blind75.graphs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberOfIslandsTest {

    @Test
    void numIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result = new NumberOfIslands().numIslands(grid);
        assertEquals(4, result);
    }
}