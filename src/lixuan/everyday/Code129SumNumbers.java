package lixuan.everyday;

import lixuan.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code129SumNumbers {
    private int sum=0;
    private int num=0;
    public int sumNumbers(TreeNode root) {
        if (root==null){
            return 0;
        }
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        if (isLeaf(root)){
            num=num*10+root.val;
            sum+=num;
            num/=10;
            return;
        }
        num=num*10+root.val;
        dfs(root.left);
        dfs(root.right);
        num/=10;
    }

    private boolean isLeaf(TreeNode root) {
        return root!=null&&root.left==null&&root.right==null;
    }
}
