package SwordRefers2Offer;

import java.util.Stack;

/**
 * @author huangjt
 * @ClassName: Offer31.栈的压入、弹出序列
 * @Description:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *  
 *
 * 提示：
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2022/3/5 9:58
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //模拟栈的压入和弹出
        if (pushed==null||pushed.length==0) return true;
        Stack<Integer> stack = new Stack<>();

        for (int pushi =0,popi=0,len1=pushed.length,len2=popped.length;popi<len2;)
        {
            //如果是空栈，压栈
            if (stack.isEmpty())
            {
                stack.add(pushed[pushi++]);
            }else if(stack.peek()==popped[popi]){
                //出栈
                stack.pop();
                popi++;
            }else if (stack.peek()!=popped[popi]&&pushi<len1){
                stack.add(pushed[pushi++]);
            }else if (stack.peek()!=popped[popi]&&pushi>=len1){
                return false;
            }

        }

        //能成功模拟，返回true
        return true;

    }

    /**
     * @Author : Huangjt
     * @Description : 牛逼，通过迭代与序号的方式动态更新栈，清除掉数组中出栈的元素
     * @Param [pushed, popped]
     * @Return boolean
     * @Date 2022/3/5 11:11
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {

        int pushi = 0;
        int popi = 0;

        for (int i : pushed) {
            //入栈，同时更新已经出栈的元素
            pushed[pushi] = i;
            while (pushi>=0&&pushed[pushi]==popped[popi]){
                //出栈
                pushi--;
                popi++;
            }
            //不能改变在栈的元素
            pushi++;
        }

        return pushi==0;
    }

    public static void main(String[] args) {
        Offer31 o = new Offer31();
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,2,1};
        boolean isOk = o.validateStackSequences(pushed,popped);
        System.out.println(isOk);
    }
}
