package lixuan.doublePointer;

public class Code76MinWindow {
    /**
     * 滑动窗口
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] need = new int[256];
        int[] window = new int[256];
        int size = 0;
        for (char c : t.toCharArray()) {
            if (need[c] == 0) {
                size++;
            }
            need[c]++;
        }
        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int valid = 0;//符合字符的个数
        char[] array = s.toCharArray();
        while (right < array.length) {
            char c = array[right];
            right++;
            if (need[c] != 0) {//是所需要的字符
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }
            System.out.println(left + ":" + right);
            while (valid == size) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = array[left];
                left++;
                if (need[d] != 0) {
                    if (window[d] == need[d]) {
                        valid--;
                    }
                    window[d]--;
                }

            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        Code76MinWindow test = new Code76MinWindow();
        String s = test.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
