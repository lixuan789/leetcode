package lixuan.divideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * 示例 1:
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code241diffWaysToCompute {
    /**
     * 分治法：使用递归
     *
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer num1 : left) {
                    for (Integer num2 : right) {
                        switch (c) {
                            case '+':
                                res.add(num1 + num2);
                                break;
                            case '-':
                                res.add(num1 - num2);
                                break;
                            case '*':
                                res.add(num1 * num2);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {//全部为数字
            res.add(Integer.parseInt(input));
        }
        return res;
    }

    /**
     * 优化：memories，存储递归结果，有就直接取
     *
     * @param input
     * @return
     */
    private HashMap<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute1(String input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer num1 : left) {
                    for (Integer num2 : right) {
                        switch (c) {
                            case '+':
                                res.add(num1 + num2);
                                break;
                            case '-':
                                res.add(num1 - num2);
                                break;
                            case '*':
                                res.add(num1 * num2);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {//全部为数字
            res.add(Integer.parseInt(input));
        }
        map.put(input, res);
        return res;
    }
}
