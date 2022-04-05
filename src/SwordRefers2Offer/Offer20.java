package SwordRefers2Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjt
 * @ClassName: Offer20.表示数值的字符串
 * @Description:
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 数值（按顺序）可以分成以下几个部分：
 *
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 *
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 *
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 *  
 *
 * 示例 1：
 *
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "    .1  "
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 *
 * @Date 2022/3/2 9:42
 */
public class Offer20 {
    
    //有限状态机
    public boolean isNumber(String s) {

        Map[] States = {
                new HashMap(){{put(' ', 0);put('s',1);put('d',2);put('.',4);}}, //0状态,前置空格状态
                new HashMap() {{put('d',2);put('.',4);}},                       //1状态，符号状态
                new HashMap()   {{put('d',2);put('e',5);put('.',3);put(' ',8);}},//2状态，整数状态
                new HashMap() {{put('d',3);put('e',5);put(' ',8);}},             //3状态，归档小数点状态
                new HashMap() {{put('d',3);}}   ,                                //4状态，前无数字小数点状态
                new HashMap()  {{put('d',7);put('s',6);}},                       //5状态，E，e状态
                new HashMap()   {{put('d',7);}}   ,                             // 6状态，Ee后加符号状态
                new HashMap()   {{put(' ',8);put('d',7);}}       ,              //7状态，Ee后加整数状态
                new HashMap()   {{put(' ',8);}}                                 //8状态，后置空格状态

        };
        char c = ' ';
        int p = 0;
        for (char c1 : s.toCharArray()) {

            if (c1 ==' '){
                c = ' ';
            }else if (c1=='.'){
                c = '.';
            }else if (c1=='E'||c1=='e'){
                c = 'e';
            }else if (c1=='+'||c1=='-'){
                c = 's';
            }else if (c1>='0'&&c1<='9'){
                c = 'd';
            }else {
                c='?';
            }

            if (!States[p].containsKey(c)) return false;
            p = (int)States[p].get(c);

        }

        return p==2||p==3||p==7||p==8;
    }



}


