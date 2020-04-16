package lixuan.math;


/**
 * 对于 a 和 b 的最大公约数 f(a, b)，有：
 *
 * 如果 a 和 b 均为偶数，f(a, b) = 2*f(a/2, b/2);
 * 如果 a 是偶数 b 是奇数，f(a, b) = f(a/2, b);
 * 如果 b 是偶数 a 是奇数，f(a, b) = f(a, b/2);
 * 如果 a 和 b 均为奇数，f(a, b) = f(b, a-b);
 * 乘 2 和除 2 都可以转换为移位操作。
 */
public class BasicKnowledge {
    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        boolean isAEven = isEven(a), isBEven = isEven(b);
        if (isAEven && isBEven) {
            return 2 * gcd(a >> 1, b >> 1);
        } else if (isAEven && !isBEven) {
            return gcd(a >> 1, b);
        } else if (!isAEven && isBEven) {
            return gcd(a, b >> 1);
        } else {
            return gcd(b, a - b);
        }
    }

    private boolean isEven(int a) {
        return a%2==0;
    }
}
