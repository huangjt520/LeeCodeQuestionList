package SwordRefers2Offer;

/**
 * @ClassName Offer53_1.在排序数组中查找数字 I
 * @Description
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * @Author 黄景棠
 * @Update 2021/12/23 下午 8:06
 * @Since
 * @Version 1.0
 **/
public class Offer53 {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length;
        int mid = (l+r)/2;

        while (l<r)
        {
            if (nums[mid]<target)
            {
                l = mid+1;
            }else if (nums[mid]>target)
            {
                r = mid;
            }else {
                r = mid;
            }
            mid = (l+r)/2;
        }

        int res =0;
        for (int i = l;i<nums.length;i++,res++)
            if (nums[i]>target) break;

        return res;





    }


}
