package com.po.quiz.stack;

public class Q394 {
    private int i = 0;
    public String decodeString(String s) {
        //digit - put to stack
        // [ -- start symbol, initialize for next string
        // ] -- close symbol, start popping string in stack
        // else -- actually encoded string, put into stack
        String count = "";
        StringBuilder sb = new StringBuilder();
        for(; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                count += s.charAt(i);
            } else if (s.charAt(i) == '[') {
                i++;
                String ss = decodeString(s);
                for(int j = Integer.valueOf(count); j > 0; j--) sb.append(ss);
                count = "";
            } else if (s.charAt(i) == ']') {
                return sb.toString();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
