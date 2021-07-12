package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Code37Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "n,";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        if (split == null || "n".equals(split[0])) {
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.stream(split).collect(Collectors.toList()));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String poll = queue.poll();
        if ("n".equals(poll)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(poll));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
