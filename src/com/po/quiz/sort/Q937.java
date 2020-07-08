package com.po.quiz.sort;

import java.util.Arrays;

/***
 * priority queue?
 *
 * Constraints:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 *
 *  ===> means we do not need to take care most of the corner cases
 */
public class Q937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (e1, e2) -> {
                //starting from idx 1
                String[] o1 = e1.split(" ");
                String[] o2 = e2.split(" ");
                if(isDigit(o1[1]) && isDigit(o2[1])) return 0; //dont change order
                if(isDigit(o1[1]) && !isDigit(o2[1])) return 1;
                if(!isDigit(o1[1]) && isDigit(o2[1])) return -1;
                for(int i = 1; i < Math.min(o1.length, o2.length); i++){ //skip identifier
                    if(o1[i].equals(o2[i])) continue;
                    return o1[i].compareTo(o2[i]);
                }
                return o1.length < o2.length ? 1 : -1;

        });
        return logs;
    }

    public boolean isDigit(String str){
        char[] cs = str.toCharArray();
        return Character.isDigit(cs[0]);
    }
}
