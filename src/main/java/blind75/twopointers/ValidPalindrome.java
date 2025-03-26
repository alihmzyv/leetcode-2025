package blind75.twopointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));;
    }

    //time - O(n)
    //space - O(1)
    public boolean isPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right;) {
            char chAtLeft = s.charAt(left);
            char chAtRight = s.charAt(right);
            if (!isAlphanumeric(chAtLeft)) {
                left++;
                continue;
            }
            if (!isAlphanumeric(chAtRight)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(chAtLeft) != Character.toLowerCase(chAtRight)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphanumeric(char ch) {
        return (ch >= 'A' && ch <= 'Z')
                || (ch >= 'a' && ch <= 'z')
                || (ch >= '0' && ch <= '9');
    }
}
