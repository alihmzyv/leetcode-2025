package blind75.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordSearchTest {

    @Test
    void test1() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        assertTrue(new WordSearch().exist(board, "ABCCED"));
    }

    @Test
    void test2() {
        char[][] board = {
                {'a'}
        };
        assertTrue(new WordSearch().exist(board, "a"));
    }

    @Test
    void test3() {
        char[][] board = {
                {'a'}
        };
        assertFalse(new WordSearch().exist(board, "ab"));
    }

    @Test
    void test4() {
        char[][] board = {
                {'a', 'a'}
        };
        assertTrue(new WordSearch().exist(board, "aa"));
    }
}