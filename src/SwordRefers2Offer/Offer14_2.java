package SwordRefers2Offer;

/**
 * @author huangjt
 * @ClassName: Offer14_2。剪绳子 II
 * @Description:
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *  
 *
 * 提示：
 *
 * 2 <= n <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2022/2/23 12:08
 */
public class Offer14_2 {

    public int cuttingRope(int n) {

        //对于剪绳子的1简单最终参数版本，2版本由于有取模。所以是动态执行。
        int mod = 1000000007;


        if (n <4) return n-1;
        //为long类型，不然在进行ans*3的时候就可能溢出
        long ans = 1;
        while (n>4)
        {
            ans = ans *3 % mod;
            n-=3;
        }

        return (int)(ans*n%mod);
    }


}
