package lixuan.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
public class setZeroes {
    /**
     * 方法一：使用标记，第一行和第一列用来标记
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        boolean rowzero = false;
        boolean colzero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colzero = true;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowzero = true;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowzero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (colzero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    /**
     * 使用2个set存储需要清零的行和列
     *
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        Set<Integer> rowset = new HashSet<>();
        Set<Integer> colset = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowset.add(i);
                    colset.add(j);
                }
            }
        }
        for (int i : rowset) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j : colset) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
