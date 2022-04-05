package SwordRefers2Offer;

/**
 * @ClassName Offer12.矩阵中的路径
 * @Description
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）
 *
 * @Author 黄景棠
 * @Update 2021/12/13 下午 4:52
 * @Since
 * @Version 1.0
 **/
public class Offer12 {
    //位标，右下左上
    int[] x = {0,1,0,-1};
    int[] y = {1,0,-1,0};
    char[][] board;
    char[] words;
    int maxDeep;
    public boolean exist(char[][] board, String word){
        //判空
        if (board==null) return false;
        int len1 = board.length;
        if (len1==0) return false;
        int len2 = board[0].length;
        if (len2==0) return false;
        if (word==null) return false;

        //初始化
        this.board = board;
        this.words = word.toCharArray();
        maxDeep = word.length()-1;

        //遍历每个结点
        for (int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[0].length;j++)
            {
                if (dfs(0,i,j)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int index,int row,int col){

        //越界退出循环
        if (row<0||col<0||row>=board.length||col>=board[0].length) return false;
        //不相等退出循环
        if (board[row][col]!=words[index]) return false;
        //成功退出循环
        if (index==maxDeep)  return true;

        //相等处理
        //由于这个问题是典型的回溯问题，可以用感染的方式标注访问印记，反正最后不相等的时候还会被恢复回来
        //感染当前坐标

        board[row][col] = ' ';

        for (int i=0;i<4;i++)
        {
            //剪枝
            int dx = row+x[i];
            int dy = col+y[i];
            if (dx<0||dy<0||dx>=board.length||dy>=board[0].length) continue;
            //感染点不访问
            if (board[dx][dy]==' ') continue;
            //题目特殊，控制函数体返回
            if (dfs(index+1,dx,dy)) return true;
        }
        //最后没返回 就是false，需要回溯
        //回溯：将感染点恢复
        board[row][col] = words[index];
        return false;

    }

    public static void main(String[] args) {
        char[][] board = {{'a','a'}};
        String word = "aa";
        Offer12 o = new Offer12();
        System.out.println(o.exist(board,word));
    }


}
