package SwordRefers2Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Offer57_2.和为s的连续正数序列
 * @Description
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * @Author 黄景棠
 * @Update 2021/12/23 下午 5:24
 * @Since
 * @Version 1.0
 **/
public class Offer57_2 {
    //滑动窗口
    public int[][] findContinuousSequence(int target) {
        //左开右闭
        int i = 1; //左边界
        int j = 2; //右边界
        int sum = 1;
        List<int[]> res = new ArrayList<>();

        while (i<=target/2)
        {
            if (sum<target)
            {
                sum +=j;
                j++;
            }else if (sum>target)
            {
                sum -=i;
                i++;
            }else {
                int[] array = new int[j-i];
                for (int k=0;k<j-i;k++)   array[k] = i+k;
                res.add(array);
                sum -=i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);



    }
}
