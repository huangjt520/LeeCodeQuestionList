package SwordRefers2Offer;

/**
 * @ClassName Offer57.和为s的两个数字
 * @Description
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * @Author 黄景棠
 * @Update 2021/12/21 下午 8:53
 * @Since
 * @Version 1.0
 **/
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        if (nums==null||nums.length<2) return new int[0];
        for (int i=0;i<nums.length;i++)
        {
            for (int j = nums.length-1;nums[i]+nums[j]>=target;j--)
                if (nums[i]+nums[j]==target) return new int[]{nums[i],nums[j]};
        }
        return new int[0];

    }

    /**
     * @Description: 对撞双指针
     * @Author: Huang Jingtang
     * @Update: 2021/12/21  下午 9:02
     * @param nums:
     * @param target:
     * @return int[]:
     **/
    public int[] twoSumByDoubleMove(int[] nums, int target){
        if (nums==null||nums.length<2) return new int[0];
        int i=0,j=nums.length-1;
        while (i<j)
        {
            int n = nums[i] + nums[j];
            if (n>target) j--;
            else if (n<target)  i++;
            else return new int[]{nums[i],nums[j]};
        }

        return new int[0];

    }
}
