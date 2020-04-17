package lixuan.DataStructure.arrayandmatrix;

/**
 * 数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，
 * 并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * 我们最多能将数组分成多少块？
 * 注意:
 * arr 的长度在 [1, 10] 之间。
 * arr[i]是 [0, 1, ..., arr.length - 1]的一种排列。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-chunks-to-make-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code769MaxChunksToSorted {
    /**
     * 思路：下一块的最小值大于上一块的最大值
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int res = 1;
        int max = 0;
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == 0) {
                break;
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        i++;
        while (i < arr.length) {
            int j = arr.length - 1;
            for (; j >= i; j--) {
                if (arr[j] < max) {
                    res--;
                    break;
                }
            }
            for (; i <= j; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            res++;
            i = j + 1;
        }
        return res;
    }

    public int maxChunksToSorted1(int[] arr) {
        //当遍历到第i个位置时，如果可以切分为块，那前i个位置的最大值一定等于i。
        //否则，一定有比i小的数划分到后面的块，那块排序后，一定不满足升序。
        int res = 0, max = 0;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);//统计前i个位置的最大元素
            if (max == i) res++;
        }
        return res;
    }
}
