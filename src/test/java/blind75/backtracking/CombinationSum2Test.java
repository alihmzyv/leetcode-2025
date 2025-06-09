package blind75.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CombinationSum2Test {

    @Test
    void test1() {
        List<List<Integer>> result = new CombinationSum2().combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);

        assertEquals(List.of(List.of(1, 1, 6),
                List.of(1, 2, 5),
                List.of(1, 7),
                List.of(2, 6)), result);
    }
}