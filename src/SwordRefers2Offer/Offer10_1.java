package SwordRefers2Offer;

/**
 * @ClassName Offer10_1.斐波那契数列
 * @Description TODO
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 *
 * 提示：
 *
 * 0 <= n <= 100
 *
 * @Author 黄景棠
 * @Update 2021/12/8 下午 3:48
 * @Since
 * @Version 1.0
 **/
public class Offer10_1 {
/** 思考：
 * 该题考察的是递归与迭代的转换：
 * 1. 递归：一种从上而下的思考方式；
 * 2、迭代：一种从下至上的思考方式；
 **/

    //通过递归实现
    public int fibByRecursion(int n) {

        if (n<2) return n;

        return (fibByRecursion(n-1)+fibByRecursion(n-2))%1000000007;

    }

    public int fibByIteration(int n) {


        if (n<2) return n;
        int fn0 = 0;
        int fn1 = 1;
        int fn2 = 0 ;

        for (int i = 2 ; i<=n; i++)
        {
            fn2 = (fn0 + fn1)%1000000007;
            fn0 = fn1;
            fn1 = fn2;
        }

        return fn2;



    }

    public static void main(String[] args) {
        Offer10_1 offer = new Offer10_1();
        System.out.println(offer.fibByIteration(5));
    }
}
