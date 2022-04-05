package SwordRefers2Offer;

import java.lang.management.ManagementFactory;

/**
 * @ClassName Offer55_2.平衡二叉树
 * @Description
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *  
 *
 * 限制：
 *
 * 0 <= 树的结点个数 <= 10000
 *
 * @Author 黄景棠
 * @Update 2021/12/24 下午 5:10
 * @Since
 * @Version 1.0
 **/
public class Offer55 {

    class ReNode{
        boolean isBalance;
        int deep;

        public ReNode(boolean isBalance, int deep) {
            this.isBalance = isBalance;
            this.deep = deep;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        ReNode res = dfs(root);
        return res.isBalance;
    }

    private ReNode dfs(TreeNode node){
        if (node==null) return new ReNode(true,0);

        ReNode l = dfs(node.left);
        ReNode r = dfs(node.right);
        boolean isBalance = l.isBalance&&r.isBalance&&Math.abs(l.deep-r.deep)<=1;
        int deep = l.deep>r.deep?l.deep:r.deep;
        return new ReNode(isBalance,deep+1);

    }
}
