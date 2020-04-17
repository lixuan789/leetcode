package lixuan.DataStructure.arrayandmatrix;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code287FindDuplicate {
    private int res;

    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int l = 1, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) cnt++;
            }
            if (cnt > mid) h = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    /**
     * 双指针解法，类似于有环链表中找出环的入口：
     * 数组中如果有重复的数，那么就会产生多对一的映射，这样，形成的链表就一定会有环路了，
     * 1.数组中有一个重复的整数 <==> 链表中存在环
     * 2.找到数组中的重复整数 <==> 找到链表的环入口
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
