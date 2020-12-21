package lixuan.everyday;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code290WordPattern {
    /**
     * 单词规律
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), split[i]);
            } else {
                String s1 = map.get(pattern.charAt(i));
                if (!s1.equals(split[i])) {
                    return false;
                }
            }
        }

        Map<String, Character> map1 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!map1.containsKey(split[i])) {
                map1.put(split[i], pattern.charAt(i));
            } else {
                Character s1 = map1.get(split[i]);
                if (s1 != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
