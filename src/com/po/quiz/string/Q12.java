package com.po.quiz.string;

import java.util.HashMap;
import java.util.Map;

/***
 * I V X L D M
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * thought: mod by biggest one first
 *
 *
 * range : 1 - 3999
 */
public class Q12 {
    public String intToRoman(int num) {
        Map<Integer, String> mapper = new HashMap<>();
        mapper.put(1, "I");
        mapper.put(4, "IV");
        mapper.put(5, "V");
        mapper.put(9, "IX");
        mapper.put(10, "X");
        mapper.put(40, "XL");
        mapper.put(50, "L");
        mapper.put(90, "XC");
        mapper.put(100, "C");
        mapper.put(400, "CD");
        mapper.put(500, "D");
        mapper.put(900, "CM");
        mapper.put(1000, "M");
        StringBuilder sb = new StringBuilder();

        while (num > 0){
            if(num >= 1000) {
                sb.append(mapper.get(1000));
                num -= 1000;
            } else if(num >= 900){
                sb.append(mapper.get(900));
                num -= 900;
            } else if(num >= 500) {
                sb.append(mapper.get(500));
                num -= 500;
            } else if(num >= 400) {
                sb.append(mapper.get(400));
                num -= 400;
            } else if(num >= 100) {
                sb.append(mapper.get(100));
                num -= 100;
            } else if(num >= 90) {
                sb.append(mapper.get(90));
                num -= 90;
            } else if(num >= 50) {
                sb.append(mapper.get(50));
                num -= 50;
            } else if(num >= 40) {
                sb.append(mapper.get(40));
                num -= 40;
            } else if(num >= 10) {
                sb.append(mapper.get(10));
                num -= 10;
            } else if(num >= 9) {
                sb.append(mapper.get(9));
                num -= 9;
            } else if(num >= 5) {
                sb.append(mapper.get(5));
                num -= 5;
            } else if(num >= 4) {
                sb.append(mapper.get(4));
                num -= 4;
            } else if (num>= 1){
                sb.append(mapper.get(1));
                num -= 1;
            }
        }
        return sb.toString();
    }
}

/***
 * int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
 * String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
 *
 * public String intToRoman(int num) {
 *     StringBuilder sb = new StringBuilder();
 *     // Loop through each symbol, stopping if num becomes 0.
 *     for (int i = 0; i < values.length && num >= 0; i++) {
 *         // Repeat while the current symbol still fits into num.
 *         while (values[i] <= num) {
 *             num -= values[i];
 *             sb.append(symbols[i]);
 *         }
 *     }
 *     return sb.toString();
 * }
 */
