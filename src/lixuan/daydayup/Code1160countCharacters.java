package lixuan.daydayup;

import java.util.HashMap;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），
 * 那么我们就认为你掌握了这个单词。
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code1160countCharacters {
    /**
     * 利用hashmap存储每个字母的次数，用掉一个减一
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        if (chars == null || chars.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i), 0) + 1);
        }
        int res = 0;
        for (String word : words) {
            boolean flag = true;
            HashMap<Character, Integer> temp = new HashMap<>();
            temp.putAll(map);
            for (int i = 0; i < word.length(); i++) {
                if (temp.containsKey(word.charAt(i)) && temp.get(word.charAt(i)) >= 1) {
                    temp.replace(word.charAt(i), temp.get(word.charAt(i)) - 1);
                } else {
                    flag = false;
                }
            }
            if (flag) {
                res += word.length();
            }

        }
        return res;
    }

    /**
     * 只包含小写字母可以优化：用一个长度为26的数组即可
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters1(String[] words, String chars) {
        int[] c = new int[26];
        for (char cc : chars.toCharArray()) {
            c[(cc - 'a')] += 1;
        }
        int res = 0;
        for (String word : words) {
            int[] w = new int[26];
            for (char ww : word.toCharArray()) {
                w[(ww - 'a')] += 1;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (w[i] > c[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += word.length();
            }
        }
        return res;
    }
}
