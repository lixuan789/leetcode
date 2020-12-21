package lixuan.everyday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 */
public class Code842SplitIntoFibonacci {

    public List<Integer> splitIntoFibonacci(String S) {
        LinkedList<Integer> res=new LinkedList<>();
        dfs(S,0,res);
        return res;
    }

    public boolean dfs(String S,int index,List<Integer> lis){
        if (index == S.length()) {
            return lis.size()>2;
        }
        for (int i=index+1;i<=S.length();i++) {
            String temp=S.substring(index,i);
            //长度大于10,或者Long解析出来大于INT_MAX了就直接break
            if (S.charAt(index) == '0' && i>index+1 || temp.length()>10 || Long.valueOf(temp)>Integer.MAX_VALUE) {
                break;
            }
            int str=Integer.valueOf(temp);
            int one=lis.size()>=2 ? lis.get(lis.size()-1):-1;
            int two=lis.size()>=2 ? lis.get(lis.size()-2):-1;
            lis.add(str);
            if ((one==-1 || two==-1 || one+two==str) && dfs(S,i,lis)) {
                return true;
            }
            lis.remove(lis.size()-1);
        }
        return false;
    }

    public static void main(String[] args) {
        Code842SplitIntoFibonacci split = new Code842SplitIntoFibonacci();
        List<Integer> list = split.splitIntoFibonacci("123456579");
        System.out.println(list.toString());
    }
}
