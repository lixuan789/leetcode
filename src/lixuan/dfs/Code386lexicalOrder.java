package lixuan.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * <p>
 * 例如，
 * <p>
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */
public class Code386lexicalOrder {
    /**
     * dfs,先排好数字1开口的，1、10、100。。。。。
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        for (int i = 1; i <= n; i++) {
            dfs(n, i, res);
        }
        return res;
    }

    private void dfs(int n, int i, ArrayList<Integer> res) {
        if (i > n) {
            return;
        }
        res.add(i);
        i *= 10;
        for (int j = 0; j < 10; j++) {
            dfs(n, i + j, res);
        }
    }

    /**
     * 循环版本
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder1(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        int cur = 1;
        for (int i = 0; i < n; i++) {
            res.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                if (cur >= n) cur /= 10;//例如当n=10时
                cur++;
                while (cur % 10 == 0) cur /= 10;
            }
        }
        return res;
    }
}
