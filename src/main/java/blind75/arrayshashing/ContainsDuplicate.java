package blind75.arrayshashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    //time - O(n)
    //space - O(n)
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
