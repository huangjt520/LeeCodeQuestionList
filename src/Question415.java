/** 415. 字符串相加
 * 标签： 套用加法模板
 * 描述:
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *  
 *
 *  
 *
 * 提示：
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Question415 {
    
    public String addStrings(String num1, String num2) {
        //1. 确定加数1=num1,加数2=num2,进位carry in [0,1];
        //2. 确定顺序：加数1和加数2都是正序，但是可以获取到下标，所以可以逆序计算
        //3. 确定结束条件： 加数1的下标<0&&加数2的下标<0&&进位==0
        //4. 结果存储：题目要求是正序的字符串，用StringBuilder存储最后反转

        //定义进位和获取下标
        int carry = 0 ;
        int index1 = num1.length()-1;
        int index2 = num2.length()-1;
        //定义结果存储结构StringBuilder
        StringBuilder  stringBuilder = new StringBuilder();

        //根据结束条件的反条件进行过程
        while(index1>=0||index2>=0||carry!=0)
        {
            //计算结果顺便移位
            if(index1>=0)
            {
                carry += num1.charAt(index1) - '0';
                index1--;

            }
            if(index2>=0)
            {
                carry += num2.charAt(index2) - '0';
                index2--;
            }

            //存储结果
            stringBuilder.append(carry%10);
            //处理进位
            carry /=10;
        }

        //判断最后一步是否有进位，有的话新增
        if(carry==1) stringBuilder.append(1);

        //反转成正序
        return stringBuilder.reverse().toString();
    }
}
