package SwordRefers2Offer;

/**
 * @author huangjt
 * @ClassName: Offer26.树的子结构
 * @Description:
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 通过次数188,582提交次数403,168
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2022/3/4 11:46
 */
public class Offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null||B==null) return false;

        return recure(A,B);

    }

    public boolean recure(TreeNode A,TreeNode B){
        //先序遍历，首先以根节点是否相等
        //2. 判断左子树是不是
        // 3. 判断右子树是不是
        if (B==null) return true;
        if (A==null) return false;
        if (treeEqual(A,B)) return true;

        return recure(A.left,B)||recure(A.right,B);
    }

    public boolean treeEqual(TreeNode A,TreeNode B){
        if (B==null) return true;
        if (A==null||A.val!=B.val) return false;

        return treeEqual(A.left,B.left)&&treeEqual(A.right,B.right);

    }
}
