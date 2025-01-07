package easy;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int shiftCount = k % length;
        int[] numsCopy = new int[length];
        System.arraycopy(nums, 0, numsCopy, 0, length);
        for (int index = 0, originalIndex = length - shiftCount; index < shiftCount; index++, originalIndex++) {
            nums[index] = numsCopy[originalIndex];
        }
        for (int index = shiftCount, originalIndex = 0, count = shiftCount; count > 0; count--, originalIndex++, index++) {
            nums[index] = numsCopy[originalIndex];
        }
        for (int index = 2 * shiftCount, originalIndex = shiftCount; index < nums.length; index++, originalIndex++) {
            nums[index] = numsCopy[originalIndex];
        }
    }
}
