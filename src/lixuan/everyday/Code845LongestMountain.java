package lixuan.everyday;

/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-mountain-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code845LongestMountain {
    class Node {
        int val;
        int left;//左边小于它的数目
        int right;//右边小于它的数目

        Node(int val) {
            this.val = val;
            this.left = 0;
            this.right = 0;
        }
    }

    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Node[] nums = new Node[A.length];
        Node first = new Node(A[0]);
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                first.right++;
            } else {
                break;
            }
        }
        int ans = 0;
        Node pre = first;
        for (int i = 1; i < A.length; i++) {
            Node node = new Node(A[i]);
            if (A[i] < A[i - 1]) {
                node.left = 0;
                node.right = pre.right - 1;
            } else if (A[i] > A[i - 1]) {
                node.left = pre.left + 1;
                int num = 0;
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] < A[j - 1]) {
                        num++;
                    } else {
                        break;
                    }
                }
                node.right = num;
            }
            if (node.right > 0 && node.left > 0) {
                ans = Math.max(ans, node.left + node.right + 1);
            }
            pre = node;
        }
        return ans >= 3 ? ans : 0;
    }

    public static void main(String[] args) {
        Code845LongestMountain test = new Code845LongestMountain();
        int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = test.longestMountain(A);
        System.out.println(i);
    }
}
