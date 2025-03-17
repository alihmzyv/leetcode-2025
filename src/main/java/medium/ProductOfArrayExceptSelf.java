package medium;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4});
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] productOfLeft = new int[length];
        int[] productOfRight = new int[length];

        productOfLeft[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            productOfLeft[i] = productOfLeft[i - 1] * nums[i - 1];
        }

        productOfRight[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            productOfRight[i] = productOfRight[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            productOfLeft[i] = productOfLeft[i] * productOfRight[i];
        }

        return productOfLeft;
    }
}
