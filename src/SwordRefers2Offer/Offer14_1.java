package SwordRefers2Offer;

/**
 * @author huangjt
 * @ClassName: Offer14_1.剪绳子
 * @Description:
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
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
 * 提示：
 *
 * 2 <= n <= 58
 *
 * @Date 2022/1/29 14:47
 */
public class Offer14_1 {

    /**
     * @Author : Huangjt
     * @Description : 贪心算法 ：每次尽可能减成长度为3的绳子
     * @Param [n]
     * @Return int
     * @Date 2022/1/29 15:15
     */
    public int cuttingRope(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        int m = n /3;
        int b = n%3;

        if (b==1) return (int) (Math.pow(3, m-1) * 4);
        if (b==2) return (int) (Math.pow(3, m) * b);

        return (int) Math.pow(3, m) ;


    }

    /**
     * @Author : Huangjt
     * @Description : 基于动态规划思想，对于长度为i的绳子，减一段j,后一段可减可不减，不减的话长度乘积为 j*(i-j);
     * 减的话长度乘积为 j * dp[i-j]
     *
     * @Param [n]
     * @Return int
     * @Date 2022/1/29 15:23
     */
    public int cuttingRope1(int n){

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2 ; i<=n ; i++)
        {
            for (int j = 1;j<i;j++)
            {
                //剪完第1段 j后第二段不减的长度乘积
                int len1 = j * (i-j);
                //剪完第一段 j后第二段继续减情况下长度乘积
                int len2 = j*dp[i-j];
                //取两者之间最大值,同时与转移前的dp[i]比较取最大值
                dp[i] = Math.max(dp[i],Math.max(len1, len2));
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        Offer14_1 o = new Offer14_1();
        int n = 4;
        System.out.println(o.cuttingRope1(7));
    }

}
