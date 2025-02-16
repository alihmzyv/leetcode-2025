package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLengthOfConsecutiveSeq = 0;
        for (int num : nums) {
            if (set.contains(num) && !set.contains(num - 1)) {
                int lengthOfSeq = 1;
                int nextNumInSeq = num + 1;
                while (set.contains(nextNumInSeq)) {
                    lengthOfSeq++;
                    set.remove(nextNumInSeq);
                    nextNumInSeq++;
                }
                if (lengthOfSeq > maxLengthOfConsecutiveSeq) {
                    maxLengthOfConsecutiveSeq = lengthOfSeq;
                }
            }
        }
        return maxLengthOfConsecutiveSeq;
    }
}
