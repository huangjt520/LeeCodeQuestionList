package SwordRefers2Offer;

import com.sun.corba.se.spi.ior.IORFactories;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName Offer28.
 * @Description
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * @Author 黄景棠
 * @Update 2021/12/15 上午 11:44
 * @Since
 * @Version 1.0
 **/
public class Offer28 {


    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    /**
     * @Description: 层次遍历实现判断一个二叉树是否是镜像树
     * @Author: Huang Jingtang
     * @Update: 2021/12/15  下午 12:19
     * @param root:
     * @return boolean:
     **/
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;

        //左右比较队列
        Queue<TreeNode> letfQue = new LinkedList<>();
        Queue<TreeNode> rightQue = new LinkedList<>();

        //将左右子树根节点加入左右队列
        letfQue.add(root.left);
        rightQue.add(root.right);

        while (!letfQue.isEmpty()&&!rightQue.isEmpty())
        {
            TreeNode leftNode = letfQue.remove();
            TreeNode rightNode = rightQue.remove();

            if (leftNode!=null&&rightNode!=null)
            {
                if (leftNode.val!=rightNode.val) return false;
                //如果相等就将左子树按左右节点加入到队列，右子树将右左节点加入到队列
                letfQue.add(leftNode.left);
                letfQue.add(leftNode.right);

                rightQue.add(rightNode.right);
                rightQue.add(rightNode.left);

            }else if (leftNode==null&&rightNode==null){
                continue;
            }else if (leftNode==null||rightNode==null){
                return false;
            }
        }



        return true;
    }

    /**
     * @Description: 递归实现判断二叉树是否是镜像树
     * 左边的左边与右边的右边，左边的右边与右边的左边比较
     * @Author: Huang Jingtang
     * @Update: 2021/12/15  下午 3:18
     * @param root:
     * @return boolean:
     **/
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;

        return dfs(root.left,root.right);
    }

    //递归实现
    private boolean dfs(TreeNode node,TreeNode node2){

        if (node==null&&node2==null)
        {
            return true;
        }else if (node!=null&&node2!=null)
        {
            if (node.val!=node2.val) return false;
        }else if (node==null||node2==null) {
            return false;
        }

        return dfs(node.left,node2.right)&&dfs(node.right,node2.left);


    }

    /**
     * @Description: 辅助栈+迭代实现
     * @Author: Huang Jingtang
     * @Update: 2021/12/15  下午 3:38
     * @param root:
     * @return boolean:
     **/
    public boolean isSymmetric2(TreeNode root) {
        if (root==null) return true;

        //左树栈:从右节点左右节点入栈
        Stack<TreeNode> leftStack = new Stack<>();
        //右树栈:从左节点到右节点入栈
        Stack<TreeNode> rightStack = new Stack<>();

        //左右节点入栈
        leftStack.push(root.left);
        rightStack.push(root.right);

        while (!leftStack.isEmpty()&&!rightStack.isEmpty())
        {
            TreeNode leftTreeNode = leftStack.pop();
            TreeNode rightTreeNode = rightStack.pop();

            if (leftTreeNode==null&&rightTreeNode==null) continue;
            if (leftTreeNode==null||rightTreeNode==null) return false;
            if (leftTreeNode.val!=rightTreeNode.val) return false;

            leftStack.push(leftTreeNode.right);
            leftStack.push(leftTreeNode.left);

            rightStack.push(rightTreeNode.left);
            rightStack.push(rightTreeNode.right);

        }

        return true;
    }
}
