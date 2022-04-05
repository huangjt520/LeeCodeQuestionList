package SwordRefers2Offer;

/**
 * @ClassName Offer04。二维数组中的查找
 * @Description TODO
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *  
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 * @Author 黄景棠
 * @Update 2021/12/8 下午 5:52
 * @Since
 * @Version 1.0
 **/
public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix==null) return false;
        int rowLen = matrix.length;
        if (rowLen==0) return false;
        int colLen = matrix[0].length;
        if (colLen==0) return false;


        int row = 0;
        int col = colLen-1;

        //剔除列
        while (matrix[row][col]>target)
        {
            col--;
            if (col<0) return false;
        }
        while (matrix[row][col]<target)
        {
            row++;
            if (row>=rowLen)    return false;
        }

        for (int i = row;i<rowLen;i++ )
        {
            for (int j = col;j>=0;j--)
                if (matrix[i][j]==target) return true;

        }

        return false;
    }

    //单空格走法,从左下和右上角都能排除范围
    //左下角开始，如果目标数比它大，走右边；如果目标数比它小，走上边找
    //特殊的，注意判空和处理边界问题
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        //判空
        if (matrix==null)   return false;
        int rowLen = matrix.length;
        if (rowLen==0)  return false;
        int colLen = matrix[0].length;
        if (colLen==0)  return false;

        //从左下角开始找
        int row = rowLen-1;
        int col = 0;

        //找值
        while (row>=0&&col<colLen)
        {
            //如果找到，返回
            if (matrix[row][col]==target) return true;
            //如果目标值比其小，往上找，行减一
            else if (matrix[row][col]>target)  row--;
            //如果目标值比其大，往右找，列加一
            else col++;
        }

        //处理边界
        if (row<0)
        {
            row++;
            while (col<colLen)
            {
                if (matrix[row][col]==target) return true;
                if (matrix[row][col]>target) return false;
                col++;
            }
        }else if (col==colLen)
        {
            col--;
            while (row>=0)
            {
                if (matrix[row][col]==target) return true;
                if (matrix[row][col]<target) return false;
                row--;
            }
        }

        return false;

    }


}
