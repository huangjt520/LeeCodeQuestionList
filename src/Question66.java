import javax.xml.transform.Result;
import java.util.Arrays;

/**
 * Question66:加一
 * 描述：给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *示例1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例3：
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class Question66 {
    public static int[] plusOne(int[] digits){
        /* 初始版
        //进位标识
        boolean flag = true;
        //数组长度
        int length = digits.length;
        for(int i = length-1; i >=0 && flag; i--)
        {
            digits[i] = (digits[i]+1)%10;
            if(digits[i]!=0) flag=false;
        }
        if(digits[0] == 0)
        {
            int[] newDigits = new int[length+1];
            newDigits[0] = 1;
            for(int i=0;i<length;i++) newDigits[i+1] = digits[i];
            return newDigits;
        }
        return digits;

         */
        /* 改进版
        //进位标识
        boolean flag = true;
        //数组长度
        int length = digits.length;
        for(int i = length-1; i >=0 && flag; i--)
        {
            digits[i] = (digits[i]+1)%10;
            if(digits[i]!=0) return digits;
        }

        int[] newDigits = new int[length+1];
        newDigits[0] = 1;
        return newDigits;
         */
        /* 套用加法模板 */
        //1. 运算顺序：该题数组是正序的，但是可以数组可以直接获取下标，所以改变成逆序只要从最后一位开始
        //2. 确定加数1，加数2，进位carry:该题加数1 为数组，加数2为0，进位可以看做初始进位为1
        //3. 确定过程结束标识:加数1的序号<0,不涉及加数2,进位carry为1
        //4. 构建结果:该题可以直接修改加数1,有进位时再创建一个比加数1长度大1的数组
        int carry =1 ;
        int i = digits.length - 1;
        //根据过程结束条件digits[i]中的i>=0||carry!=0的反条件
        while(i>=0||carry!=0)
        {
            //判断加数是否为null
            if(i<0)break;
            //进行位置上的运算
            carry += digits[i];
            //构建结果
            digits[i] = carry%10;
            //收尾处理进位和下一位
            carry /=10;
            //题目特殊处理，如果没有进位，直接返回加数
            if(carry<1)
                return digits;
            i--;

        }
        //最后计算的一位产生进位，构造新数组且根据题目特色新数组的后置位都是0

            int[] result = new int[digits.length+1];
            result[0]=1;
            return result;


    }

    public static void main(String[] args) {
        int[] digits = {9};
        System.out.println(Arrays.toString(plusOne(digits)));

    }
}
