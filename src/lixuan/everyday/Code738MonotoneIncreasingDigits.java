package lixuan.everyday;

import java.util.Stack;

public class Code738MonotoneIncreasingDigits {
    /**
     * 单调递增的数字
     *
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        Stack<Integer> stack = new Stack<>();
        int temp = N;
        while (N != 0) {
            stack.push(N % 10);
            N /= 10;
        }
        int size = stack.size();
        int[] nums = new int[size];
        int index = 0;
        while (!stack.isEmpty()) {
            nums[index++] = stack.pop();
        }
        int j = 0;//需要变化的位
        for (; j < size - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                break;
            }
        }
        if (j == size - 1) {
            return temp;//本身就是递增的
        }
        while (j > 0) {
            if (nums[j] == nums[j - 1]) {//前面有相等的往前移
                j--;
            } else {
                break;
            }
        }
        nums[j] -= 1;
        for (int i = j + 1; i < size; i++) {
            nums[i] = 9;
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum * 10 + nums[i];
        }
        return sum;
    }
}
