package lixuan.everyday;

public class Code941ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int i = 1;
        for (; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                break;
            }
            if (A[i] == A[i - 1]) {
                return false;
            }
        }
        if (i == A.length || i == 1) {
            return false;
        }
        for (; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean validMountainArray1(int[] A) {
        int n = A.length;
        if (n < 3) {
            return false;
        }
        int i = 0;
        int j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) {
            i++;
        }
        while (j - 1 >= 0 && A[j] < A[j - 1]) {
            j--;
        }
        if (i == j && i != 0 && j != n - 1) {
            return true;
        }
        return false;
    }

}
