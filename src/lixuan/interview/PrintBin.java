package lixuan.interview;

public class PrintBin {
    /**
     * 二进制数转字符串
     *
     * @param num
     * @return
     */
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        int cnt = 0;
        while (num != 0) {
            double temp = num * 2;
            sb.append((int) temp);
            num = temp - (int) temp;
            cnt++;
            if (cnt >= 32) {
                return "ERROR";
            }
        }
        return sb.toString();
    }
}
