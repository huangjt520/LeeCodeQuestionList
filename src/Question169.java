/**标签：摩尔投票，空间复杂度O(1)
 * 169. 多数元素
 * 描述：
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 */
public class Question169 {
    public int majorityElement(int[] nums) {

        //存活名单[a]
        int a=-9999999;
        //存活计数[count]
        int count = 0;
        for(int i :nums)
        {
            //未命中有无效位的情况
            if(count==0&&++count>=0) a=i;
                //命中情况
            else if(count!=0&&a==i) count++;
                //未命中无无效位的情况
            else count--;
        }
        return a;
    }
}
