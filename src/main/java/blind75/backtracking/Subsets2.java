package blind75.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        getSubsets(nums, result, 0, new LinkedList<>());
        return result;
    }

    private void getSubsets(int[] nums, List<List<Integer>> result, int index, LinkedList<Integer> curr) {
        System.out.println(curr);
        if (index >= nums.length) {
            result.add(new LinkedList<>(curr));
        } else {
            curr.add(nums[index]);
            getSubsets(nums, result, index + 1, curr);
            curr.removeLast();
            while (index + 1 < nums.length && nums[index + 1] == nums[index]) {
                index++;
            }
            getSubsets(nums, result, index + 1, curr);
        }
    }
}
