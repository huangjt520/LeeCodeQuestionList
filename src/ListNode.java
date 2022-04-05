/**
 * @author huangjt
 * @ClassName: LinkNode
 * @Description:
 * @Date 2022/3/1 14:11
 */
public class ListNode {
    ListNode next;
    Integer data;

    public ListNode(ListNode next, Integer data) {
        this.next = next;
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
