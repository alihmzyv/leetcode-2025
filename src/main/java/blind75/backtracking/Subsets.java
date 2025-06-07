package blind75.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3, 5, 6}));
    }

    /*
    time - O(n * 2 ^ n)
    space - O(n) extra space, O(2^n) for the output list
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subset = result.get(j);
                ArrayList<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                result.add(newSubset);
            }
        }

        return result;
    }
}
