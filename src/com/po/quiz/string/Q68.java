package com.po.quiz.string;

import java.util.ArrayList;
import java.util.List;

public class Q68 {
    String[] words;
    int maxWidth;
    public List<String> fullJustify(String[] words, int maxWidth) {
        this.words = words;
        this.maxWidth = maxWidth;
        int left = 0;
        List<String> res = new ArrayList<>();
        while (left < words.length)
            left = justify(res, left);
        return res;
    }

    //return next left;
    public int justify(List<String> res, int left){
        //special case that only one word ?
        int right = getRight(left);
        boolean isLastLine = right == words.length - 1;
        boolean oneWord = right == left;
        //get num of slots
        //get total whitespaces
        StringBuffer sb = new StringBuffer();
        if(!isLastLine && !oneWord){
            int totalSpaces = maxWidth;
            for(int i = left; i <= right; i++){
                totalSpaces -= words[i].length();
            }
            int numSlots = right - left;
            //how to deal with the situation that spaces cant distribute evenly?
            int singleSlot = totalSpaces / numSlots;
            int remain = totalSpaces % numSlots;

            for(int i = left; i <= right; i++){
                sb.append(words[i]);
                int counter = singleSlot;
                while (counter > 0){
                    sb.append(" ");
                    counter--;
                }
                if(remain > 0){
                    sb.append(" ");
                    remain--;
                }
            }
            sb.delete(sb.length() - singleSlot, sb.length());
        } else {
            for(int i = left; i <= right; i++){
                sb.append(words[i]);
                sb.append(" ");
            }
            if(sb.length() > maxWidth){
                sb.delete(sb.length() - 1, sb.length());
            } else {
                while (sb.length() < maxWidth)
                    sb.append(" ");
            }
        }
        res.add(sb.toString());
        return right + 1;
    }

    public int getRight(int left){
        int length = 0;
        while (left < words.length && length + words[left].length() <= maxWidth){
            length += words[left++].length();
            length++; //for space between words
        }
        return left - 1;
    }
}
