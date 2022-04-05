package SwordRefers2Offer;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName Offer68_1
 * @Description
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 *例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *

 * @Author 黄景棠
 * @Update 2022/1/20 下午 4:09
 * @Since
 * @Version 1.0
 **/
public class Offer68_1 {

    //搜索栈
    Deque<TreeNode> pStack = new LinkedList<>();
    Deque<TreeNode> qStack = new LinkedList<>();


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DFSSearch(root,p,pStack);
        DFSSearch(root,q,qStack);
        TreeNode preNode = pStack.pop();
        qStack.pop();
        TreeNode curNode;
        while (!pStack.isEmpty()&&!qStack.isEmpty())
        {
            curNode = pStack.pop();
            if (curNode.val == qStack.pop().val)    preNode = curNode;
            else return preNode;
        }


        return preNode;
    }

    private boolean DFSSearch(TreeNode SubRoot,TreeNode node,Deque<TreeNode> stack){
        if (SubRoot == null) return false;
        if (SubRoot.val==node.val||DFSSearch(SubRoot.left,node,stack)||DFSSearch(SubRoot.right,node,stack))
        {
            stack.push(SubRoot);
            return true;
        }

        return false;

    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){

        TreeNode min = p.val>q.val?q:p;
        TreeNode max = p.val>q.val?p:q;

        for (TreeNode node = root;node!=null;)
        {
            if (node.val>max.val) node = node.left;
            else if (node.val<min.val) node = node.right;
            else return node;
        }

        return null;
    }

    private TreeNode DFS(TreeNode node,TreeNode min,TreeNode max){
        if (node.val>max.val) return DFS(node.left,min,max);
        if (node.val<min.val) return DFS(node.right,min,max);
        return node;
    }



    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
