package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(new int[]{1, 2, 3});
        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        return permuteIteratively(Arrays.stream(nums).boxed().toList());
    }

    public List<List<Integer>> permuteIteratively(List<Integer> nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(nums.get(0)));
        int size = 1;
        int nextToMultiply = 2;

        for (int index = 1; index < nums.size(); index++) {
            for (int i = 0; i < size; i++) {
                List<Integer> permutation = queue.poll();
                for (int j = 0; j <= permutation.size(); j++) {
                    ArrayList<Integer> permutationCopy = new ArrayList<>(permutation);
                    permutationCopy.add(j, nums.get(index));
                    queue.add(permutationCopy);
                }
            }
            size *= nextToMultiply;
            nextToMultiply += 1;
        }
        return queue.stream().toList();
    }

    private List<List<Integer>> permuteRecursively(List<Integer> nums) {
        if (nums.isEmpty()) {
            return List.of(nums);
        }

        List<List<Integer>> newResult = new ArrayList<>();
        List<List<Integer>> result = permuteRecursively(nums.subList(1, nums.size()));
        Integer valToInsert = nums.get(0);
        for (List<Integer> permutation : result) {
            for (int i = 0; i < permutation.size() + 1; i++) {
                ArrayList<Integer> newPermutation = new ArrayList<>(permutation);
                newPermutation.add(i, valToInsert);
                newResult.add(newPermutation);
            }
        }
        return newResult;
    }
}
