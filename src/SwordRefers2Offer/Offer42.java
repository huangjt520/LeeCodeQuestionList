package SwordRefers2Offer;

/**
 * @ClassName Offer42.连续子数组的最大和
 * @Description
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @Author 黄景棠
 * @Update 2021/12/21 下午 6:17
 * @Since
 * @Version 1.0
 **/
public class Offer42 {
    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0) return Integer.MIN_VALUE;
        int[] numDP = new int[nums.length+1];
        int max= numDP[0];

        for (int i=0;i<nums.length;i++)
        {
            if (numDP[i]<0) numDP[i+1] = nums[i];
            else numDP[i+1] = numDP[i]+ nums[i];
            if (numDP[i+1]>max) max = numDP[i+1];
        }

        return max;
    }
}
