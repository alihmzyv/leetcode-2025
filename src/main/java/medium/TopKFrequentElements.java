package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] result = topKFrequentElements.topKFrequent(new int[] {5, 2, 5, 3, 5, 3, 1, 1, 3}, 2);
        System.out.println(Arrays.toString(result));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for (int num : nums) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        System.out.println("NumToFReq " + numToFrequency);

        List[] frequencyToNums = new List[nums.length + 1];
        numToFrequency.forEach((num, frequency) -> {
            List<Integer> numsByFrequency = frequencyToNums[frequency];
            System.out.println("NumsByFreq" + numsByFrequency);
            if (numsByFrequency == null) {
                numsByFrequency = new LinkedList<>();
                numsByFrequency.add(num);
                frequencyToNums[frequency] = numsByFrequency;
            } else {
                numsByFrequency.add(num);
            }
            System.out.println(frequencyToNums);
        });

        List<Integer> topKFrequentNums = new LinkedList<>();
        int index = frequencyToNums.length - 1;
        while (k > 0) {
            List<Integer> numsAtIndex = frequencyToNums[index];
            if (numsAtIndex != null) {
                for (int num : numsAtIndex) {
                    if (k == 0) {
                        break;
                    }
                    topKFrequentNums.add(num);
                    k--;
                }
            }
            index--;
        }
        return topKFrequentNums.stream()
                .mapToInt(num -> num)
                .toArray();
    }
}
