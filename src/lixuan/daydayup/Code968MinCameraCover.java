package lixuan.daydayup;

import lixuan.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 计算监控树的所有节点所需的最小摄像头数量。
 */
public class Code968MinCameraCover {
    /**
     * 层序遍历计算每层的个数，然后再计算相隔数之间最小的和 (过测试用例80%)
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        int last = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            list.add(len);
            last = 0;
            while (len-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null && node.right != null) {
                    last++;
                }
            }
        }
        int sum1 = 0, sum2 = 0, sum3 = 0;
        int n = list.size();
        if (n <= 2) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sum1 += list.get(i);
            } else {
                sum2 += list.get(i);
            }
            if ((i - 1) % 3 == 0) {
                sum3 += list.get(i);
            }
        }
        if (last != 0 && last < list.get(n - 1)) {
            if (n % 2 == 0) {
                sum2 = sum2 - list.get(n - 1) + last;
            } else {
                sum1 = sum1 - list.get(n - 1) + last;
            }
            if ((n + 1) % 3 == 0) {
                sum3 = sum3 - list.get(n - 1) + last;
            }
        }
        if (n < 5) {
            return Math.min(sum1, sum2);
        }
        return Math.min(sum1, Math.min(sum2, sum3));
    }


    int res = 0;
    /**
     * 有三个状态:
     *      0当前节点和子节点都没有camera
     *      1当前节点有camera子节点无
     *      2当前节点无camera子节点有
     * @param root
     * @return
     */
    int sum = 0;
    public int minCameraCover1(TreeNode root) {
        return dfs(root) == 0 ? sum + 1 : sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            // 节点为空 表示能够被观察
            return 2;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            // 子节点有一个没有覆盖，就需要在当前节点装个相机覆盖
            sum++;
            return 1;
        } else if (left == 1 || right == 1) {
            // 子节点有一个有相机，则当前节点不需要相机覆盖
            return 2;
        } else {
            // 子节点都已经被覆盖，且都没有相机. 当前节点由父节点来覆盖.
            return 0;
        }
    }

}
