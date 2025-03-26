package blind75.arrayshashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    }

    //time - O(n)
    //space - O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        int maxLength = 0;
        for (int num : numsSet) {
            int currentLength = 1;
            if (!numsSet.contains(num - 1)) {
                while (numsSet.contains(num + currentLength)) {
                    currentLength++;
                }
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }
        return maxLength;
    }
}
