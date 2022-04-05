/**
 * @ClassName Question70.爬楼梯
 * @Description TODO
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @Author 黄景棠
 * @Update 2021/12/8 下午 4:23
 * @Since
 * @Version 1.0
 **/
public class Question70 {
/**
 * @Description: TODO 斐波那契数列变式
 **/

    public int climbStairs(int n) {
        int fn0 = 1;
        int fn1 = 1;
        int fn2 = 0;
        if (n<2) return n;

        for (int i=2; i<=n ; i++)
        {
            fn2 = fn0 + fn1;
            fn0 = fn1;
            fn1 = fn2;
        }

        return fn2;

    }
}
