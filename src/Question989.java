import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 989. 数组形式的整数加法
 * 描述：
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 *
 */
public class Question989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        //1. 确定加数1=num[],加数2=k,进位carry=[0,1]；
        //2. 确定顺序: 加数1是正序，但是可以用下标逆序访问；加数2是正序，但是可以用取模逆序访问，故不用改变顺序;
        //3. 确定终止条件 :num[i]的i<0&&k/10==0&&carry==0;
        //4. 存储结果：要求是列表，可以新建一个List充当栈的作用

        //设置进位,下标,存储栈
        int carry = 0;
        int index = num.length-1;
        //ArrayList底层是数组，往数组里面频繁插入，最好用linkdedList
        LinkedList<Integer> list =  new LinkedList<>();

        //根据终止条件的逆条件进行过程
        while(index>=0||k!=0||carry!=0)
        {
            //位计算顺便移位
            if(index>=0) carry +=num[index--];
            if(k!=0) carry += k%10;
            k /=10;

            //存储结果
            list.addFirst(carry%10);

            //处理进位
            carry /=10;

        }
        if(carry==1)list.addFirst(1);

        return list;

    }
}
