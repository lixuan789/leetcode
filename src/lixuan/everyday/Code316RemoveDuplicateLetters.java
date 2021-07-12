package lixuan.everyday;

import java.util.Stack;

public class Code316RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.contains(chars[i])) {//有相等的直接跳过
                cnt[chars[i]-'a']--;
                continue;
            }
            while (!stack.isEmpty() && chars[i] < stack.peek()) {
                Character peek = stack.peek();
                if (cnt[peek - 'a'] > 1) {
                    stack.pop();
                    cnt[peek - 'a']--;
                } else {
                    break;
                }
            }
            stack.push(chars[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
