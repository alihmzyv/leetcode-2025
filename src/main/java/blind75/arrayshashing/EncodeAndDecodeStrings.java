package blind75.arrayshashing;

import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        String result = new EncodeAndDecodeStrings().encode(List.of("The quick brown fox","jumps over the","lazy dog","1234567890","abcdefghijklmnopqrstuvwxyz"));
        System.out.println(result);
        List<String> decode = new EncodeAndDecodeStrings().decode(result);
        System.out.println(decode);
    }

    private static final char DELIMITER = '#';

    //time - O(m + n)
    //space - O(m + n)
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str.length()).append(DELIMITER).append(str);
        }
        return result.toString();
    }

    //time - O(m + n)
    //space - O(m + n)
    public List<String> decode(String str) {
        List<String> result = new LinkedList<>();
        int endOfPreviousStr = -1;
        for (int index = 0; index < str.length();) {
            if (str.charAt(index) == DELIMITER) {
                int startOfCurrentStr = index + 1;
                String sizeAsStr = str.substring(endOfPreviousStr + 1, index);
                int sizeOfStr = Integer.parseInt(sizeAsStr);
                result.add(str.substring(startOfCurrentStr, startOfCurrentStr + sizeOfStr));
                index += sizeOfStr + 1;
                endOfPreviousStr = index - 1;
            } else {
                index++;
            }
        }
        return result;
    }
}
