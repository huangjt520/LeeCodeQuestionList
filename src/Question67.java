import java.util.ArrayList;
import java.util.List;

/**标签：加法模板，字符串
 * 描述:
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零
 *
 */
public class Question67 {
    public String addBinary(String a, String b) {
        //1. 确定顺序：虽然加数1，加数2都是正序的，但是加数1，加数2都可以下标遍历，所有可以逆序计算，不用改变顺序
        //2. 确定进制，二进制;
        //3. 确定加数1=a,加数2=b，进位carry=[0,1]
        //4. 确定过程结束条件：a的下标>=0||b的下标>0||carry!=0
        //5. 确定结果存储:String类型，最后进位可以用拼接，存储位可以用list

        //设置进位，下标
        int carry = 0;
        //将字符串转换为数组
        String[] list1 = a.split("");
        String[] list2 = b.split("");
        int len1 = list1.length;int len2 = list2.length;
        int index1 = a.length()-1 ; int index2 = b.length()-1;
        List<Integer> list = new ArrayList<>();

        while(index1>=0||index2>=0||carry!=0)
        {
            //计算各位结果顺便移位
            if(index1>=0)
            {
                carry += Integer.parseInt(list1[index1]);
                index1--;
            }
            if(index2>=0)
            {
                carry += Integer.parseInt(list2[index2]);
                index2--;
            }
            //存储计算结果
            list.add(0,carry%2);
            carry = carry/2;

        }
        //题目特色，将存储结果化为字符串
        String result = "";
        for(Integer i : list)result = result + i.toString();
        return result;

    }

    public String addBinary1(String a, String b){
        //1. 确定顺序：虽然加数1，加数2都是正序的，但是加数1，加数2都可以下标遍历，所以可以逆序计算，不用改变顺序
        //2. 确定进制，二进制;
        //3. 确定加数1=a,加数2=b，进位carry=[0,1]
        //4. 确定过程结束条件：a的下标<0||b的下标<0||carry!=0
        //5. 确定结果存储:String类型，最后进位可以用拼接，存储位可以用list

        //list的查询没有通过迭代器查询的效率高

        //定义进位，下标
        int carry = 0;
        int index1 = a.length()-1;int index2 = b.length()-1;
        //题目特色，用list充当栈的作用;StringBuilder适用于频繁修改字符串，以提交效率
        //list的查询没有通过迭代器查询的效率高
        //List<Integer> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        //根据条件的反条件进行过程
        while(index1>=0||index2>=0||carry!=0)
        {
            //位计算顺便移位
            //题目特色，用char将二进制转为十进制计算
            carry = carry + (index1>=0?a.charAt(index1--)-'0':0) +
                    (index2>=0?b.charAt(index2--)-'0':0);
            //存储位结果
            //list的查询没有通过迭代器查询的效率高
            //list.add(0,carry%2)
            result.append(carry%2);
            //处理进位
            carry=carry/2;
        }
        //判断最后是否进位
        //if(carry==1)list.add(0,1);
        if(carry==1)result.append(1);
        //处理结果，将逆序存储的数字一个个从栈顶弹出形成顺序
        //for(int i : list) result.append(i);

        return result.reverse().toString();


    }



}
