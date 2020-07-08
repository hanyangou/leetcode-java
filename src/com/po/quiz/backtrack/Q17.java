package com.po.quiz.backtrack;

import java.util.*;

/***
 * thoughts:
 *     1. building Map<Character, [Character]>
 *     2. termination case: running all digits -- length of string == length of digits
 *     3. backtracking with all possible letters
 */
public class Q17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));


        StringBuilder sb = new StringBuilder();
        backtrack(res, sb, digits, 0, map);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder sb, String digits, int idx, Map<Character, List<Character>> map){
        //termination case:
        if(idx == digits.length()){
            res.add(sb.toString());
            return;
        }
        Character digit = digits.charAt(idx);
        List<Character> alphabets = map.get(digit);
        for(int i = 0; i < alphabets.size(); i++){
            //place
            sb.append(alphabets.get(i));
            //backtrack
            backtrack(res, sb, digits, idx+1, map);
            //remove
            sb.deleteCharAt(idx);
        }
        return;
    }
}
