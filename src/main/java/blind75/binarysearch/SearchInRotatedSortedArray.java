package blind75.binarysearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[] {5, 1, 3}, 5));
    }

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int from, int to, int target) {
        if (from > to) {
            return -1;
        }

        int mid = from + (to - from) / 2;
        int num = nums[mid];
        if (mid > 0 && num < nums[mid - 1]) { //break point
            if (target < num) {
                return -1;
            } else if (target > num) {
                int index = binarySearch(nums, from, mid - 1, target);
                return index < 0 ? binarySearch(nums, mid, to, target) : index;
            } else {
                return mid;
            }
        } else if (mid < nums.length - 1 && num > nums[mid + 1]) { //break point
            if (target > num) {
                return -1;
            } else if (target < num) {
                int index = binarySearch(nums, from, mid, target);
                return index < 0 ? binarySearch(nums, mid + 1, to, target) : index;
            } else {
                return mid;
            }
        } else { //normal condition
            if (num > nums[0]) { //the left is sorted, but right contains break point
                int index = binarySearch(nums, from, mid, target);
                return index < 0 ? search(nums, mid + 1, to, target) : index; //if not found in left, search in right
            } else { //the right is sorted, but right contains break point
                int index = binarySearch(nums, mid, to, target); //if not found in right, search in left
                return index < 0 ? search(nums, from, mid - 1, target) : index;
            }
        }
    }

    private int binarySearch(int[] nums, int from, int to, int target) {
        if (from > to) {
            return -1;
        }
        int mid = from + (to - from) / 2;
        int num = nums[mid];
        if (num == target) {
            return mid;
        } else if (target > num) {
            return binarySearch(nums, mid + 1, to, target);
        } else {
            return binarySearch(nums, from, mid - 1, target);
        }
    }
}
