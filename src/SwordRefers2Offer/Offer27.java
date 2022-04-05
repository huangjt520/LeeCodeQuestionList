package SwordRefers2Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Offer27.二叉树的镜像
 * @Description
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * @Author 黄景棠
 * @Update 2021/12/15 上午 10:40
 * @Since
 * @Version 1.0
 **/
public class Offer27 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //层序遍历，队列实现
    public TreeNode mirrorTree(TreeNode root) {

        if (root==null) return null;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty())
        {

            //交换左右子树
            TreeNode node = queue.remove();
            if (node==null) continue;
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            //将交换后的左右子树加入队列
            queue.add(node.left);
            queue.add(node.right);

        }

        return root;

    }

    //递归实现
    public TreeNode mirrorTree1(TreeNode root){

        if (root==null) return null;

        TreeNode temp = root.left;
        root.left = mirrorTree1(root.right);
        root.right = mirrorTree1(temp);

        return root;

    }


}
