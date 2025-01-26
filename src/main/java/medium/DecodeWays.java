package medium;

import java.util.Objects;

public class DecodeWays {
    public static void main(String[] args) {
        int result = new DecodeWays().numDecodings("226");
        System.out.println("Result " + result);
    }

    public int numDecodings(String s) {
        Integer[] numOfDecodingByStartingPos = new Integer[s.length() + 1];
        numOfDecodingByStartingPos[s.length()] = 1;
        return decodeRecursively(s, 0, numOfDecodingByStartingPos);
    }

    private int decodeRecursively(String s, int pos, Integer[] numOfDecodingByStartingPos) {
        if (Objects.nonNull(numOfDecodingByStartingPos[pos])) {
            return numOfDecodingByStartingPos[pos];
        }

        char ch = s.charAt(pos);
        if (ch == '0') {
            return 0;
        } else {
            int result = decodeRecursively(s, pos + 1, numOfDecodingByStartingPos);
            if (pos < s.length() - 1 && (ch == '1' || (ch == '2' && "0123456".contains(String.valueOf(s.charAt(pos + 1)))))) {
                result += decodeRecursively(s, pos + 2, numOfDecodingByStartingPos);
            }
            numOfDecodingByStartingPos[pos] = result;
            return result;
        }
    }

}
