package SwordRefers2Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Offer13.机器人的运动范围
 * @Description
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * @Author 黄景棠
 * @Update 2021/12/13 下午 6:38
 * @Since
 * @Version 1.0
 **/
public class Offer13 {
    //右下左上
    int m,n,k;
    int[][] coordinates = {{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] marked;
    public int movingCount(int m, int n, int k) {
        marked = new boolean[m][n];
        this.m = m;
        this.n = n;
        this.k = k;

        //广度优先
        //return bfs();

        //dfs
        return dfs(0,0);
    }

    //广度优先遍历
    private int bfs(){

        Queue<Integer> queuex = new LinkedList<>();
        Queue<Integer> queuey = new LinkedList<>();

        queuex.add(0);
        queuey.add(0);
        marked[0][0] = true;
        int count = 0;

        while (!queuex.isEmpty())
        {
            int x = queuex.remove();
            int y = queuey.remove();
            count ++;
            for (int i=0;i<4;i++)
            {
                int dx = x+coordinates[i][0];
                int dy = y + coordinates[i][1];

                if (dx>=0&&dx<m&&dy>=0&&dy<n&&!marked[dx][dy]&&(countBit(dx)+countBit(dy))<=k)
                {
                    marked[dx][dy] = true;
                    queuex.add(dx);
                    queuey.add(dy);
                }
            }
        }

        return count;

    }


    //深度优先算法DFS遍历，
    private int dfs(int i,int j){

        if ((countBit(i)+countBit(j))>k) return 0;

        marked[i][j] = true;

        int result = 1 ;
        for (int q=0;q<4;q++)
        {
            int dx = i+coordinates[q][0];
            int dy = j+coordinates[q][1];
            if (dx>=0&&dx<m&&dy>=0&&dy<n&&!marked[dx][dy])
                result += dfs(dx,dy);
        }
        return result;

    }

    private int countBit(int v){
        int result = 0;
        while (v!=0)
        {
            result +=v%10;
            v=v/10;
        }
        return result;
    }

    public static void main(String[] args) {
        Offer13 o = new Offer13();
        System.out.println(o.movingCount(1,2,1));
    }
}
