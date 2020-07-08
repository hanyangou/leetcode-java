package com.po.quiz.string;

import java.util.ArrayList;
import java.util.List;

public class Q6 {
    public String convert(String s, int numRows) {
        if(s == null || s.length() <= 1 || numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(s.length(), numRows); i++){
            rows.add(new StringBuilder());
        }

        boolean goingDown = true;
        int curr = 0;
        for(Character c : s.toCharArray()){
            StringBuilder sb = rows.get(curr);
            sb.append(c);
            curr = goingDown == true ? curr + 1 : curr - 1;
            if(curr == 0 || curr == numRows - 1) goingDown = !goingDown;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : rows) res.append(sb);
        return res.toString();
    }
}
