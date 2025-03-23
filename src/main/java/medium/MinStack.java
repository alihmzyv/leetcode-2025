package medium;

import java.util.LinkedList;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.getMin());
    }

    private final LinkedList<Integer> elementData;
    private final LinkedList<Integer> minElements;

    public MinStack() {
        elementData = new LinkedList<>();
        minElements = new LinkedList<>();
    }

    public void push(int val) {
        elementData.addLast(val);
        if (!minElements.isEmpty()) {
            minElements.addLast(Math.min(val, minElements.getLast()));
        } else {
            minElements.addLast(val);
        }
    }

    public void pop() {
        elementData.removeLast();
        minElements.removeLast();
    }

    public int top() {
        return elementData.getLast();
    }

    public int getMin() {
        return minElements.getLast();
    }
}
