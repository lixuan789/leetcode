package lixuan.interview;

import java.util.Stack;

public class FindClosedNumbers {
    /**
     * 下一个数
     *
     * @param num
     * @return
     */
    public int[] findClosedNumbers(int num) {
        int[] ans = new int[2];
        int one = count(num);
        if (num >= Integer.MAX_VALUE) {
            ans[0] = -1;
        } else {
            boolean flag = true;
            for (int i = num + 1; i <= Integer.MAX_VALUE; i++) {
                if (count(i) == one) {
                    flag = false;
                    ans[0] = i;
                    break;
                }
            }
            if (flag) {
                ans[0] = -1;
            }
        }
        if (num <= 1) {
            ans[1] = -1;
        } else {
            boolean flag = true;
            for (int j = num - 1; j >= 1; j--) {
                if (count(j) == one) {
                    flag = false;
                    ans[1] = j;
                    break;
                }
            }
            if (flag) {
                ans[1] = -1;
            }
        }
        return ans;
    }

    /**
     * 计算1的个数
     *
     * @param num
     * @return
     */
    private int count(int num) {
        int cnt = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                cnt++;
            }
            num >>= 1;
        }
        return cnt;
    }
}
