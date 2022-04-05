
/** 445. 两数相加 II
 * 标签：加法模板，链表,单链表反转,头插法
 * 描述：
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 示例1：
 *
 *
 *
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 *  
 *
 * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
 *
 */
public class Question445 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public class Stack{
        private int  index = -1 ;
        private int[] arrays = null ;
        Stack(int length){
            arrays = new int[length];
        }

        public int getLength() {
            return arrays.length;
        }
        public boolean push(int num){
            if(index>=arrays.length) return false;
            else arrays[++index] = num;
            return true;
        }
        public int get(){
            if(index<0) return -1;
            else return arrays[index];
        }

        public int remove(){
            if(index<0) return -1;
            else
            {
                index = index-1;
                return arrays[index+1];
            }
        }
        public boolean isEmpty(){
            if(index==-1) return true;
            else return false;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1. 确定加数1为l1,加数2为l2,进位carry=[0,1]
        //2. 确定顺序：l1、l2为正序链表，需要反转变成逆序运算，可以用栈的方式实现
        //3. 确定终止条件：l1==null&&l2==null&&carry==0；
        //4. 结果存储：用链表头插法的形式存储

        /* 利用栈实现反转链表功能
        //定义进位和辅助栈
        int carry = 0 ;
        //定义辅助栈
        Stack stack1 = new Stack(100);
        Stack stack2 = new Stack(100);
        //定义结果头部
        ListNode fix = null ;
        ListNode pre = null ;

        ListNode pre1 = l1;
        ListNode pre2 = l2;

        //链表数据反转(压入栈中)
        while(pre1!=null||pre2!=null)
        {
            if(pre1!=null)
            {
                stack1.push(pre1.val);
                pre1 = pre1.next;
            }
            if(pre2!=null)
            {
                stack2.push(pre2.val);
                pre2 = pre2.next;
            }
        }
        //根据终止条件的反条件来进行过程
        while(!stack1.isEmpty()||!stack2.isEmpty()||carry!=0)
        {
            //进行结果运算顺便移位
            if(!stack1.isEmpty()) carry +=stack1.remove();
            if(!stack2.isEmpty()) carry +=stack2.remove();

            //存储结果
            pre = new ListNode(carry%10);
            pre.next = fix;
            fix = pre;

            //处理进位
            carry /=10;
        }

        return pre;

         */
        /* 直接反转链表 */
        //将l1,l2链表反转
        l1 = reverse(l1);
        l2 = reverse(l2);
        //定义进位
        int carry = 0;
        // 设置头插法节点
        ListNode curr = null ;
        ListNode pre = null;
        //根据过程终止条件的反条件进行过程
        while(l1!=null||l2!=null||carry!=0)
        {
            //计算结果顺便移位
            if(l1!=null)
            {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2!=null)
            {
                carry += l2.val;
                l2 = l2.next;
            }
            //设置节点存储结果
            pre = new ListNode(carry%10);
            pre.next = curr;
            curr = pre;
            //处理进位
            carry /=10 ;
        }
        //如果最后一次计算有进位，增加新节点
        if(carry==1)
        {
            pre = new ListNode(1);
            pre.next = curr;
        }

        return pre;

    }

    //链表反转函数
    public ListNode reverse(ListNode ans){
        /* 反转思想
            只要局部两个节点反转指针，那么最后全部链表反转。
            前置节点pre,当前节点curr,后置节点next
            如果将链表前置一个节点,那么反转过程就是：
            1. 获得后置节点引用next=curr.next;
            2. 当前节点指针断开指向前置节点curr.next=pre;
            3. 前置节点引用指向当前节点 pre = curr;
            重复1-3过程直到当前节点为空
         */
        //前置节点
        ListNode pre = null;
        //当前节点
        ListNode curr = ans;
        //下一个节点
        ListNode next = null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = pre;
            pre = curr;

            //移动
            curr = next;
        }
        return pre;


    }

}
