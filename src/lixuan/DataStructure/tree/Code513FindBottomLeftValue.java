package lixuan.DataStructure.tree;

import lixuan.utils.ListNode;
import lixuan.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Code513FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode ans = null;
        while (!queue.isEmpty()) {
            ans = queue.peek();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return ans.val;
    }
}
