package lixuan.DataStructure.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 在将一个元素 x 插入队列时，为了维护原来的后进先出顺序，
 * 需要让 x 插入队列首部。而队列的默认插入顺序是队列尾部，因此在将 x 插入队列尾部之后，
 * 需要让除了 x 之外的所有元素出队列，再入队列。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyStack {
    private LinkedList<Integer> queue = new LinkedList<Integer>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.addLast(x);
        int len = queue.size();
        for (int i = 0; i < len - 1; i++) {
            Integer num = queue.removeFirst();
            queue.addLast(num);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.removeFirst();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peekFirst();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
