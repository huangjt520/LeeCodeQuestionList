package SwordRefers2Offer;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.sql.Statement;
import java.util.*;

/**
 * @ClassName Offer58_1.翻转单词顺序
 * @Description
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @Author 黄景棠
 * @Update 2021/12/23 下午 6:12
 * @Since
 * @Version 1.0
 **/
public class Offer58_1 {

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();
        Deque<String> list = new ArrayDeque<>();
        for(int i=0,len=s.length();i<len;)
        {
            StringBuilder tm = new StringBuilder();
            while (i<len&&chars[i]==' ') i++;
            while (i<len&&chars[i]!=' ')
                tm.append(chars[i++]);

            if (tm.length()>0)  list.push(tm.toString());

        }

        String res = String.join(" ",list);
        return res;

    }

    public static void main(String[] args) {


        Offer58_1 o = new Offer58_1();
        System.out.println(o.reverseWords("the sky is blue"));
    }
}
