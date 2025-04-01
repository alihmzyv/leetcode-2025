package blind75.trees;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BinaryTreeLevelOrderTraversalTest {

    @Test
    void levelOrderBFSTest1() {
        List<List<Integer>> result =
                new BinaryTreeLevelOrderTraversal().levelOrderBFS(Helper.build(3, 9, 20, null, null, 15, 7));
        assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)), result);
    }

    @Test
    void levelOrderBFSTest2() {
        List<List<Integer>> result =
                new BinaryTreeLevelOrderTraversal().levelOrderBFS(Helper.build(1, 2, null, 3, null, 4, null, 5));
        assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)), result);
    }
}