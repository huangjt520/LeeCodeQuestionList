package SwordRefers2Offer;

/**
 * @author huangjt
 * @ClassName: Offer16.数值的整数次方
 * @Description:
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *  
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *
 * @Date 2022/2/23 12:52
 */
public class Offer16 {
    public double myPow(double x, int n) {

        if (x==0) return 0;
        double result = 1;
        if (n<0)
        {
            x = 1/x;
            n = -n;
        }

        while (n>0)
        {
            if ( (n&1)==1) result = result * x;
            x*=x;
            n>>=1;
        }

        return result;

    }
}
