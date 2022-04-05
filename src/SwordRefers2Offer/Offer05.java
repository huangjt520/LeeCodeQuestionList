package SwordRefers2Offer;

/**
 * @ClassName Offer05.替换空格
 * @Description
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 * @Author 黄景棠
 * @Update 2021/12/12 下午 12:42
 * @Since
 * @Version 1.0
 **/
public class Offer05 {
    public String replaceSpace(String s) {

        if (s==null) return null;
        char[] chars = s.toCharArray();
        int len = chars.length;
        int count =0;
        for (int i=0;i<len;i++)
            if (chars[i]==' ') count++;

        char[] result = new char[len+2*count];


        for (int i=0,j=0;i<len;i++)
        {
            if (chars[i]==' ')
            {
                result[j] = '%';
                result[j+1] = '2';
                result[j+2] = '0';
                j +=2;
            }else {
                result[j] = chars[i];
            }
            j++;
        }

        return new String(result);

    }

    public static void main(String[] args) {
        Offer05 f = new Offer05();
        System.out.println(f.replaceSpace("We are happy."));
    }
}
