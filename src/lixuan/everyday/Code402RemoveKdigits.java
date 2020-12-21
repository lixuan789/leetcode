package lixuan.everyday;

public class Code402RemoveKdigits {
    /**
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     * 注意:
     * num 的长度小于 10002 且 ≥ k。
     * num 不会包含任何前导零。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-k-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if(num.length()==0||k==0)
            return num;
        boolean flag=true;
        int n=num.length();
        int temp=k;
        while (k>0){
            for(int i=0;i<num.length()-1;i++){
                if(num.charAt(i)>num.charAt(i+1)){
                    num=num.substring(0,i)+num.substring(i+1,num.length());
                    flag=false;
                    break;
                }
            }
            k-=1;
        }
        if (flag){
            num=num.substring(0,n-temp);
        }
        if(num.length()>n-temp){
            num=num.substring(0,n-temp);
        }
        int index=0;
        while (index<num.length()){
            if(num.charAt(index)=='0'){
                index++;
            }else {
                break;
            }
        }
        return num.substring(index).length()==0?"0":num.substring(index);
    }

    public String removeKdigits1(String num, int k){
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) idx = j;
            s.delete(idx, idx + 1);
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Code402RemoveKdigits test = new Code402RemoveKdigits();
        String s = test.removeKdigits("102030", 3);
        System.out.println(s);
    }
}
