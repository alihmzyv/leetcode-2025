package blind75.arrayshashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    //time - O(m * n)
    //space - O(m * n)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> countArrToStrs = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            int length = str.length();
            for (int index = 0; index < length; index++) {
                count[str.charAt(index) - 'a']++;
            }
            String countArrAsStr = Arrays.toString(count);
            countArrToStrs.putIfAbsent(countArrAsStr, new LinkedList<>());
            countArrToStrs.get(countArrAsStr).add(str);
        }

        return new ArrayList<>(countArrToStrs.values());
    }
}
