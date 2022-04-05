package SwordRefers2Offer;

import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * @ClassName Offer32.
 * @Description TODO
 * @Author 黄景棠
 * @Update 2021/12/21 下午 7:08
 * @Since
 * @Version 1.0
 **/
public class Offer32 {
    /**
     * @Description: 用两个队列实现区别层次
     * @Author: Huang Jingtang
     * @Update: 2021/12/21  下午 7:41
     * @param root:
     * @return java.util.List<java.util.List<java.lang.Integer>>:
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp ;
        TreeNode nodeTemp;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        Queue<TreeNode> queueTemp ;

        q1.offer(root);

        while (!q1.isEmpty())
        {
            temp = new ArrayList<>();
            while (!q1.isEmpty())
            {
                nodeTemp = q1.peek();
                if (nodeTemp==null) continue;
                temp.add(nodeTemp.val);
                q2.offer(nodeTemp.left);
                q2.offer(nodeTemp.right);
            }
            res.add(temp);
            queueTemp = q2;
            q2 = q1;
            q1 = queueTemp;
        }

        res.remove(res.size()-1);
        return res;
    }

    /**
     * @Description: 用一个队列和记录顺序实现分层
     * @Author: Huang Jingtang
     * @Update: 2021/12/21  下午 7:42
     * @param root:
     * @return java.util.List<java.util.List<java.lang.Integer>>:
     **/
    public List<List<Integer>> levelOrderByIndex(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> listTemp;
        TreeNode    nodeTemp;
        deque.add(root);

        while (!deque.isEmpty())
        {
            listTemp = new ArrayList<>();
            for (int i=0,len=deque.size();i<len;i++)
            {
                nodeTemp = deque.pop();
                listTemp.add(nodeTemp.val);
                if (nodeTemp.left!=null) deque.add(nodeTemp.left);
                if (nodeTemp.right!=null) deque.add(nodeTemp.right);

            }
            res.add(listTemp);
        }

        return res;
    }
}
