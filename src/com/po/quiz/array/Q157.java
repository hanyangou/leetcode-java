package com.po.quiz.array;

public class Q157 {
    public int read(char[] buf, int n) {
        int total = 0;
        boolean eof = false;
        while (total < n && !eof){
            char[] tmp = new char[4];
            int actual = read4(tmp);
            if(actual < 4) eof = true;
            int read = 0;
            while (read < actual && total < n){
                buf[total++] = tmp[read++];
            }
        }
        return total;
    }

    public int read4(char[] buf){
        return 4;
    }
}
