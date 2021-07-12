package lixuan.everyday;

public class Code135Candy {
    /**
     * 求出以每个数（峰）为中心的下降、上升的个数
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int ans = 0;
        for (int i = 0; i < ratings.length; i++) {
            int left = 0;
            int right = 0;
            if (i == 0) {//特殊情况
                int j = i;
                while (j + 1 < ratings.length && ratings[j] > ratings[j + 1]) {
                    right++;
                    j++;
                }
                if (right == 0) {
                    ans += 1;
                } else {
                    ans += ((right + 2) * (right + 1)) / 2;
                    ans -= 1;//最小的那个数先不算
                }
            } else if (i < ratings.length - 1) {
                if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                    ans += 1;
                }
                if (ratings[i] >= ratings[i - 1] && ratings[i] >= ratings[i + 1]) {//大于左右两边
                    int j = i;
                    while (j > 0 && ratings[j] > ratings[j - 1]) {
                        j--;
                        left++;
                    }
                    int k = i;
                    while (k + 1 < ratings.length && ratings[k] > ratings[k + 1]) {
                        right++;
                        k++;
                    }
                    if (left > right) {
                        ans += ((left + 2) * (left + 1)) / 2;
                        ans -= 1;
                        ans += ((right + 1) * right) / 2;
                        ans -= right == 0 ? 0 : 1;
                    } else {
                        ans += ((left + 1) * left) / 2;
                        ans -= left == 0 ? 0 : 1;
                        ans += ((right + 2) * (right + 1)) / 2;
                        ans -= 1;
                    }
                }
            } else {
                int j = i;
                while (j > 0 && ratings[j] > ratings[j - 1]) {
                    j--;
                    left++;
                }
                if (left == 0) {
                    ans += 1;
                } else {
                    ans += ((left + 2) * (left + 1)) / 2;
                    ans -= 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Code135Candy candy = new Code135Candy();
        int[] ratings = {1, 2, 2};
        int candy1 = candy.candy(ratings);
        System.out.println(candy1);
    }
}
