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
public class Code241diffWaysToCompute1 {
    /**
     * 方法：分治
     * 优化：memories，存储递归结果，有就直接取
     *
     * @param input
     * @return
     */
    private HashMap<String, List<String>> map = new HashMap<>();

    public List<String> diffWaysToCompute(String input) {
        List<String> res=new ArrayList<>();
        char[] chars = input.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='-'||chars[i]=='+'||chars[i]=='*'){
                List<String> left = diffWaysToCompute(input.substring(0, i));
                List<String> right = diffWaysToCompute(input.substring(i+1));
                for (String l:left){
                    for (String r:right){
                        String s="";
                        if (chars[i]=='-'){
                            s="("+l+"-"+r+")";
                        }else if (chars[i]=='+'){
                            s="("+l+"+"+r+")";
                        }else {
                            s="("+l+"*"+r+")";
                        }
                        res.add(s);
                    }
                }
            }
        }
        if (res.size()==0){
            res.add(input);
        }
        return res;
    }

    public static void main(String[] args) {
        Code241diffWaysToCompute1 test = new Code241diffWaysToCompute1();
        List<String> list = test.diffWaysToCompute("2-2-1");
        for (String s:list){
            System.out.println(s);
        }
    }
}
