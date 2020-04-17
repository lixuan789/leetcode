package lixuan.DataStructure.arrayandmatrix;

/**
 * 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，
 * 同时满足以下条件：
 * ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 
 * [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 * ② 如果存在多种答案，你只需实现并返回其中任意一种.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/beautiful-arrangement-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code667ConstructArray {
    /**
     * 有规律，例如5,4
     * 从1开始+4,-3,+2,-1得到1,5,2,4,3
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        int d = k;
        boolean flag = true;//true为正，false为负
        for (int i = 1; i <= k; i++) {
            int factor = 1;
            if (flag == false) {
                factor = -1;
            }
            res[i] = res[i - 1] + factor * d;
            d--;
            flag = !flag;
        }
        for (int i = k + 1; i < n; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    /**
     * 优化
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray1(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        Code667ConstructArray array = new Code667ConstructArray();
        int[] ints = array.constructArray(10, 9);
        for (int num : ints) {
            System.out.println(num);
        }
    }
}
