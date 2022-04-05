/**
 * @ClassName Question709
 * @Description TODO
 * @Author 黄景棠
 * @Update 2021/12/12 上午 11:53
 * @Since
 * @Version 1.0
 **/
public class Question709 {

    public String toLowerCase(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();

        for (int i=0,len=chars.length;i<len;i++)
        {

            if(chars[i]>='A'&&chars[i]<='Z')    builder.append((char) ('a'+chars[i]-'A'));
            else builder.append(chars[i]);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Question709 q = new Question709();
        System.out.println(q.toLowerCase("Hello"));
    }
}
