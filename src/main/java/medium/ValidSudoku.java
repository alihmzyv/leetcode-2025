package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    private static final char DOT = '.';

    record Point(int row, int col) {
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowToDigits = new HashMap<>();
        Map<Integer, Set<Character>> colToDigits = new HashMap<>();
        Map<Point, Set<Character>> subBoxPointToDigits = new HashMap<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char digit = board[row][col];
                if (digit != DOT) {
                    if (contains(row, digit, rowToDigits)) {
                        return false;
                    }
                    if (contains(col, digit, colToDigits)) {
                        return false;
                    }
                    Point subBoxPoint = new Point(row / 3, col / 3);
                    if (contains(subBoxPoint, digit, subBoxPointToDigits)) {
                        return false;
                    }
                    put(row, digit, rowToDigits);
                    put(col, digit, colToDigits);
                    put(subBoxPoint, digit, subBoxPointToDigits);
                }
            }
        }
        return true;
    }

    private <K, V> void put(K key, V val, Map<K, Set<V>> map) {
        Set<V> values = map.get(key);
        if (values == null) {
            Set<V> vals = new HashSet<>();
            vals.add(val);
            map.put(key, vals);
        } else {
            values.add(val);
        }
    }

    private <K, V> boolean contains(K key, V val, Map<K, Set<V>> map) {
        Set<V> values = map.get(key);
        return values != null && values.contains(val);
    }
}
