import java.util.HashMap;
import java.util.Map;

/**
 * 383.赎金信
 * 描述：为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 *
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 *
 * 如果可以构成，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次
 *
 * 示例：
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 *
 */
public class Question383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map ransomMap = new HashMap<String,Integer>();
        // 记录 ransom 的字符和出现次数
        // 记录 magazine中在ransom相同字符出现的次数
        // 如果 magazine中字符次数小于ransom或者magazine没有ransom的字符返回false
        if(ransomNote == null) return true;
        if(magazine == null)    return false;
        String[] ransomStrList = ransomNote.split("");
        String[] magazineStrList = magazine.split("");

        for(String str : ransomStrList)
        {
            if (ransomMap.containsKey(str)) ransomMap.put(str,(Integer)ransomMap.get(str)+1);
            else ransomMap.put(str,1);
        }

        for(String str : magazineStrList)
        {
            if(!ransomMap.containsKey(str)) continue;
            ransomMap.put(str,(Integer)ransomMap.get(str)-1);
        }

        for (Object value : ransomMap.values()) {
            if ((Integer)value>0) return false;
        }

        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine){

        char[] ransomArr = ransomNote.toCharArray();
        char[] magazineArr = magazine.toCharArray();

        int[] nums = new int[26];

        for (char c : ransomArr) nums[c-'a']++;

        for(char c : magazineArr) nums[c-'a']--;

        for(int i=0;i<26;i++)
            if(nums[i]>0) return false;

        return true;



    }
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(new Question383().canConstruct2(ransomNote,magazine));

    }
}
