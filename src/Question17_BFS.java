import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**17. 电话号码的字母组合
 * 标签： 树， 树的广度优先遍历实现
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question17_BFS {
    //结果存储
    LinkedList<String> result = new LinkedList<>();
    //过程字符串拼接存储
    StringBuilder stringBuilder = new StringBuilder();

    //字符映射
    String[] strMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    void queneBFS(char[] digits,int index){

        if(index==0)
        {
            int k = digits[index] - '0';
            String str = strMap[k];
            for(int i =0 ; i<str.length();i++)
                result.add(str.substring(i,i+1));
        }
        //当取第一个字母时
        if(index>0)
        {
            if(index == digits.length)
                return;
            //取map
            int k = digits[index] - '0';
            String str = strMap[k];
            //出队列组合再进队列
            //出队列数
            int queLen = result.size();

            for(int i=0 ; i<queLen;i++)
            {
                //出队列
                String temStr = result.removeFirst();
                stringBuilder.append(temStr);
                //拼接
                for(int j=0;j<str.length();j++)
                {
                    //拼接
                    stringBuilder.append(str.charAt(j));
                    //进队列
                    result.add(stringBuilder.toString());
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }
                //清空工具类stringBuilder
                stringBuilder = new StringBuilder();
            }
        }
        queneBFS(digits,index+1);




    }

    public List<String> letterCombinations(String digits){

        if(digits.length()==0 || digits==null || digits.equals("1")||digits.equals("0"))
            return result;
        char[] chars = digits.toCharArray();
        queneBFS(chars,0);
        return result;
    }

    public static void main(String[] args) {
        Question17_BFS qestion = new Question17_BFS();
        System.out.println(qestion.letterCombinations("234"));
    }

}
