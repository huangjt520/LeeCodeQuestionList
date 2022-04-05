package SwordRefers2Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Offer61.扑克牌中的顺子
 * @Description
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *  
 *
 * 限制：
 *
 * 数组长度为 5 
 *
 * 数组的数取值为 [0, 13] .
 *
 * @Author 黄景棠
 * @Update 2021/12/24 下午 4:43
 * @Since
 * @Version 1.0
 **/
public class Offer61 {
    public boolean isStraight(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]==0) continue;
            if (set.contains(nums[i])) return false;
            if (nums[i]<min)    min = nums[i];
            if (nums[i]>max)    max = nums[i];
            set.add(nums[i]);
        }

        return max-min<5;

    }
}
