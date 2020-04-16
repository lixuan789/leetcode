package lixuan.DataStructure.tree;

import lixuan.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code501FindMode {
    /**
     * 借助桶排序
     *
     * @param root
     * @return
     */
    private int len = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        Inorder(root, count);
        List<Integer>[] bucket = new ArrayList[len + 1];
        for (int key : count.keySet()) {
            Integer cnt = count.get(key);
            if (bucket[cnt] == null) {
                bucket[cnt] = new ArrayList<>();
            }
            bucket[cnt].add(key);
        }
        ArrayList<Integer> res = new ArrayList<>();
        int j = len;
        for (; j >= 0; j--) {
            if (bucket[j] != null) {
                break;
            }
        }
        res.addAll(bucket[j]);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void Inorder(TreeNode root, HashMap<Integer, Integer> count) {
        if (root == null) return;
        Inorder(root.left, count);
        count.put(root.val, count.getOrDefault(root.val, 0) + 1);
        len++;
        Inorder(root.right, count);
    }

    /**
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     * 双重递归
     * @param root
     * @return
     */
    private int max = 0;
    private ArrayList<Integer> list = new ArrayList<>();
    private int frequency = 0;

    public int[] findMode1(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        frequency = 0;
        int cnt = count(root, root.val);
        if (cnt == max) {
            list.add(root.val);
        }
        if (cnt > max) {
            max = cnt;
            list.clear();
            list.add(root.val);
        }
        findMode1(root.left);
        findMode1(root.right);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private int count(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        if (root.val == num) {
            frequency++;
        }
        if (root.val >= num) {
            count(root.left, num);
        }
        if (root.val <= num) {
            count(root.right, num);
        }
        return frequency;
    }

    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;

    /**
     * 优化
     * @param root
     * @return
     */
    public int[] findMode2(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] ret = new int[maxCntNums.size()];
        int idx = 0;
        for (int num : maxCntNums) {
            ret[idx++] = num;
        }
        return ret;
    }

    private void inOrder(TreeNode node, List<Integer> nums) {
        if (node == null) return;
        inOrder(node.left, nums);
        if (preNode != null) {
            if (preNode.val == node.val) curCnt++;
            else curCnt = 1;
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        } else if (curCnt == maxCnt) {
            nums.add(node.val);
        }
        preNode = node;
        inOrder(node.right, nums);
    }
}
