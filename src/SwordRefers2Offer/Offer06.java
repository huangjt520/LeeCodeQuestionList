package SwordRefers2Offer;


/**
 * @ClassName Offer06.从尾到头打印链表
 * @Description
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * @Author 黄景棠
 * @Update 2021/12/13 下午 6:00
 * @Since
 * @Version 1.0
 **/
public class Offer06 {

    //配合递归使用
    //int[] resur; int size=0;


    //使用递归的方法、迭代+栈、反转链表
    public int[] reversePrint(ListNode head) {

        if (head==null) return new int[0];

        //递归实现逆序
        //resur = new int[10000];
        //reverseResur(head);
        //return Arrays.stream(resur).limit(size).toArray();

        //迭代加栈的形式模拟递归
        /*
        Stack<Integer> stack = new Stack<>();

        while (head!=null)
        {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i=0,len=result.length;i<len;i++)   result[i] = stack.pop();

        return result;
        */

        //反转链表形式
        ListNode pre=null,cur=null,next=head;
        int size=0;
        while (next!=null)
        {
            //获取断开后下一个节点的引用
            //将断开节点next置向前置节点
            //循环
            cur = next;
            next = cur.next;
            cur.next = pre;

            pre = cur;
            size++;
        }

        int[] result = new int[size];
        for (int i=0;cur!=null;i++,cur=cur.next) result[i] = cur.val;

        return result;


    }

    //递归实现逆序
    //private void reverseResur(ListNode head){
    //    if (head==null)   return ;
    //    reverseResur(head.next);
    //    resur[size++] = head.val;
    //
    //}
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
