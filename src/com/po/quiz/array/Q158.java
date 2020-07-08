package com.po.quiz.array;

public class Q158 {

    char[] tmp;
    int bufCnt;

    public Q158() {
        tmp = new char[4];
        bufCnt = 0;
    }

    //check if there is any char left in buf
    //if buf has enough char then do not call read4
    //otherwise after writing all chars in buf, call read4, and write remaining char in buf if there is any left
    public int read(char[] buf, int n) {
        int total = 0;
        //read from tmp until total == n OR bufCnt == 0
        int read = 0;
        while (total < n && bufCnt > 0) {
            buf[total++] = tmp[read++];
            bufCnt--;
        }

        if (total == n) {
            //organize tmp for remaining elements
            int write = 0;
            read = total;
            while (write < bufCnt) {
                tmp[write++] = tmp[read++];
            }
            return total;
        }

        //need to read more content from api until total == n
        boolean eof = false;
        while (total < n && !eof){
            int actual = read4(tmp);
            if(actual == 0)
                return total;
            eof = actual < 4;
            read = 0;
            while (read < actual) {
                buf[total++] = tmp[read++];
                if(total == n){
                    int write = 0;
                    while (read < actual)
                        tmp[write++] = tmp[read++];
                    bufCnt = write;
                    return total;
                }
            }
        }
        return total;
    }

    public int read4(char[] buf) {
        return 4;
    }

}
