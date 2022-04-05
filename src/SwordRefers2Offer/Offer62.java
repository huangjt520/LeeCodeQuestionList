package SwordRefers2Offer;

import org.w3c.dom.Node;

/**
 * @ClassName Offer62.圆圈中最后剩下的数字
 * @Description
 * 0, 1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 * @Author 黄景棠
 * @Update 2021/12/24 下午 5:40
 * @Since
 * @Version 1.0
 **/
public class Offer62 {
    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    //循环链表
    public int lastRemaining(int n, int m) {
        Node pre = init(n);
        Node cur = pre.next;

        while (pre.next!=pre)
        {
            for (int i=0;i<m-1;i++)
            {
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
            cur = cur.next;
        }

        return cur.val;
    }

    private Node init(int n){
        Node head=null,cur=null,pre=null;
        for (int i=0;i<n;i++)
        {
            if (head==null)
            {
                head = new Node(i);
                cur = head;
                pre = cur;
                continue;
            }
            cur = new Node(i);
            pre.next = cur;
            pre = pre.next;
        }
        pre.next = head;
        return pre;
    }

    public static void main(String[] args) {
        Offer62 o = new Offer62();
        int n = 70866;
        int m = 116922;

        System.out.println(o.lastRemaining(n,m));
    }
}
