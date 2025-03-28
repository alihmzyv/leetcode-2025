package blind75.binarysearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(new int[] {1}));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return binarySearchMin(nums, left, right);
    }

    private Integer binarySearchMin(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if ((mid == 0 && nums[0] <= nums[nums.length - 1])
                || (mid == nums.length - 1 && nums[nums.length - 1] > nums[0])
                || (mid > 0 && nums[mid] < nums[mid - 1])) {
            return nums[mid];
        } else {
            if (right > left) {
                Integer resultOfLeft = binarySearchMin(nums, left, mid - 1);
                if (resultOfLeft != null) {
                    return resultOfLeft;
                } else {
                    return binarySearchMin(nums, mid + 1, right);
                }
            } else {
                return null;
            }
        }
    }
}
