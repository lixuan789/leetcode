package lixuan.Backtracking;

import lixuan.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Code257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, List<String> res, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {//为叶节点
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i != path.size() - 1) {
                    sb.append(path.get(i) + "->");
                } else {
                    sb.append(path.get(i));
                }
            }
            res.add(sb.toString());
        } else {
            dfs(root.left, res, path);
            dfs(root.right, res, path);
        }
        path.remove(path.size() - 1);
    }
}
