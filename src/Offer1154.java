import java.util.Arrays;

/**
 * @ClassName Offer1154.一年中的第几天
 * @Description
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 * 示例 3：
 *
 * 输入：date = "2003-03-01"
 * 输出：60
 * 示例 4：
 *
 * 输入：date = "2004-03-01"
 * 输出：61
 *  
 *
 * 提示：
 *
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 *
 * @Author 黄景棠
 * @Update 2021/12/21 下午 5:03
 * @Since
 * @Version 1.0
 **/
public class Offer1154 {
    static final int[] dataMap = {31,28,31,30,31,30,31,31,30,31,30,31};
    static int[] f = new int[13];
    static {
        for (int i=1;i<13;i++){
            f[i]  = f[i-1] + dataMap[i-1];
        }
    }
    public int dayOfYear(String date) {
        if (date == null) return -1;
        String[] list = date.split("-");
        int[] array = new int[3];
        array[0] = Integer.parseInt(list[0]);
        array[1] = Integer.parseInt(list[1]);
        array[2] = Integer.parseInt(list[2]);

        boolean isRun = array[0]%4==0;
        int res = f[array[1]-1] + array[2];

        return isRun&&array[1]>2?res+1:res;


    }

    public static void main(String[] args) {
        Offer1154 o = new Offer1154();
        System.out.println(o.dayOfYear("2004-03-01"));
    }
}
