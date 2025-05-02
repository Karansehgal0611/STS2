package STS2;

import java.util.Stack;

public class MInStack {
    // Stack of custom Pair<Integer, Integer>
    Stack<Pair<Integer, Integer>> stack = new Stack<>();

    // Push element and track minimum
    void push(int x) {
        int min = stack.isEmpty() ? x : Math.min(x, stack.peek().getValue());
        stack.push(new Pair<>(x, min));
    }

    // Pop element
    void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    // Top element
    int top() {
        if (!stack.isEmpty()) {
            return stack.peek().getKey();
        }
        return -1;
    }

    // Current minimum
    int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek().getValue();
        }
        return -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        MInStack minStack = new MInStack();
        minStack.push(3);
        minStack.push(5);
        System.out.println("Min: " + minStack.getMin()); // 3
        minStack.push(2);
        minStack.push(1);
        System.out.println("Min: " + minStack.getMin()); // 1
        minStack.pop();
        System.out.println("Min after pop: " + minStack.getMin()); // 2
        System.out.println("Top: " + minStack.top()); // 2
    }
}

// Custom Pair class
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K k, V v) {
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
