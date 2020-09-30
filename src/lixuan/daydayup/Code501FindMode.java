package lixuan.daydayup;

import lixuan.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code501FindMode {
    private List<Integer> res;
    private int maxCount = 1;
    private int count = 1;
    private TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        InOrder(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void InOrder(TreeNode root) {
        if (root != null) {
            InOrder(root.left);
            if (pre != null) {
                if (root.val == pre.val) {
                    count++;
                }else {
                    count=1;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                res.clear();
                res.add(root.val);
            }else if (count == maxCount) {
                res.add(root.val);
            }
            pre = root;
            InOrder(root.right);
        }
    }
}
