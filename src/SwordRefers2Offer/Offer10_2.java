package SwordRefers2Offer;

/**
 * @ClassName Offer10_2.青蛙跳台阶问题
 * @Description TODO
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 *
 * @Author 黄景棠
 * @Update 2021/12/8 下午 4:12
 * @Since
 * @Version 1.0
 **/
public class Offer10_2 {
/**
 * 思考： 该题可以分解为上n台阶的方法 = 上n-1台阶的方法(跳一步) + 上n-2台阶的方法(跳两步)，明显的斐波那契数列
 **/

    public int numWays(int n) {
        int fn0 = 1 ;
        int fn1 = 1 ;
        int fn2 = 0 ;
        if (n<2) return 1;

        for (int i=2;i<=n;i++)
        {
            fn2 = (fn0+fn1)%1000000007;
            fn0 = fn1;
            fn1 = fn2;
        }

        return fn2;

    }
}
