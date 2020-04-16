package lixuan.daydayup;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 */
public class Code40getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null||arr.length==0||k<=0){
                return new int[]{};
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });//最大堆
        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Integer temp = maxHeap.poll();
            res[index++] = temp;
        }
        return res;
    }
}
