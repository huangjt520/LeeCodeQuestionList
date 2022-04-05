package SwordRefers2Offer;

/**
 * @ClassName Offer11.旋转数组的最小数字
 * @Description TODO
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * @Author 黄景棠
 * @Update 2021/12/8 下午 8:28
 * @Since
 * @Version 1.0
 **/
public class Offer11 {
    public int minArray(int[] numbers) {

        if (numbers==null) return -1;
        int len = numbers.length;
        if (len==1) return numbers[0];

        int index = len-1;

        while (index>0)
        {
            if (numbers[index]>=numbers[index-1])   index--;
            else return numbers[index];
        }
        return numbers[index];

    }
}
