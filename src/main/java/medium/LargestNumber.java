package medium;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    private static final Comparator<String> BUILDING_LARGER_NUM_COMPARATOR =
            (num1, num2) -> {
                String version1 = num1 + num2;
                String version2 = num2 + num1;

                return -version1.compareTo(version2);
            };

    private static final String ZERO_STR = "0";

    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsStr, BUILDING_LARGER_NUM_COMPARATOR);

        if (numsStr[0].equals(ZERO_STR)) {
            return ZERO_STR;
        }

        StringBuilder sb = new StringBuilder();
        for (String num : numsStr) {
            sb.append(num);
        }
        return sb.toString();
    }
}
