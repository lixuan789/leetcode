package lixuan.divideAndConquer;

import lixuan.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 */
public class Code95generateTrees {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int s, int e) {
        List<TreeNode> res = new ArrayList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> leftTree = generate(1, i - 1);
            List<TreeNode> rightTree = generate(i + 1, e);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Code95generateTrees test = new Code95generateTrees();
        List<TreeNode> treeNodes = test.generateTrees(3);
        treeNodes.stream().forEach(System.out::println);
    }
}
