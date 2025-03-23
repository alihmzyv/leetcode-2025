package medium;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }

    public String countAndSay(int n) {
        StringBuilder number = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            number = encode(number);
        }
        return number.toString();
    }

    private StringBuilder encode(StringBuilder str) {
        StringBuilder result = new StringBuilder();
        char currentChar = str.charAt(0);
        int currentCount = 1;
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != currentChar) {
                result.append(currentCount);
                result.append(currentChar);
                currentChar = ch;
                currentCount = 1;
            } else {
                currentCount++;
            }
        }
        result.append(currentCount);
        result.append(currentChar);
        return result;
    }
}
