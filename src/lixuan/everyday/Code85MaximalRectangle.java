package lixuan.everyday;

import java.util.Stack;

public class Code85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        int[] heights = new int[n];//每一行中1的高度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        heights[j] = 1;
                    } else {
                        heights[j]++;
                    }
                } else {
                    heights[j] = 0;
                }
            }
            int maxArea = findMaxArea(heights);
            ans = Math.max(ans, maxArea);
        }
        return ans;
    }

    /**
     * 递增栈
     * @param heights
     * @return
     */
    private int findMaxArea(int[] heights) {
        int maxArea = 0;
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        for (int i = 1; i <= len; i++) {
            newHeights[i] = heights[i - 1];
        }
        newHeights[len + 1] = 0;//增加哨兵,保证入栈的元素都会弹出
        Stack<Integer> stack = new Stack<>();
        stack.push(0);//保证栈不为空
        for (int i = 1; i <= len + 1; i++) {
            while (newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Code85MaximalRectangle test = new Code85MaximalRectangle();
        char[][] chars = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int i = test.maximalRectangle(chars);
        System.out.println(i);
    }
}
