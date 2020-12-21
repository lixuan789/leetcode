package lixuan.daydayup;

import java.util.Stack;

public class Code925IsLongPressedName {
    /**
     * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，
     * 而字符可能被输入 1 次或多次。
     * <p>
     * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字
     * （其中一些字符可能被长按），那么就返回 True。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/long-pressed-name
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int n = name.length();
        int m = typed.length();
        while (i < n && j < m) {
            if (name.charAt(i) == typed.charAt(j)) {
                int cnt1 = 0;
                char c = name.charAt(i);
                while (i < n) {
                    if (c == name.charAt(i)) {
                        cnt1++;
                        i++;
                    } else {
                        break;
                    }
                }
                int cnt2 = 0;
                c=typed.charAt(j);
                while (j < m) {
                    if (c == typed.charAt(j)) {
                        cnt2++;
                        j++;
                    } else {
                        break;
                    }
                }
                if (cnt1 > cnt2) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if ((i==n&&j!=m)||(i!=n&&j==m)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Code925IsLongPressedName test = new Code925IsLongPressedName();
        boolean b = test.isLongPressedName("alex", "aaleex");
        System.out.println(b);
    }
}
