package SwordRefers2Offer;

/**
 * @ClassName Offer 03. 数组中重复的数字
 * @Description TODO
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * @Author 黄景棠
 * @Update 2021/12/8 下午 4:32
 * @Since
 * @Version 1.0
 **/
public class Offer03 {
// 相当于实现简单的高效查找散列表
    public int findRepeatNumber(int[] nums) {

        int len = nums.length;

        //由于题目性质，只需要随机找到一个，可以设置为boolean散列表
        boolean[] flags = new boolean[len];


        for (int i=0;i<len;i++)
        {
            //如果散列表该位置上已维护，说明该值时重复值，返回
            if (flags[nums[i]]) return nums[i];
            //维护散列表
            flags[nums[i]] = true;
        }
        return -1;
    }


    //原地置换实现
    //1.根据题目 n 长度的数组元素大小在[0,n-1]之间，可以得到如无重复元素，索引和数据值都是一一对应关系
    //2. 可在数组原地维护一一对应关系，如果右值破坏一一对应关系，说明该值是重复元素；
    //3. 由维护特点知道遍历索引下标的左边都是维护好的关系，逐渐向右维护
    public int findRepeatNumber1(int[] nums) {

        for (int i =0,len = nums.length ; i<len;i++)
        {
            //1. 如果索引等于值，说明字典关系已维护好

            //2. 如果索引不等于值，说明需要维护字典关系
            while (nums[i]!=i)
            {
                //由性质可知，索引的左边都是维护好的关系，如果值小于索引，说明破坏了关系，属于重复值
                //特别的，当值充当索引所对应的值大于当前索引值，同时等于当前值时，说明也是重复元素，直接返回，不然会死循环，参考
                //数组 [1,1,1]
                if (nums[i]<i || nums[i]==nums[nums[i]]) return nums[i];
                //如果值大于索引，维护该索引下的字典关系（交换位置），直到关系维护好为止
                nums = swap(nums,i,nums[i]);
            }

        }
        return -1;
    }

    /**
     * @Description: TODO 置换元素
     * @Author: Huang Jingtang
     * @Update: 2021/12/8  下午 5:42
     * @param data:
     * @param i:
     * @param j:
     * @return int[]:
     **/
    private int[] swap(int[] data,int i,int j)
    {
        data[i] += data[j];
        data[j] = data[i]-data[j];
        data[i] -= data[j];
        return data;
    }

    public static void main(String[] args) {
        int[] test = {1,1,1};
        Offer03 offer = new Offer03();
        System.out.println(offer.findRepeatNumber1(test));
    }
}
