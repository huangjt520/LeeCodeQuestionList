import java.util.Arrays;

/** 453.最小操作次数使数组元素相等
 * 题目描述：给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * 范例：
 * 1：
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * 2：
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 * 提示：
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 答案保证符合 32-bit 整数
 *
 */
public class Question453 {

    /**
     * 解题思路：
     * 1.数学法 : 要观察到每一次操作，数组中最小的值都会自增；终态和初态的数组之和相差 操作次数 * (n-1)
     * a.假设终态相等的值为x,实际操作次数为y;
     * b.那么x与y的关系为 x = min + y   --(1);
     * c.操作过程中总和增加的值为 x * (n-1)，那么有 n * y = sum + x * (n-1) --(2);
     * d.(1)(2)化简得到 x = n * min - sum //可以看出数组每个数在x操作下都回到了最小值,该操作为每次操作-1.
     * 时间复杂度: 一次遍历求最小值与总和，为O(n)
     *
     * 2.取反法 : 相等到本质是差值为0,每次操作n-1个数加1，在相等的前提下是每次某个数减1，达到与最小值相等
     * a.求出最小值;
     * b.求出每个数与最小值的差值之和即为总操作数.
     * 时间复杂度: 一次遍历求最小值，一次遍历求差值和， 为 O(2n) -> O(n)
     *
     * 3.贪心法+取反法(取反法的优化) :相等到本质是差值为0,每次操作n-1个数加1，在相等的前提下是每次某个数减1，达到与最小值相等
     * 分析： 在[nums[0],nums[i-1]]区间，每次保证前一次的区间最小，最后达到终态总区间为[min,min,min...min]
     * a. 首次设 最小值min = nums[0], nums[i]与前一次最小值min的差值为 diff;
     * b. 那么每一次的操作增加区间长度, 要么nums[i]衰减到与min的值相等，要么min的值;
     * 衰减到与nums[i]的值相等，动作根据diff判断:
     *  (1)当diff>0时，说明nums[i]比min大,nums[i]衰减到min,该操作执行diff次，那么总操作次数为ans +=diff;
     *  (2)当diff<0时，说明nums[i]比min小，区间扩容后，前i个数需要衰减到nums[i],总操作次数为ans +=-diff,同时
     *  设局部最小值min = nums[i];
     * c. 最后可以得到终态的总操作次数ans
     * 示例： nums = [2,3,1,4]
     * 初始情况: 区间[2],min=2,ans=0,diff=0 ;
     * 第一次区间扩容变化 : [2] -> [2,3] -> 衰减到[2,2] , nums[1]=3,min=2,diff=1,ans=1,min'=2;
     * 第二次区间扩容变化 : [2,2] -> [2,2,1] -> [1,1,1] , nums[2]=1, min=2,diff=-1,ans'=ans - 2*(-1)=3,min'=1;
     * 第三次区间扩容变化 : [1,1,1] -> [1,1,1,4] -> [1,1,1,1] , nums[3]=4,min=1,diff=3,ans'=ans+3=6,min'=1.
     * 终态:[1,1,1,1],ans=6,diff=3
     * @param nums
     * @return
     */
    public static int minMove(int [] nums){
        int n= nums.length;
        int min = nums[0];
        int count = 0;
        int diff =  0;
        for(int i=1;i<n;i++)
        {
            diff = nums[i] - min;
            if(diff<0)
            {
                count = count - diff * i;
                min = nums[i];
            }else
            {
                count = count + diff;
            }
        }
        return count;

    }

    public static void main(String[] args) {
         int[] nums = {1,1,1,1};
        System.out.println(minMove(nums));
    }
}
