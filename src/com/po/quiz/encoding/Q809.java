package com.po.quiz.encoding;

import java.util.ArrayList;

public class Q809 {
    public int expressiveWords(String S, String[] words) {
        //corner case: s == null.
        if (S == null || S.length() == 0) return 0;
        RLE base = new RLE(S);
        int ans = 0;
        for (String w : words) {
            RLE current = new RLE(w);
            if (base.chars.size() != current.chars.size()) continue;
            boolean canExtend = true;
            for (int i = 0; i < base.chars.size(); i++) {
                if (base.chars.get(i) != current.chars.get(i)) {
                    canExtend = false;
                    break;
                }
                int bc = base.counts.get(i);
                int cc = current.counts.get(i);
                //base count <= 2 , or base count > 2
                if ((bc <= 2 && bc != cc) || (bc > 2 && cc > bc)) {
                    canExtend = false;
                    break;
                }
            }
            if (canExtend) ans++;
        }
        return ans;
    }

    class RLE {
        ArrayList<Character> chars;
        ArrayList<Integer> counts;

        public RLE(String str) {
            chars = new ArrayList<>();
            counts = new ArrayList<>();
            char[] cs = str.toCharArray();
            char prev = cs[0];
            int count = 1;
            for (int i = 1; i < cs.length; i++) {
                char curr = cs[i];
                if (curr != prev) {
                    chars.add(prev);
                    counts.add(count);
                    prev = curr;
                    count = 1;
                } else
                    count++;
            }
            chars.add(prev);
            counts.add(count);
        }
    }
}
