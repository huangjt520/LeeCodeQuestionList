package SwordRefers2Offer;

/**
 * @ClassName Offer24.反转链表
 * @Description
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * @Author 黄景棠
 * @Update 2021/12/16 下午 4:05
 * @Since
 * @Version 1.0
 **/
public class Offer24 {


    class ListNode {
         int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }


    public ListNode reverseList(ListNode head) {
        if (head==null) return null;

        ListNode pre=null,cur=null,next=head;

        while (next!=null)
        {
            cur = next;
            next = next.next;
            cur.next = pre;
            pre = cur;
        }

        return cur;

    }
}
