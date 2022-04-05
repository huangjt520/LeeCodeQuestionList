package SwordRefers2Offer;

/**
 * @ClassName Offer54.二叉搜索树的第k大节点
 * @Description
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @Author 黄景棠
 * @Update 2021/12/23 下午 8:44
 * @Since
 * @Version 1.0
 **/
public class Offer54 {
    int k ;
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return -1;
        this.k = k;

        return dfs(root);

    }

    private int dfs(TreeNode node){
        if (node==null) return Integer.MIN_VALUE;

        int r = dfs(node.right);
        if (r>Integer.MIN_VALUE) return r;
        k--;
        if (k==0) return node.val;
        int l = dfs(node.left);
        if (l>Integer.MIN_VALUE) return l;

        return Integer.MIN_VALUE;

    }
}
