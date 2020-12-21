package lixuan.everyday;

public class Code860LemonadeChange {
    /**
     * 柠檬水找零
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int a = 0, b = 0, c = 0;
        for (int bill : bills) {
            if (bill == 5) {
                a++;
            } else if (bill == 10) {
                b++;
                if (a == 0) {
                    return false;
                }
                a--;
            } else {
                c++;
                if (b == 0) {
                    if (a < 3) {
                        return false;
                    }
                    a -= 3;
                } else {
                    if (a == 0) {
                        return false;
                    }
                    b--;
                    a--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};
        Code860LemonadeChange test = new Code860LemonadeChange();
        boolean b = test.lemonadeChange(bills);
        System.out.println(b);
    }
}
