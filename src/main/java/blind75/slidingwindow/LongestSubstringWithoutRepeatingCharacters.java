package blind75.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    }

    //time - O(n) - n = len of s
    //space - O(m) - m = unique chars in s
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<Character> charsSeen = new HashSet<>();
        int maxLength = 1;
        int length = s.length();
        int left = 0;
        int right = 1;
        charsSeen.add(s.charAt(0));
        while (right < length) {
            if (length - left <= maxLength) {
                break;
            }
            char charAtRight = s.charAt(right);
            boolean added = charsSeen.add(charAtRight);
            if (added) {
                right++;
            } else {
                int currentLength = right - left;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                charsSeen.remove(s.charAt(left));
                left++;
            }
        }
        return Math.max(right - left, maxLength);
    }
}
