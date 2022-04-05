package SwordRefers2Offer;

import java.util.Stack;

/**
 * @ClassName Offer09.用两个栈实现队列
 * @Description TODO
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * @Author 黄景棠
 * @Update 2021/12/8 下午 3:10
 * @Since
 * @Version 1.0
 **/
public class Offer09 {
 /** 考察常用数据结构栈、队列的理解和运用
  * 思路：
  * 栈只能实现后进先出的逆序，队列需要实现先进先出的正序，
  * 队列的加入好说，加入到栈中，队列的先进先出删除，需要一个逆序后的序列压入栈 变成 逆序-逆序 ->得到正序
  *
  **/

    class HelpStack{
        int[] dataArray;
        int size;
        HelpStack(int num){
            dataArray = new int[num];
            size = 0;
        }

        boolean isEmpty(){
            return size==0;
        }

        void push(int n){
            dataArray[size++] = n;
        }

        int remove(){
            int n = dataArray[--size];
            return n;
        }
 }

    private HelpStack intStack;
    private HelpStack outStack;

    public Offer09() {

        intStack = new HelpStack(10000);
        outStack = new HelpStack(10000);

    }

    public void appendTail(int value) {
        //直接加进辅助进栈
        intStack.push(value);
    }

    public int deleteHead() {
        //1.如果出栈不为空，直接在出栈内出栈
        if (!outStack.isEmpty()) return outStack.remove();
        //2. 如果出栈为空，进栈为空，返回-1
        if (intStack.isEmpty()) return -1;
        //3. 出栈为空，进栈不为空，大转移将进栈的逆序压入到出栈变成正序
        transfor(intStack,outStack);
        return outStack.remove();
    }

    private void transfor(HelpStack in,HelpStack out){

        while (!in.isEmpty())   out.push(in.remove());

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */