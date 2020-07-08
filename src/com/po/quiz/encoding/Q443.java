package com.po.quiz.encoding;

public class Q443 {
    public int compress(char[] chars) {
        if (chars.length <= 1) return chars.length;
        int write = 0;
        char prev = chars[0];
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            if (curr == prev) count++;
            else {
                chars[write] = prev;
                write++;
                if (count > 1) {
                    if (count < 10) {
                        chars[write] = (char) (count + '0');
                        write++;
                    } else {
                        char[] cs = String.valueOf(count).toCharArray();
                        for (char c : cs)
                            chars[write++] = c;

                    }
                }
                count = 1;
                prev = curr;
            }
        }
        chars[write++] = prev;
        if (count > 1) {
            if (count < 10) {
                chars[write] = (char) (count + '0');
                write++;
            } else {
                char[] cs = String.valueOf(count).toCharArray();
                for (char c : cs)
                    chars[write++] = c;

            }
        }
        return write;
    }
}
