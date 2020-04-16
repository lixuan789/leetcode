package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code538ConvertBST {
    private int sum = 0;

    /**
     * 中序遍历下每个节点的值为该点及之后所有数字之和
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        sum = BSTSum(root);
        Inorder(root);
        return root;
    }

    private void Inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        int temp = root.val;
        root.val = sum;
        sum -= temp;
        Inorder(root.right);
    }

    private int BSTSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + BSTSum(root.left) + BSTSum(root.right);
    }
    /*
    //先遍历右子树。右根左，每个节点的值为当前数和前面所有的和
    //类似于第一个版本的逆序版本
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return root;
    }

    private void traver(TreeNode node) {
        if (node == null) return;
        traver(node.right);
        sum += node.val;
        node.val = sum;
        traver(node.left);
    }*/
}
