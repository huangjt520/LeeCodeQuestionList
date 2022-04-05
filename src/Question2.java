/** 便签 ： 加法模板 链表
 * 两数相加
 * 描述：给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例1：
 * 输入：l1 = 2->4->3 l2 = 5->6->4
 * 输出： 342 + 465 = 807 , 输出7->0->8
 *
 *
 */
public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           /* 初始版本
            //进位标识
            boolean flag = false;
            ListNode l3 = null; ListNode head3 = null;
            ListNode head1 = l1.next; ListNode head2 = l2.next;
            int sum = 0; int var1;int var2;
            //先构建新链表的头
            sum = l1.val+l2.val;
            if(sum>=10) flag=true; else flag=false;
            l3 = new ListNode(sum%10,null);
            head3 = l3;

            while(head1!=null||head2!=null)
            {

                var1 = head1!=null?head1.val:0;
                var2 = head2!=null?head2.val:0;
                if(flag) sum = var1+var2+1; else sum=var1+var2;
                if(sum>=10) flag=true; else flag=false;
                head3.next = new ListNode(sum%10,null);
                if(head1!=null) head1 = head1.next;
                if(head2!=null) head2 = head2.next;
                head3 = head3.next;
            }
            if(flag) head3.next = new ListNode(1,null);

            return l3;

            */
        /* 改进版本

        int flag = 0;
        int var1;int var2;
        //先构建新链表的头

        ListNode l3 = new ListNode(-1,null);
        ListNode head3 = l3;

        while(l1!=null||l2!=null||flag!=0)
        {
            if(l1!=null)
            {
                flag +=l1.val;
                l1 = l1.next;
            }
            if(l2!=null)
            {
                flag +=l2.val;
                l2 = l2.next;
            }
            head3.next = new ListNode(flag%10,null);
            head3 = head3.next;
            flag /= 10;

        }


        return l3.next;

         */
        /*if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode currentNode = head;
        int carryFlag = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (carryFlag == 1) {
                sum ++;
                carryFlag = 0;
            }
            if (sum >= 10) {
                carryFlag = 1;
                sum = sum % 10;
            }
            ListNode node = new ListNode(sum);
            currentNode.next = node;
            currentNode = node;
            if (l1.next == null || l2.next == null) {//将后面的拼过来
                if (carryFlag == 0) {//没有进位，直接将剩余链表接过来
                    currentNode.next = l1.next == null ? l2.next : l1.next;
                    break;
                } else {
                    //两个链表都到末尾了，并且有进位就建新节点
                    if (l1.next == null && l2.next == null) {
                        currentNode.next = new ListNode(1);
                        break;
                    } else if (l1.next == null) {
                        //只是链表1后面没有节点了，添加一个新节点到链表1后面
                        l1.next = new ListNode(1);
                        carryFlag = 0;
                    } else {
                        //只是链表2后面没有节点了，添加一个新节点到链表1后面
                        l2.next = new ListNode(1);
                        carryFlag = 0;
                    }
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return head.next;*/
        /* 模板做法 */
        //1. 确定计算顺序 该题是逆序：不需要改变顺序
        //2. 确定加数1，加数2,进位carry=[0,1]
        //3. 进位结束条件： 加数1和加数2都是链表，结束条件为l1,l2 == null,进位结束条件为0
        //3. 如何决定结果存储方式：题目已经要求存储方式为链表
        ListNode l3 = new ListNode(0);
        ListNode pre = l3;
        int carry = 0;
        //根据模板结束的条件l1==0&&l2==0&&carry==0的反条件为进行条件
        while(l1!=null || l2 !=null || carry!=0)
        {
            //进行位上面的加法计算同时进行移位
            if(l1!=null)
            {
                carry +=l1.val;
                l1 = l1.next;
            }
            if(l2!=null)
            {
                carry +=l2.val;
                l2 = l2.next;
            }
            //新建l3节点并处理数据
            pre.next = new ListNode(carry%10);
            //移位收尾
            carry = carry/10;
            pre = pre.next;
        }
        return l3.next;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //递归解法
    private ListNode recur(ListNode l1, ListNode l2, int add) {
        if (l1 == null && l2 == null && add == 0) return null;
        int curVal = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + add;
        ListNode res = new ListNode(curVal % 10);
        ListNode next = recur(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, curVal / 10);
        res.next = next;
        return res;
    }

}
