package lixuan.everyday;

import java.util.Stack;

public class Code394DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String string = "";
                while (!stack.peek().equals("[")) {
                    string = stack.pop() + string;
                }
                stack.pop();

                String countString = "";
                while ((!stack.isEmpty()) && (stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')) {
                    countString = stack.pop() + countString;
                }
                int count = Integer.parseInt(countString);

                String retString = "";
                for (int j = 0; j < count; j++) {
                    retString = retString + string;
                }
                stack.push(retString);
            } else {
                String str = "" + s.charAt(i);
                stack.push(str);
            }
        }

        String aaa = "";
        while (!stack.isEmpty()) {
            aaa = stack.pop() + aaa;
        }
        return aaa;
    }
}
