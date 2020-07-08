package com.po.quiz.backtrack;

import java.util.*;

/***
 * thoughts: using backtracking. using a counter to track the number of open and closed parentheses. increment counter when there is open one
 * and reduce it when encountering closed one. terminate the backtrack if counter becomes negative
 *
 *
 * challenge: there are other characters other than parentheses. how to deal with it? how do we organize the sequence of
 * characters while remove the invalid parentheses.
 *
 * optimize: tracking unmatch open and closed parentheses first, and stop skip parentheses if all are discarded.
 *
 * time: O(2 ^ N)
 * space: O(N)
 */
public class Q301 {
    class Pair{
        char c;
        int idx;
        public Pair(char c, int idx){
            this.c = c;
            this.idx = idx;
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        int left_remove = 0, right_remove = 0;
        List<Integer> leftStart = new ArrayList<>();
        List<Integer> rightStart = new ArrayList<>();
        Deque<Pair> stack = new ArrayDeque<>();
        int lastRight = 0;
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++){
            char c = cs[i];
            if(c == '('){
                stack.push(new Pair(c, lastRight));
            } else if( c == ')'){
                lastRight = i;
                if(!stack.isEmpty() && stack.peek().c == '(')
                    stack.pop();
            }
        }
        Deque<Pair> stack2 = new ArrayDeque<>(); //for )
        int lastLeft = s.length() - 1;
        for(int i = cs.length - 1; i >= 0; i--){
            char c = cs[i];
            if(c == '('){
                lastLeft = i;
                if(!stack2.isEmpty() && stack2.peek().c == ')')
                    stack2.pop();
            } else if( c == ')'){
                stack2.push(new Pair(c, lastLeft));
            }
        }
        while (!stack.isEmpty()){
            Pair p = stack.pop();
            if(p.c == '('){
                left_remove++;
                leftStart.add(0,p.idx);
            }
        }
        while (!stack2.isEmpty()){
            Pair p = stack2.pop();
            if(p.c == ')'){
                right_remove++;
                rightStart.add(p.idx);
            }
        }

        Set<String> res = new HashSet<>();
        backtrack(s, res, 0, new StringBuilder(), left_remove, leftStart, right_remove, rightStart);
        List<String> ans = new ArrayList<>();
        ans.addAll(res);
        return ans;
    }

    public void backtrack(String s, Set<String> res, int idx, StringBuilder sb, int leftRemove, List<Integer> leftStart, int rightRemove, List<Integer> rightStart){
        if(idx == s.length()){
            if(leftRemove == 0 && rightRemove == 0){
                String tmp = sb.toString();
                res.add(tmp);
            }
            return;
        }
        char c = s.charAt(idx);
        //remove it
        //- left
        //- right
        //- else
        if(c == '(' && leftRemove > 0 && idx >= leftStart.get(0)) {
            Integer l = leftStart.get(0);
            leftStart.remove(0);
            backtrack(s, res, idx + 1, sb, leftRemove-1, leftStart, rightRemove, rightStart); //skip it
            leftStart.add(0,l);
        }
        if(c == ')' && rightRemove > 0 && idx <= rightStart.get(0)){
            Integer r = rightStart.get(0);
            rightStart.remove(0);
            backtrack(s, res, idx + 1, sb, leftRemove, leftStart, rightRemove-1, rightStart); //skip it
            rightStart.add(0,r);

        }
        sb.append(c);
        backtrack(s, res, idx+1, sb, leftRemove, leftStart, rightRemove, rightStart);
        sb.deleteCharAt(sb.length() - 1);
    }
}

/***
 int minRemove = Integer.MAX_VALUE;
 public List<String> removeInvalidParentheses(String s) {
 Set<String> res = new HashSet<>();
 //determine unmatch parentheses.
 int left_discard = 0;
 int right_discard = 0;
 for(char c : s.toCharArray()){
 if(c == '('){
 left_discard++;
 } else if(c == ')'){
 if(left_discard > 0){
 left_discard--;
 } else {
 right_discard++;
 }
 }
 }

 backtrack(s.toCharArray(), 0, 0, 0, left_discard, right_discard,new StringBuilder(), res);
 List<String> ans = new ArrayList<>(res);
 return ans;
 }

 public void backtrack(char[] cs, int idx, int counter, int removeCount, int left_discard, int right_discard, StringBuilder tmp, Set<String> res){
 //terminate : when idx > s.length() - 1
 if(idx == cs.length) {
 if(counter != 0) return; //probably can redundant check
 if(removeCount <= minRemove){
 if(removeCount < minRemove){
 res.clear();
 res.add(tmp.toString());
 minRemove = removeCount;
 } else { //same remove steps as min
 res.add(tmp.toString());
 }
 }
 return;
 } else {
 char curr = cs[idx];
 if(curr != '(' && curr != ')'){
 tmp.append(curr);
 backtrack(cs, idx + 1, counter, removeCount, left_discard, right_discard, tmp, res);
 tmp.deleteCharAt(tmp.length() - 1);
 } else {
 //skip it
 if(curr == '('){
 if(left_discard > 0){
 backtrack(cs, idx + 1, counter, removeCount + 1, left_discard - 1, right_discard, tmp, res);
 }
 } else if(curr == ')'){
 if(right_discard > 0){
 backtrack(cs, idx + 1, counter, removeCount + 1, left_discard, right_discard - 1, tmp, res);
 }
 }
 //add open one
 if(curr == '('){
 tmp.append(curr);
 backtrack(cs,idx + 1, counter + 1, removeCount, left_discard, right_discard, tmp, res);
 tmp.deleteCharAt(tmp.length() - 1);
 } else { //add close one only counter is valid
 if(counter > 0){
 tmp.append(curr);
 backtrack(cs, idx + 1, counter - 1, removeCount, left_discard, right_discard, tmp, res);
 tmp.deleteCharAt(tmp.length() - 1);
 }
 }
 }
 }
 }
***/