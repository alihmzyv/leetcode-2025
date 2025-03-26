package blind75.twopointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> result = new ThreeSum().threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }

    //time - O(n^2)
    //space - O(1) or O(n) ~ sorting algorithm
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums); //sort so that we can skip if we checked that number (line 22)

        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int num = nums[i];
            if (num > 0) { //it is not possible to have 2 numbers greater than a positive number (they are positive too) whose sum will be negative (=-num)
                break;
            }
            if (i > 0 && num == nums[i - 1]) { //if already checked for that number
                continue;
            }

            int j = i + 1; //start at left end
            int k = length - 1; //start at right end
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { //skipping if already checked
                    j++;
                    continue;
                }
                if (k < length - 1 && nums[k] == nums[k + 1]) {//skipping if already checked
                    k--;
                    continue;
                }

                int numAtLeft = nums[j];
                int numAtRight = nums[k];
                int sum = num + numAtLeft + numAtRight;
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    result.add(List.of(num, numAtLeft, numAtRight));
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}
