package SwordRefers2Offer;

/**
 * @ClassName Offer.包含min函数的栈
 * @Description
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 * @Author 黄景棠
 * @Update 2021/12/21 下午 5:40
 * @Since
 * @Version 1.0
 **/
public class Offer30 {
    private int[] data;
    private int[] mindata;
    private int size;


    public Offer30(){
        size =0;
        data = new int[20000];
        mindata = new int[20000];
    }


    public void push(int x){
        if (size==0)
        {
            data[size] = x;
            mindata[size] = x;
            size++;
            return;
        }

        mindata[size] = mindata[size-1]>x?x:mindata[size-1];
        data[size] = x;
        size++;
    }

    public void pop(){
        if (size<=0) return;
        size--;
    }

    public int top(){
        if (size<=0) return Integer.MAX_VALUE;
        return data[size-1];
    }

    public int min(){
        if (size<=0) return Integer.MAX_VALUE;
        return mindata[size-1];
    }

}
