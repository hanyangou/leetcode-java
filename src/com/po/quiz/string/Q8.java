package com.po.quiz.string;

/***
 * discards all leading whitespaces
 * sign of the number
 * deal with overflow
 * invalid input
 */
public class Q8 {
    public int myAtoi(String str) {
        //corner case

        int ans = 0;
        int sign = 1;
        char[] cs = str.toCharArray();
        int idx = 0;
        while (idx < str.length() && cs[idx] == ' ') idx++;
        if(idx < str.length() && cs[idx] == '+' || cs[idx] == '-'){
            sign = cs[idx] == '+' ? 1 : -1;
            idx++;
        }
        //leading zero?
        int magic = Integer.MAX_VALUE % 10;
        int threshold = Integer.MAX_VALUE / 10;
        while (idx < str.length() && cs[idx] >= '0' && cs[idx] <= '9'){
            if(ans > threshold || (ans == threshold && cs[idx] - '0' > magic)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + cs[idx] - '0';
            idx++;
        }
        return ans * sign;
    }
}

/***
 public int myAtoi(String str) {
 if(str == null || str.trim().length() == 0 ) return 0;
 int idx = 0;
 while (str.charAt(idx) == ' ') idx++;
 int sign = 1;
 if(str.charAt(idx) == '+' || str.charAt(idx) == '-') {
 sign = str.charAt(idx) == '+' ? 1 : -1;
 idx++;
 }
 int base = 0;
 while (idx < str.length() && str.charAt(idx) >= '0' && str.charAt(idx) <= '9'){
 if(base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE /10 && str.charAt(idx) - '0' > 7)){//-2147483648 to 2147483647
 if(sign == 1) return Integer.MAX_VALUE;
 else return Integer.MIN_VALUE;
 }
 base = base * 10 + (str.charAt(idx) - '0');
 idx++;
 }
 return base * sign;
 }
***/