package blind75.arrayshashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //time  - O(n)
    //space - O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int difference = target - num;
            Integer index = numToIndex.get(difference);
            if (index != null) {
                return new int[] {index, i};
            } else {
                numToIndex.put(num, i);
            }
        }
        return new int[] {};
    }
}
