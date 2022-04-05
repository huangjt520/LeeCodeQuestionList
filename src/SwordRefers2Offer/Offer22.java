package SwordRefers2Offer;

/**
 * @ClassName Offer22.链表中倒数第k个节点
 * @Description
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * @Author 黄景棠
 * @Update 2021/12/15 下午 4:09
 * @Since
 * @Version 1.0
 **/
public class Offer22 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null) return null;
        if (k<=0) return head;

        ListNode cur = head;
        ListNode result = head;


        while (cur!=null)
        {
            if (k<=0)   result= result.next;
            cur = cur.next;
            k--;
        }

        return result;
    }
}
