package medium;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(new FindPeakElement().findPeakElement(new int[] {2, 1}));
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (right > left) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (mid - 1 >= 0 && num < nums[mid - 1]) {
                right = mid;
            } else if (mid + 1 < nums.length && num < nums[mid + 1]) {
                left = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
