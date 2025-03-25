package blind75.arrayshashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    //time - O(n + m)
    //space - O(1) (26)
    public boolean isAnagramV1(String s, String t) {
        Map<Character, Integer> charToOccurrence = new HashMap<>();

        for (char ch : s.toCharArray()) {
            charToOccurrence.put(ch, charToOccurrence.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            charToOccurrence.put(ch, charToOccurrence.getOrDefault(ch, 0) - 1);
        }

        for (int val : charToOccurrence.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    //time - O(n + m)
    //space - O(1) (26)
    public boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    //time - O(nlogn + mlogm)
    //space - based on sorting
    public boolean isAnagramV3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }
}
