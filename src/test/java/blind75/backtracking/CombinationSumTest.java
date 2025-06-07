package blind75.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CombinationSumTest {
    @Test
    void test1() {
        List<List<Integer>> result = new CombinationSum().combinationSum(new int[] {2, 5, 6, 9}, 9);

        assertEquals(List.of(List.of(2, 2, 5), List.of(9)), result);
    }
}