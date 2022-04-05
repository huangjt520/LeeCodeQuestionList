import java.util.ArrayList;
import java.util.List;

/**17. 电话号码的字母组合
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
public class Question17 {

    //返回字母函数
    public List<String> backArig(String digit){
        ArrayList<String> list = new ArrayList<>();

        if(digit.length()==1&&!digit.equals("7")&&!digit.equals("9")&&!digit.equals("8"))
        {
            for(int i =0 ; i<3 ; i++)
            {
                char ch = (char)('a'+(Integer.parseInt(digit)-2)*3+i);
                list.add(new Character(ch).toString());
            }
        }else if(digit.equals("7"))
        {
            list.add("p");
            list.add("q");
            list.add("r");
            list.add("s");
        }else if(digit.equals("9"))
        {
            list.add("w");
            list.add("x");
            list.add("y");
            list.add("z");
        }else if(digit.equals("8"))
        {
            list.add("t");
            list.add("u");
            list.add("v");

        }else
            list.add("");

        return list;
    }

    public List<String> letterRecursive(String str1 ,String str2){
        List<String> list1 = null;
        List<String> list2 = null;
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1<=1) list1 = backArig(str1);
        else if(len1%2>0)
            list1 = letterRecursive(str1.substring(0,len1/2),str1.substring(len1/2));
        else if(len1%2==0)
            list1 = letterRecursive(str1.substring(0,len1/2),str1.substring(len1/2));

        if(len2<=1) list2 = backArig(str2);
        else if(len2%2>0)
            list2 = letterRecursive(str2.substring(0,len2/2),str2.substring(len2/2));
        else if(len2%2==0)
            list2 = letterRecursive(str2.substring(0,len2/2),str2.substring(len2/2));

        List<String> result = new ArrayList<>();
        for(String strr1:list1)
        {

            for(String strr2:list2)
            {
                StringBuilder stringBuilder =  new StringBuilder();
                stringBuilder.append(strr1);
                stringBuilder.append(strr2);
                result.add(stringBuilder.toString());
            }
        }


        return  result;
    }



    public List<String> letterCombinations(String digits) {
        //递归思路
        // 可以看做是几个数字可以二分，然后二分的组合再组合
        List<String> list = letterRecursive(digits,"");
        if(list.size()==1)
            list.remove(0);

        return list;
    }

    public static void main(String[] args) {
        Question17 question17 = new Question17();
        System.out.println(question17.letterCombinations("8"));
    }
}
