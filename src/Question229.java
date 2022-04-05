import java.util.ArrayList;
import java.util.List;

/**标签：摩尔投票，空间复杂度O(1),求出现超过n/k的次数
 * 229.求众数 II
 *描述：
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 示例：示例 1：
 *
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *
 * 提示：
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 */
public class Question229 {

    public List<Integer> majorityElement(int[] nums){
        //存活名单[a,b]
        int a=0;int b=0;
        //存活计数[c1,c2]
        int c1=0; int c2=0;

        for(int i : nums)
        {
            //命中情况
            if(a==i&&c1!=0) c1++;
            else if (b==i&&c2!=0) c2++;
            //未命中有无效位情况
            else if (c1==0 && ++c1>=0)a=i;
            else if (c2==0 && ++c2>=0)b=i;
            //未命中无无效位抵消情况
            else
            {
                c1--;c2--;
            }
        }
        //再从存活名单筛选符合条件成员
        c1=0;c2=0;
        for(int i:nums)
        {
            if(a==i)c1++;
            else if (b==i)c2++;

        }
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        if(c1>length/3) list.add(a);
        if (c2>length/3) list.add(b);
        return list;

    }
}
