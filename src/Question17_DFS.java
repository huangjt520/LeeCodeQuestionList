import java.util.ArrayList;
import java.util.List;

/**17. 电话号码的字母组合
 * 标签： 树， 树的深度度优先遍历实现
 *描述：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 */
public class Question17_DFS {
    //结果存储
    ArrayList<String> result = new ArrayList<>();
    //过程字符串拼接存储
    StringBuilder stringBuilder = new StringBuilder();

    //字符映射
    String[] strMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    void backTrack(char[] digits,int index)
    {
        //递归结束条件，叶子节点构造完成
        if(index == digits.length)
        {
            result.add(stringBuilder.toString());
            return;
        }

        //从map 取str
        int k = digits[index] - '0';
        String str = strMap[k];
        for(int i =0;i<str.length();i++)
        {
            //将字符压入到工具栈
            stringBuilder.append(str.charAt(i));
            backTrack(digits,index+1);
            //回溯操作:回溯到上一节点，也就是stringBuilder删除本次节点
            stringBuilder.deleteCharAt(index);
        }
    }

    public List<String> letterCombinations(String digits){

        if(digits.length()==0 || digits==null || digits.equals("1")||digits.equals("0"))
            return result;
        char[] chars = digits.toCharArray();
        backTrack(chars,0);
        return result;
    }

    public static void main(String[] args) {
        Question17_DFS q = new Question17_DFS();
        System.out.println(q.letterCombinations("234"));
    }
}
