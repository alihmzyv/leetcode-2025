package blind75.backtracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    //time - O(2(target / min(candidates)))
    //space - O(target / min(candidates)) (stack)
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(0, nums, new LinkedList<>(), 0, result, target);
        return result;
    }

    private void dfs(int index, int[] nums, LinkedList<Integer> curr, int sum, List<List<Integer>> result, int target) {
        if (sum == target) {
            result.add(new LinkedList<>(curr));
            return;
        }

        if (index >= nums.length || sum > target) {
            return;
        }

        int num = nums[index];
        curr.add(num);
        dfs(index, nums, curr, sum + num, result, target);
        curr.removeLast();
        dfs(index + 1, nums, curr, sum, result, target);
    }
}
