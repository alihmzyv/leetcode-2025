package blind75.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class PermutationsTest {

    @Test
    void permute() {
        List<List<Integer>> result = new Permutations().permute(new int[] {1, 2, 3});

        List<List<Integer>> expectedResult = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );
        assertTrue(expectedResult.size() == result.size() && result.containsAll(expectedResult) &&
                expectedResult.containsAll(result));
    }
}