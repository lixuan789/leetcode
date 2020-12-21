package lixuan.everyday;

/**
 * 上升下降字符串
 */
public class Code1370SortString {
    public String sortString(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        int index = 0;
        boolean direction = true;
        while (index < s.length()) {
            if (direction) {
                for (int i = 0; i < 26; i++) {//上升
                    if (count[i] != 0) {
                        chars[index++] = (char) (i + 'a');
                        count[i]--;
                    }
                }
            } else {
                for (int j = 25; j >= 0; j--) {//下降
                    if (count[j] != 0) {
                        chars[index++] = (char) (j + 'a');
                        count[j]--;
                    }
                }
            }
            direction = !direction;
        }
        return new String(chars);
    }
}
