package SwordRefers2Offer;

/**
 * @ClassName Offer21.调整数组顺序使奇数位于偶数前面
 * @Description
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 *
 * @Author 黄景棠
 * @Update 2021/12/15 下午 3:54
 * @Since
 * @Version 1.0
 **/
public class Offer21 {

    //快速排序原理
    public int[] exchange(int[] nums) {
        if (nums==null) return null;
        int lenth = nums.length;
        if (lenth==0) return nums;

        int leftIndex = 0;
        int rightIndex = lenth-1;
        int temp =0;
        while (leftIndex<rightIndex)
        {
            while (leftIndex<rightIndex&&nums[leftIndex]%2==1) leftIndex++;
            while (rightIndex>leftIndex&&nums[rightIndex]%2==0) rightIndex--;



            temp = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = temp;


        }

        return nums;


    }
}
