package SwordRefers2Offer;

/**
 * @ClassName Offer65.不用加减乘除做加法
 * @Description
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *  
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @Author 黄景棠
 * @Update 2021/12/24 下午 4:26
 * @Since
 * @Version 1.0
 **/
public class Offer65 {
    //用位运算模拟加法运算
    public int add(int a, int b) {

        while (b!=0)
        {
            int sum1 = a^b;
            int sumCarry = (a&b)<<1;
            a = sum1;
            b = sumCarry;
        }
        return a;
    }
}
