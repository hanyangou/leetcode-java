package com.po.quiz.string;

public class Q844 {
    public boolean backspaceCompare(String S, String T) {
        if(S == null && T == null) return true;
        else if(S != null && T != null) {
            String ns = finalString(S);
            String nt = finalString(T);
            return ns.equals(nt);
        }
        else return false;
    }

    private String finalString(String str){
        if(str == null) return null;
        int idx = 0;
        char[] cs = new char[str.length()];
        for(char c : str.toCharArray()){
            if(c != '#'){
                cs[idx] = c;
                idx++;
            } else {
                if(idx > 0){
                    idx--;
                }
            }
        }
        return String.valueOf(cs).substring(0, idx);
    }
}
