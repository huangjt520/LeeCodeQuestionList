package SwordRefers2Offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Offer55-1. 二叉树的深度
 * @Description
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * @Author 黄景棠
 * @Update 2021/12/21 下午 8:39
 * @Since
 * @Version 1.0
 **/
public class Offer55_1 {
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root==null) return res;
        Deque<TreeNode> deque = new LinkedList();
        TreeNode temp;

        deque.add(root);

        while (!deque.isEmpty())
        {
            res++;
            for (int i=0,len=deque.size();i<len;i++)
            {
                temp = deque.pop();
                if (temp.left!=null) deque.add(temp.left);
                if (temp.right!=null) deque.add(temp.right);
            }
        }

        return res;

    }

    /**
     * @Description: 递归实现求解
     * @Author: Huang Jingtang
     * @Update: 2021/12/21  下午 8:47
     * @param root:
     * @return int:
     **/
    public int maxDepthByDFS(TreeNode root){
        if (root == null) return 0;
        int lmax = maxDepthByDFS(root.left) + 1;
        int rmax = maxDepthByDFS(root.right) + 1;

        return lmax>rmax?lmax:rmax;

    }

}
