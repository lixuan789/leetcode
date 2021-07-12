package lixuan.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nsum {
    /**
     * nsum问题统一函数
     *
     * @param nums
     * @param n
     * @param start
     * @param target
     * @return
     */
    List<List<Integer>> nsumTarget(int[] nums, int n, int start, int target) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || size < n) {
            return res;
        }
        if (n == 2) {
            int lo = start, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int l = nums[lo], r = nums[hi];
                if (sum > target) {
                    while (lo < hi && nums[hi] == r) hi--;
                } else if (sum < target) {
                    while (lo < hi && nums[lo] == l) lo++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[lo]);
                    temp.add(nums[hi]);
                    res.add(temp);
                    while (lo < hi && nums[lo] == l) lo++;
                    while (lo < hi && nums[hi] == r) hi--;
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> list = nsumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> item : list) {
                    item.add(nums[i]);
                    res.add(item);
                }
                while (i < size - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Nsum test = new Nsum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        List<List<Integer>> list = test.nsumTarget(nums, 3, 0, 0);
        list.forEach(System.out::println);
    }
}
