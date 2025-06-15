package blind75.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permuteRecursively(nums, 0, result, new ArrayList<>());
        return result;
    }

    //time - O(n! * n^2)
    private void permuteRecursively(int[] nums,
                                    int index,
                                    List<List<Integer>> result,
                                    ArrayList<Integer> curr) {
        int size = curr.size();
        if (size == nums.length) {
            result.add(curr);
        } else {
            for (int i = 0; i <= size; i++) {
                ArrayList<Integer> currCopy = new ArrayList<>(curr);
                currCopy.add(i, nums[index]);
                permuteRecursively(nums, index + 1, result, currCopy);
            }
        }
    }
}
