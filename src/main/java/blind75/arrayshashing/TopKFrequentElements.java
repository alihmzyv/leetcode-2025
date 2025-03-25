package blind75.arrayshashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] result = new TopKFrequentElements().topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(result));
    }

    //time - O(n)
    //space - O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFrequency = new HashMap<>();
        for (int num : nums) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] frequencyToNumbers = new LinkedList[nums.length + 1];
        numToFrequency.forEach((num, frequency) -> {
            List<Integer> numbers = frequencyToNumbers[frequency];
            if (numbers == null) {
                List<Integer> newNums = new LinkedList<>();
                newNums.add(num);
                frequencyToNumbers[frequency] = newNums;
            } else {
                numbers.add(num);
            }
        });


        int[] result = new int[k];
        int index = 0;
        for (int i = frequencyToNumbers.length - 1; i >= 0; i--) {
            List<Integer> numbers = frequencyToNumbers[i];
            if (numbers != null) {
                for (int num : numbers) {
                    result[index++] = num;
                }
                if (index == k) {
                    break;
                }
            }
        }
        return result;
    }
}
