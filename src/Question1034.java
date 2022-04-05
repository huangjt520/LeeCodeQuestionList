import java.util.*;

/**
 * @ClassName Question1034.边界着色
 * @Description TODO
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 *
 * 两个网格块属于同一 连通分量 需满足下述全部条件：
 *
 * 两个网格块颜色相同
 * 在上、下、左、右任意一个方向上相邻
 * 连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
 *
 * 在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
 * 在网格的边界上（第一行/列或最后一行/列）
 * 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。
 *示例 1：
 *
 * 输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * 输出：[[3,3],[3,2]]
 * 示例 2：
 *
 * 输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * 输出：[[1,3,3],[2,3,3]]
 * 示例 3：
 *
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * 输出：[[2,2,2],[2,1,2],[2,2,2]]
 *提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 *
 * @Author 黄景棠
 * @Update 2021/12/7 下午 5:34
 * @Since
 * @Version 1.0
 **/
public class Question1034 {

    int[][] grid;

    //方向规约 下右上左
    final int[] x = {-1,0,1,0};
    final int[] y = {0,1,0,-1};
    boolean[][] check ;
    int theColor ;

    /**
     * @Description: 递归遍历，延迟描色
     * 如何判断边界：
     * 1.如果是矩阵边界，一定是；
     * 2. 判断上下左右如果有一个不在连通集合内，就是边界
     *
     * @Author: Huang Jingtang
     * @Update: 2021/12/7  下午 5:36
     * @param grid: 网格数组
     * @param row: 第几行
     * @param col: 第几列
     * @param color: 需要的颜色
     * @return int[][]:
     **/
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid = grid;
        check = new boolean[grid.length][grid[0].length];
        theColor = color;
        //获取所有连通分量内节点
        DFS(row,col,grid[row][col]);
        //描色
        return grid;
        //返回结果


    }


    private void DFS(int row,int col,int color){

        //递归结束条件
        //1.当不连通时，结束；
        //2.当连通，但是是边界时，结束
        //标记 点已访问
        check[row][col] = true;
        //是否边界标记，四个方向走的时候重复加入结果列表
        boolean flag = false;
        int newRow;
        int newCol;

        //哪边连通往哪边递归，哪边不连通说明该节点需要加入结果列表
        for (int i =0 ;i<4;i++)
        {
            newRow = row+x[i];
            newCol = col+y[i];
            //判断连通性
            //如果连通：该方向是否检查，未检查递归，已检查不理睬
            if (isConnected(newRow,newCol,color)&&!isChecked(newRow,newCol))
                DFS(newRow,newCol,color);
            //未连通说明该节点是边界，需要加入到结果列表
            else if (!isConnected(newRow,newCol,color)&&!isChecked(newRow,newCol)) flag = true;

        }
        //描色
        if (flag) grid[row][col] = theColor;

    }

    private boolean isChecked(int row,int col)
    {
        if(row<0||row>=grid.length||col<0||col>=grid[0].length) return false;
        if (check[row][col]) return true;
        return false;
    }

    private boolean isConnected(int row, int col,int color){
        //TODO 判断是否连通,当越过边界时不连通
        if (row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]!=color) return false;
        return true;
    }





    public void print(int[][] grid){
        for (int i=0;i<grid.length;i++)
        {
            for (int j=0;j<grid[0].length;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] inputs = {{1,1,1},{1,1,1},{1,1,1}};
        int row = 1;
        int col = 1;
        int color = 2 ;

        Question1034 q = new Question1034();
        int[][] result = q.colorBorder(inputs,row,col,color);
        q.print(result);



    }
}
