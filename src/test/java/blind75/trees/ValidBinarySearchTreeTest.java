package blind75.trees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidBinarySearchTreeTest {

    @Test
    void isValidBST() {
        boolean result = new ValidBinarySearchTree().isValidBST(Helper.build(2, 1, 3));
        assertTrue(result);
    }

    @Test
    void isValidBSTTest2() {
        boolean result = new ValidBinarySearchTree().isValidBST(Helper.build(1, 1, null));
        assertFalse(result);
    }
}