package lixuan.DataStructure.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素）
 * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code503NextGreaterElements {
    /**
     * 使用递减栈
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int pre = stack.pop();
                res[pre] = nums[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {//往后找没有大于他的数，可以从他之前找第一个大于他的数
            int pre = stack.pop();
            boolean flag = true;
            for (int i = 0; i < pre; i++) {
                if (nums[i] > nums[pre]) {//寻找第一个大于他的数
                    res[pre] = nums[i];
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res[pre] = -1;
            }
        }
        return res;
    }

    /**
     * 循环数组
     * @param nums
     * @return
     */
    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> pre = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!pre.isEmpty() && nums[pre.peek()] < num) {
                next[pre.pop()] = num;
            }
            if (i < n){
                pre.push(i);
            }
        }
        return next;
    }
}
