package blind75.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    //time - 2^n
    //space - O(n + 2^n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, new LinkedList<>(), 0, target, result);
        return result;
    }

    private void dfs(int[] candidates, int index, LinkedList<Integer> curr, int sum, int target, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (index >= candidates.length || sum > target) {
            return;
        }

        int num = candidates[index];
        curr.add(num);
        dfs(candidates, index + 1, curr, sum + num, target, result);
        curr.removeLast();
        while (index + 1 < candidates.length && candidates[index + 1] == num) {
            index++;
        }
        dfs(candidates, index + 1, curr, sum, target, result);
    }
}
