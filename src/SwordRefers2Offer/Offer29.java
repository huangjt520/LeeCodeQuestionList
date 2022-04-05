package SwordRefers2Offer;

/**
 * @ClassName Offer29.顺时针打印矩阵
 * @Description
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * @Author 黄景棠
 * @Update 2021/12/16 上午 11:05
 * @Since
 * @Version 1.0
 **/
public class Offer29 {
    //boolean[][] marked;
    //方位标记 右下左上
    //int[] x = {0,1,0,-1};
    //int[] y = {1,0,-1,0};
    int rowLen;
    int colLen;
    //int[][] matrix;
    //public int[] spiralOrder(int[][] matrix) {
    //    //判空
    //    if (matrix==null) return null;
    //    this.rowLen = matrix.length;
    //    if (this.rowLen==0) return new int[0];
    //    this.colLen = matrix[0].length;
    //    if (this.colLen==0) return new int[0];
    //
    //    //初始化
    //    marked = new boolean[rowLen][colLen];
    //    this.matrix = matrix;
    //
    //    int index = 0;
    //    int[] result = new int[rowLen*colLen];
    //
    //    int row = 0 , col = 0;
    //    int direction = 0;
    //
    //    while (index<result.length)
    //    {
    //        //记录当前节点
    //        result[index++] = matrix[row][col];
    //        marked[row][col] = true;
    //
    //        //试探下一节点，如果可达，继续到达下一节点，如果不可达，转换方向
    //        while(index<result.length&&!isRechable(row+this.x[direction],col+this.y[direction]))
    //        {
    //            direction = (direction+1)%4;
    //        }
    //
    //        row = row+this.x[direction];
    //        col = col+this.y[direction];
    //
    //    }
    //
    //    return result;
    //
    //}
    //
    //private boolean isRechable(int row,int col){
    //    if (row<0||row>=rowLen||col<0||col>=colLen) return false;
    //    if (marked[row][col]) return false;
    //    return true;
    //}


    //优化:只需要和边界比较，更新边界
    public int[] spiralOrder1(int[][] matrix) {
        if (matrix==null) return null;
        this.rowLen = matrix.length;
        if (this.rowLen==0) return new int[0];
        this.colLen = matrix[0].length;
        if (this.colLen==0) return new int[0];

        int index = 0;
        int[] result = new int[rowLen*colLen];

        //边界数组 右下左上
        int l = 0; //左边界
        int r = colLen-1; //有边界
        int t = 0; //上边界
        int b = rowLen-1; //下边界

        while (true)
        {
            //从左到右
            for (int i=l;i<=r;i++) result[index++] = matrix[t][i];
            //收束上边界
            if (++t>b) break;
            //从上到下
            for (int i=t;i<=b;i++) result[index++] = matrix[i][r];
            //收束右边界
            if (--r<l) break;
            //从右到左
            for (int i=r;i>=l;i--) result[index++] = matrix[b][i];
            //s收束下边界
            if (--b<t) break;
            //从下到上
            for (int i=b;i>=t;i--) result[index++] = matrix[i][l];
            //收束左边界
            if (++l>r) break;
        }

        return result;

    }

    public static void main(String[] args) {
        Offer29 o = new Offer29();

    }


}
