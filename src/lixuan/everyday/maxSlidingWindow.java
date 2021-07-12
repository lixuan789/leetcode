package lixuan.everyday;

import java.util.LinkedList;

public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (queue.getFirst() <= i - k) {
                queue.removeFirst();
            }
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[queue.getFirst()];
            }
        }
        return res;
    }
}
