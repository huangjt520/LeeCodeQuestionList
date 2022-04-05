package SwordRefers2Offer;

/**
 * @ClassName Offer17. 打印从1到最大的n位数
 * @Description
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * @Author 黄景棠
 * @Update 2021/12/14 下午 2:42
 * @Since
 * @Version 1.0
 **/
public class Offer17 {
    public int[] printNumbers(int n) {
        if (n<=0) return null;
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<n;i++)
            builder.append("9");
        int num = Integer.parseInt(builder.toString());
        int[] result = new int[num];
        for (int i=0;i<num;i++) result[i] = i+1;

        return result;
    }
}
