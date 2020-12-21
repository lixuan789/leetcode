package lixuan.everyday;

import java.util.Arrays;

public class Code922SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            while (i < j && A[i] % 2 == 0) {
                i++;
            }
            while (i < j && A[j] % 2 == 1) {
                j--;
            }
            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int mid = A.length / 2;
        for (int k = 1; k < mid; k+=2) {
            int temp = A[k];
            A[k] = A[A.length - 1 - k];
            A[A.length - 1 - k] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        Code922SortArrayByParityII test = new Code922SortArrayByParityII();
        int[] a = {4, 1, 1, 0, 1, 0};
        int[] array = test.sortArrayByParityII(a);
        for (int num : array) {
            System.out.println(num);
        }
    }
}
