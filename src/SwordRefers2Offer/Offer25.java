package SwordRefers2Offer;

/**
 * @ClassName Offer25.合并两个排序的链表
 * @Description
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * @Author 黄景棠
 * @Update 2021/12/14 下午 1:36
 * @Since
 * @Version 1.0
 **/
public class Offer25 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //原地合并 伪头结点法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //合并无非四种情况
        //len1 > len2; len1<len2;len1 =null;len2=null

        //伪头结点法,就不需要比较前后节点，而只要移动指针就行

        ListNode head = new ListNode(-1000);
        ListNode l = head;

        while (l1!=null&&l2!=null)
        {
            if (l1.val<=l2.val)
            {
                l.next = l1;
                l1=l1.next;
            }else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }

        l.next = l1==null?l2:l1;

        return head.next;

    }

    //递归合并
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;

        ListNode result;
        if (l1.val<=l2.val)
        {
            result = l1;
            l1 = l1.next;
        }else {
            result = l2;
            l2 = l2.next;
        }

        result.next = mergeTwoLists1(l1,l2);

        return result;
    }
}




