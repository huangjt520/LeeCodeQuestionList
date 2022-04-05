package SwordRefers2Offer;

import java.util.*;

/**
 * @author huangjt
 * @ClassName: Offer32_2.从上到下打印二叉树 II
 * @Description:
 *请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2022/3/6 10:40
 */
public class Offer32_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        //
        //通过两个栈实现分层以及逆序

        if (root==null) return new ArrayList<List<Integer>>();

        //通过两个栈
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        Stack<TreeNode> stackTemp;

        List<List<Integer>> res = new ArrayList<>();

        //标记层次
        int gradient = 1;
        stack.push(root);

        while (!stack.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            boolean isOdd = gradient%2==1?true:false;

            for (int i=0,len=stack.size();i<len;i++){

                TreeNode treeNode = stack.pop();
                temp.add(treeNode.val);
                //如果当前层是单层，从左往右压，如果是双层，从右往左压
                if (isOdd){

                    if (treeNode.left != null) stack2.push(treeNode.left);
                    if (treeNode.right != null) stack2.push(treeNode.right);
                }else{
                    if (treeNode.right != null) stack2.push(treeNode.right);
                    if (treeNode.left != null) stack2.push(treeNode.left);
                }

            }

            gradient++;
            stackTemp = stack;
            stack = stack2;
            stack2 = stackTemp;
            res.add(temp);
        }



        return res;




    }
}
