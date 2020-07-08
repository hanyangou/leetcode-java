package com.po.quiz.string;


import java.util.HashMap;
import java.util.Map;

/***
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 */
public class Q13 {
    public int romanToInt(String s) {
        Map<Character, Integer> mapper = new HashMap<>();
        mapper.put('I', 1);
        mapper.put('V', 5);
        mapper.put('X', 10);
        mapper.put('L', 50);
        mapper.put('C', 100);
        mapper.put('D', 500);
        mapper.put('M', 1000);
        //corner case:

        int len = s.length();
        int number = 0;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            int repeat = 1;
            while (i + 1 < len && s.charAt(i+1) == c){
                repeat++;
                i++;
            }
            if(c == 'C'){
                if(i + 1 <  len && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                    number += mapper.get(s.charAt(i+1)) - mapper.get(c) * repeat;
                    i++;
                } else {
                    number += mapper.get(c) * repeat;
                }
            } else if(c == 'X'){
                if(i + 1 <  len && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                    number += mapper.get(s.charAt(i+1)) - mapper.get(c) * repeat;
                    i++;
                } else {
                    number += mapper.get(c) * repeat;
                }
            } else if(c == 'I'){
                if(i + 1 <  len && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
                    number += mapper.get(s.charAt(i+1)) - mapper.get(c) * repeat;
                    i++;
                } else {
                    number += mapper.get(c) * repeat;
                }
            } else {
                number += mapper.get(c) * repeat;
            }
        }
        return number;
    }
}
