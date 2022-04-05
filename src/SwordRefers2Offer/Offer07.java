package SwordRefers2Offer;



/**
 * @ClassName Offer07.重建二叉树
 * @Description
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * @Author 黄景棠
 * @Update 2021/12/13 下午 8:12
 * @Since
 * @Version 1.0
 **/
public class Offer07 {
    int[] preorder;
    int[] inorder;


    //前序找到根节点
    //中序找到左右子树
    //递归安排左右子树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //判空
        if (preorder==null||inorder==null||preorder.length!=inorder.length) return null;

        //初始化
        this.preorder = preorder;
        this.inorder = inorder;

        return buildNode(0,preorder.length-1,0,inorder.length-1);

    }

    private TreeNode buildNode(int pStart,int pEnd,int iStart,int iEnd){

        if (pStart>pEnd||iStart>iEnd) return null;
        //找到根节点
        int root = preorder[pStart];

        //在中序中找到左右子树
        int index = iStart;
        for (int i=iStart;i<=iEnd;i++)
        {
            if (inorder[i]==root)
            {
                index=i;
                break;
            }
        }

        //左右子树长度
        int lLenth = index - iStart;
        int rLenth = iEnd - index;

        //左右子树前序
        int newleftTreePStart = pStart+1;
        int newleftTreePEnd = newleftTreePStart + lLenth-1;

        int newRigthTreePEnd = pEnd;
        int newRigthTreePStart = newRigthTreePEnd - rLenth +1;

        //左右子树中序
        int newleftTreeMidStart = iStart;
        int newleftTreeMidEnd = index-1;

        int newRightTreeMidStart = index +1;
        int newRightTreeMidEnd = iEnd;

        //构造树
        //构造子树根节点
        TreeNode node = new TreeNode(root);
        //递归构建左右子树
        if (lLenth>0) node.left = buildNode(newleftTreePStart,newleftTreePEnd,newleftTreeMidStart,newleftTreeMidEnd);
        if (rLenth>0) node.right = buildNode(newRigthTreePStart,newRigthTreePEnd,newRightTreeMidStart,newRightTreeMidEnd);

        return node;




    }

    public void printNode(TreeNode node){
        if (node==null) return ;
        printNode(node.left);
        System.out.print(node.val+"-");
        printNode(node.right);

    }


    public static void main(String[] args) {
        Offer07 o = new Offer07();
        int[] pre = {1,2,3};
        int[] mid = {2,3,1};
        TreeNode root =  o.buildTree(pre,mid);
        o.printNode(root);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

