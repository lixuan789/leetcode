package lixuan.test.test3;

import java.util.Arrays;

/**
 * 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 的采样个数。
 * <p>
 * 我们以 浮点数 数组的形式，分别返回样本的最小值、最大值、平均值、中位数和众数。其中，众数是保证唯一的。
 * <p>
 * 我们先来回顾一下中位数的知识：
 * <p>
 * 如果样本中的元素有序，并且元素数量为奇数时，中位数为最中间的那个元素；
 * 如果样本中的元素有序，并且元素数量为偶数时，中位数为中间的两个元素的平均值。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：[1.00000,3.00000,2.37500,2.50000,3.00000]
 */
public class sampleStats {
    public double[] sampleStats(int[] count) {
        double sum = 0;
        double min = 0;
        double max = 0;
        double zs = 0;
        int maxCount = Integer.MIN_VALUE;
        boolean isFirst = true;
        long sumCount = 0;
        for (int i = 0; i < 256; i++) {
            sum += i * count[i];
            sumCount += count[i];
            if (count[i] != 0 && isFirst) {
                min = i;
                isFirst = false;
            }
            if (count[i] != 0) {
                max = i;
            }
            if (count[i] > maxCount) {
                maxCount = count[i];
                zs = i;
            }
        }
        int index = 0;
        double sumMid = 0.0;
        int countMid = 0;
        double pj = sum / (sumCount * 1.0);
        for (int i = 0; i < 256; i++) {
            int pre = index;
            index += count[i];
            if (sumCount % 2 == 0 && count[i] > 0) {
                if (index >= sumCount / 2 + 1 && count[i] >= 2 && pre < sumCount / 2) {//在count[i]区间中
                    countMid = 2;
                    sumMid += 2 * i;
                } else if (index >= sumCount / 2) {
                    sumMid += i;
                    countMid++;
                }
            } else {
                if (index >= sumCount / 2 + 1) {
                    sumMid = 2 * i;
                    countMid = 2;
                }
            }
            if (countMid == 2) {
                break;
            }
        }
        double zws = sumMid / 2.0;
        return new double[]{min, max, pj, zws, zs};
    }
}
