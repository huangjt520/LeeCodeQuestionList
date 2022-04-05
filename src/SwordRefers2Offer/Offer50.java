package SwordRefers2Offer;

import java.util.*;

/**
 * @ClassName Offer50.第一个只出现一次的字符
 * @Description
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * @Author 黄景棠
 * @Update 2021/12/21 下午 8:02
 * @Since
 * @Version 1.0
 **/
public class Offer50 {
    private int[] frequency = new int[26];
    private int[] indexes = new int[26];


    public char firstUniqChar(String s) {
        if (s==null||s.length()==0) return ' ';

        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet();


        for (int i=0;i<chars.length;i++)
        {
            //更新序号
            if (indexes[chars[i]-'a']==0) indexes[chars[i]-'a'] = i+1;
            //更新计数
            frequency[chars[i]-'a'] ++;
            if (frequency[chars[i]-'a']==1) set.add(chars[i]);
            else set.remove(chars[i]);
        }

        int index = Integer.MAX_VALUE;
        for (char c : set)
        {
            if (indexes[c-'a']<index) index = indexes[c-'a'];
        }

        return s.length()>index?chars[index-1]:' ';
    }

    /**
     * @Description: 使用有序哈希实现第一次
     * @Author: Huang Jingtang
     * @Update: 2021/12/21  下午 8:28
     * @param s:
     * @return char:
     **/
    public char firstUniqCharByLinkMap(String s){
        if (s==null||s.length()==0) return ' ';
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++)
            map.put(chars[i],!map.containsKey(chars[i]));

        for (Map.Entry<Character,Boolean> entry:map.entrySet())
            if (entry.getValue()) return entry.getKey();

        return ' ';
    }


}
