package lixuan.test.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 1122. 数组的相对排序
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr2) {
            set.add(num);
        }
        for (int i = 0; i < arr1.length; i++) {
            if (set.contains(arr1[i])) {
                map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
            } else {
                list.add(arr1[i]);
            }
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < map.get(arr2[i]); j++) {
                arr1[index++] = arr2[i];
            }
        }
        Collections.sort(list);
        for (Integer num : list) {
            arr1[index++] = num;
        }
        return arr1;
    }

    public static void main(String[] args) {
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] arr1={28,6,22,8,44,17};
        int[] arr2={22,28,8,6};
        int[] array = relativeSortArray.relativeSortArray(arr1, arr2);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
