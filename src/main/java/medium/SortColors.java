package medium;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 1, 2, 0, 2, 1, 1, 0, 0, 2, 0};
        new SortColors().sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
        int countOfZero = 0;
        int countOfOne = 0;

        for (int num : nums) {
            if (num == 0) {
                countOfZero++;
            } else if (num == 1) {
                countOfOne++;
            }
        }

        Arrays.fill(nums, 0, countOfZero, 0);
        Arrays.fill(nums, countOfZero, countOfZero + countOfOne, 1);
        Arrays.fill(nums, countOfZero + countOfOne, nums.length, 2);
    }
}
