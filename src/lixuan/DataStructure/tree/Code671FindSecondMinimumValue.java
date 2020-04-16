package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code671FindSecondMinimumValue {
    /**
     * 根节点的值最小，根据题意，这题可以转换成求，左右子节点中的最小值．
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return -1;
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
        if (leftVal != -1) return leftVal;
        return rightVal;
    }
    public int findSecondMinimumValue1(TreeNode root) {
        return traversal(root,root.val);
    }

    private int traversal(TreeNode root,int value){
        if(root == null){
            return -1;
        }
        if(root.val > value){
            return root.val;
        }
        // 寻找左右子节点中，第一个大于自己的节点
        int l = traversal(root.left,value);
        int r = traversal(root.right,value);

        // 存在两个子节点
        if(l>=0 && r>=0){
            return Math.min(l,r);
        }
        //　存在0个子节点
        return Math.max(l,r);
    }
}
