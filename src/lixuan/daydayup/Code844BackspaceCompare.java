package lixuan.daydayup;

import java.util.Stack;

public class Code844BackspaceCompare {
    /**
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
     * 判断二者是否相等，并返回结果。 # 代表退格字符。
     *     注意：如果对空文本输入退格字符，文本继续为空
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/backspace-string-compare
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        return fun(S).equals(fun(T));
    }

    private String fun(String s) {
        Stack<Character> stack=new Stack<>();
        for (Character c:s.toCharArray()){
            if (c=='#'){
                if (stack.isEmpty()){
                    continue;
                }else {
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
