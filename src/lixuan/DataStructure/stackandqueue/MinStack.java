package lixuan.DataStructure.stackandqueue;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {
    //实现方法：同步栈
    /**
     * initialize your data structure here.
     */
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x < min) {
            min = x;
        }
        stack2.push(min);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
        min = stack2.isEmpty() ? Integer.MAX_VALUE : stack2.peek();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return min;
    }
}
