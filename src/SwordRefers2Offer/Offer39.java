package SwordRefers2Offer;

/**
 * @ClassName Offer39.数组中出现次数超过一半的数字
 * @Description
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 *  
 *
 * @Author 黄景棠
 * @Update 2021/12/21 下午 6:56
 * @Since
 * @Version 1.0
 **/
public class Offer39 {

    public int majorityElement(int[] nums) {

        if (nums==null) return Integer.MAX_VALUE;


        int n = Integer.MAX_VALUE;
        int count = 0;
        for (int i=0;i<nums.length;i++)
        {
            if (count==0)
            {
                n = nums[i];
                count++;
            }else if (n==nums[i]){
                count++;
            }else if (n!=nums[i]){
                count--;
            }

        }
        return n;



    }
}
