package lixuan.interview;

import java.util.Stack;

public class SortedStack {
    private Stack<Integer> stack;
    private Stack<Integer> temp;

    public SortedStack() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty() || stack.peek() >= val) {
            stack.push(val);
        } else {
            while (!stack.isEmpty() && stack.peek() < val) {
                Integer pop = stack.pop();
                temp.push(pop);
            }
            stack.push(val);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
