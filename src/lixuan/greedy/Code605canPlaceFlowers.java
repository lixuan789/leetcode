package lixuan.greedy;

/**
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，
 * 它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * 示例 1:
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code605canPlaceFlowers {
    /**
     * 规律：
     *      1.在首尾有连续0时，0的个数可以种植的花朵数为：headCount/2==0?headCount/2:headCount/2+1
     *      2.在中间的连续0，花朵数是每有连续3个0对应一个花朵
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int low = 0, high = 0;
        int count = 0;
        int headCount = 0, tailCount = 0;
        int i = 0;
        for (; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                headCount++;
            } else {
                break;
            }
        }
        if(headCount==flowerbed.length){//全部为0
            int num=headCount/2==0?headCount/2:headCount/2+1;
            return num>=n;
        }
        int j = flowerbed.length - 1;
        for (; j >= 0; j--) {
            if (flowerbed[j] == 0) {
                tailCount++;
            } else {
                break;
            }
        }
        for (int k = i + 1; k < j - 1; ) {
            if (flowerbed[k - 1] + flowerbed[k] + flowerbed[k + 1] == 0) {
                k += 2;
                count++;
            } else {
                k++;
            }
        }
        count += headCount / 2 ;
        count += tailCount / 2 ;
        return count >= n;
    }

    /**
     * 优化：
     * 我们从左到右扫描数组 flowerbed，如果数组中有一个 0，并且这个 0 的左右两侧都是 0，
     * 那么我们就可以在这个位置种花，即将这个位置的 0 修改成 1，并将计数器 count 增加 1。
     * 对于数组的第一个和最后一个位置，我们只需要考虑一侧是否为 0。
     * 在扫描结束之后，我们将 count 与 n 进行比较。如果 count >= n，那么返回 True，否则返回 False。
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/can-place-flowers/solution/chong-hua-wen-ti-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

    /**
     * 边界之外的可以单做0
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
