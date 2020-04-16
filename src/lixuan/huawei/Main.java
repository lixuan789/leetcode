package lixuan.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numA = 0;
        int numB = 0;
        int numC = 0;
        int numD = 0;
        int numE = 0;
        int errorIp = 0;
        int privateIp = 0;
//        int[] yanma={0,128,192,224,240,248,252,254,255};
        ArrayList<Integer> list = new ArrayList<>();
        int temp = 255;
        int a = 1;
        list.add(temp);
        for (int i = 0; i < 8; i++) {
            temp -= a;
            list.add(temp);
            a *= 2;
        }
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] strings = line.split("~");
            String[] ip = strings[0].split("\\.");
            String[] mark = strings[1].split("\\.");
            int[] res = new int[4];
            int numZero = 0;
            int numOne = 0;
            int i = 0;
            for (; i < 4; i++) {
                if (ip[i] == null || ip[i].length() == 0 || mark[i] == null || mark[i].length() == 0) {
                    break;
                }
                int markNum = Integer.parseInt(mark[i]);
                if (list.contains(markNum)) {
                    if (markNum == 0) {
                        numZero++;
                        res[i] = 0;
                    } else if (markNum == 255) {
                        if (numZero == 0) {//前面没有0
                            numOne++;
                            res[i] = Integer.parseInt(ip[i]);
                        } else {
                            break;
                        }
                    } else {
                        res[i] = Integer.parseInt(ip[i]) & markNum;
                        //有一种情况没考虑，例如255.255.255.128此时掩码合法但是i<4
                        break;
                    }
                } else {
                    break;//错误的掩码
                }
            }
            if (numZero == 4 || numOne == 4) {//掩码全是0或全是1
                errorIp++;
            } else if (i < 3) {
                if (ip[i] == null || ip[i].length() == 0 || mark[i] == null || mark[i].length() == 0) {
                    errorIp++;
                } else if (mark[i] != null && list.contains(Integer.parseInt(mark[i]))) {
                    int j = i + 1;
                    for (; j < 4; j++) {//255.128.0.0是合法的
                        if (ip[j] == null || ip[j].length() == 0 || mark[j] == null || mark[j].length() == 0) {
                            break;
                        } else if (mark[j] != null && Integer.parseInt(mark[j]) != 0) {
                            break;
                        }
                    }
                    if (j != 4) {
                        errorIp++;
                    }
                } else {
                    errorIp++;
                }
            } else if (i == 3) {//比如0.0.0.128此时掩码不合法但是i==3
                if (ip[i] == null || ip[i].length() == 0 || mark[i] == null || mark[i].length() == 0) {
                    errorIp++;
                } else if ((numZero == 3 && Integer.parseInt(mark[i]) != 0) || !list.contains(Integer.parseInt(mark[i]))) {
                    errorIp++;
                }
            } else {//有效的ip
                if (res[0] >= 1 && res[0] <= 126) {
                    numA++;
                    if (res[0] == 10) {
                        privateIp++;
                    }
                } else if (res[0] >= 128 && res[0] <= 191) {
                    numB++;
                    if (res[0] == 172) {
                        if (res[1] >= 16 && res[1] <= 31) {
                            privateIp++;
                        }
                    }
                } else if (res[0] >= 192 && res[0] <= 223) {
                    numC++;
                    if (res[0] == 192 && res[1] == 168) {
                        privateIp++;
                    }
                } else if (res[0] >= 224 && res[0] <= 239) {
                    numD++;
                } else if (res[0] >= 240 && res[0] <= 255) {
                    numE++;
                }
            }
        }
        System.out.println(numA + " " + numB + " " + numC + " " + numD + " " + numE + " " + errorIp + " " + privateIp);
        input.close();
    }
}