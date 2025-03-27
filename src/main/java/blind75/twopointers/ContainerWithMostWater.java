package blind75.twopointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int length = height.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int h1 = height[left];
            int h2 = height[right];
            int area = Math.min(h1, h2) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            if (h1 > h2) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
