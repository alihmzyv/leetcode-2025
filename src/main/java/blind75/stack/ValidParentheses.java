package blind75.stack;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private static final Map<Character, Character> CLOSE_BRACKET_TO_OPEN_BRACKET =
            Map.of('}', '{',
                    ')', '(',
                    ']', '[');

    private static final List<Character> OPEN_BRACKETS = List.of('{', '(', '[');

    public boolean isValid(String s) {
        Stack<Character> openBrackets = new Stack<>();
        int length = s.length();
        for (int index = 0; index < length; index++) {
            char ch = s.charAt(index);
            if (OPEN_BRACKETS.contains(ch)) {
                openBrackets.push(ch);
            } else if (openBrackets.isEmpty() || openBrackets.pop() != CLOSE_BRACKET_TO_OPEN_BRACKET.get(ch)) {
                return false;
            }
        }
        return openBrackets.isEmpty();
    }
}
