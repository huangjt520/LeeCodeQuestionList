import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjt
 * @ClassName: Q141_1.环形链表
 * @Description:
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *  
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 *  
 *
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @Date 2022/3/1 10:38
 */
public class Q141_1 {

    //通过集合方法
    public boolean hasCycle_set(ListNode head) {
        //1.每到一个节点，检查是否在集合中
        //2. 如果在集合中，返回true;如果不在，将节点加入到集合中
        //3. 重复1-2过程直到没有后继节点，返回false
        // 时间复杂度 O(n),空间复杂度O(n)

        Map<ListNode,Integer> map = new HashMap<>();

        int index = 0;

        while (head!=null)
        {
            if (map.containsKey(head)) return true;
            map.put(head,index++);
            head = head.next;
        }

        return false;
    }

    //通过数学方法判断是否有环
    public boolean hasCycle_num(ListNode head){
        // 1. 设置两个指针，一快一慢，如果存在环，快慢指针一定会相遇;
        // 2. 设置慢指针走1步，快指针走2步(只要大于1步)
        // 3. 时间复杂度O(n), 空间发咋读O(1)
        if (head == null) return false;

        ListNode quick = head;
        ListNode slow  = head;



        slow = slow.next;
        quick  = quick.next;
        quick  = quick==null?null:quick.next;

        while (quick !=null && slow != null)
        {
            if (quick == slow) return true;
            slow = slow.next;
            quick  = quick.next;
            quick  = quick==null?null:quick.next;
        }

        return false;
    }

    //通过计算机知识解
    public boolean hasCycle_computer(ListNode head){
        //由于堆申请内存是从低往高申请的，如果后指针地址小于前指针，就一定有环
        if (head==null) return false;
        ListNode pre = head;
        ListNode cur = head.next;
        while (pre!=null&&cur!=null)
        {
            if (pre.hashCode()>cur.hashCode()) return true;
            pre = cur;
            cur = cur.next;
        }

        return false;
    }


    public static void main(String[] args) {
        Q141_1 q = new Q141_1();
        q.toString();

        System.out.println(q.hashCode());
    }




}
