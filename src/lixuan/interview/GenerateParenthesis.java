package lixuan.interview;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    /**
     * 括号：分治法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
            return ans;
        }
        for (int i = 0; i < n; i++) {
            List<String> lefts = generateParenthesis(i);
            List<String> rights = generateParenthesis(n - i - 1);
            for (String left : lefts) {
                for (String right : rights) {
                    String str = "(" + left + ")" + right;
                    ans.add(str);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GenerateParenthesis test = new GenerateParenthesis();
        List<String> list = test.generateParenthesis(3);
        list.forEach(System.out::println);
    }
}
