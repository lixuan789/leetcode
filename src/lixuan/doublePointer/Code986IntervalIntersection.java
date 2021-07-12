package lixuan.doublePointer;

import java.util.ArrayList;
import java.util.List;

public class Code986IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            if (b2 >= a1 && a2 >= b1) {
                int[] temp = new int[2];
                temp[0] = Math.max(a1, b1);
                temp[1] = Math.min(a2, b2);
                ans.add(temp);
            }
            if (b2 < a2) {
                j++;
            } else {
                i++;
            }
        }
        int[][] res = new int[ans.size()][2];
        return ans.toArray(res);
    }
}
