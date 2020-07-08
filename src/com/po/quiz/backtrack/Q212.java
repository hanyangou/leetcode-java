package com.po.quiz.backtrack;

import java.util.*;

/***
 * backtracking with Trie
 * prune the exploration choice if it wont match any given words
 *
 *
 * termination: when target word is found
 *
 * challenge: how to terminate early when target word is found?
 * optimization by pruning trie: there is only terminate node in children, we can remove it;
 */
public class Q212 {
    public int TERMINATE_INDEX = 26;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    char[][] board;
    String[] words;
    Trie root;
    public List<String> findWords(char[][] board, String[] words) {
        //corner condition

        Set<String> res = new HashSet<>();

        if (words == null || words.length == 0) return new ArrayList<>();
        //building Trie: O(total characters in words)
        root = new Trie();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Trie node = root;
            for (char c : chars) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie(c);
                }
                node = node.children[c - 'a'];
            }
            node.children[TERMINATE_INDEX] = new Trie(); //indicate the ending node
        }
        this.board = board;
        this.words = words;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (root.children[board[row][col] - 'a'] != null)
                    backtrack(row, col, root, visited, new StringBuilder(), res);
            }
        }
        List<String> finalAns = new ArrayList<>(res);
        return finalAns;
    }

    //check boundary constrain
    //check if cell has character in trie
    public void backtrack(int row, int col, Trie node, boolean[][] visited, StringBuilder tmp, Set<String> res) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || visited[row][col]) return;
        if (node.children[board[row][col] - 'a'] == null) return;

        visited[row][col] = true;
        tmp.append(board[row][col]);
        node = node.children[board[row][col] - 'a'];
        if (node.children[TERMINATE_INDEX] != null) {
            res.add(tmp.toString());
            //optimization : pruning trie after word has been added into result, to avoid duplicate search
            //remove terminate node since its already in result
            node.children[TERMINATE_INDEX] = null;
            //put all nodes in stack and reverse check if trie node can be pruned
            char[] chars = tmp.toString().toCharArray();
            ArrayList<Trie> nodes = new ArrayList<>();
            Trie cur = root;
            nodes.add(cur);
            for(char c : chars){
                nodes.add(cur.children[c - 'a']);
                cur = cur.children[c - 'a'];
            }
            int idx = nodes.size() - 1;
            while (idx > 0){ //iterate trie nodes til either idx reaches root or the node has other children
                Trie prune = nodes.get(idx);
                boolean canPrune = true;
                for(Trie child : prune.children){
                    if(child != null){
                        canPrune = false;
                        break;
                    }
                }
                if(canPrune){
                    Trie parent = nodes.get(idx - 1);
                    parent.children[prune.val - 'a'] = null;
                } else {
                    break;
                }
                idx--;
            }
        }
        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            backtrack(nr, nc, node, visited, tmp, res); //O(n*m)
        }
        tmp.deleteCharAt(tmp.length() - 1);
        visited[row][col] = false;
        return;
    }

    class Trie {
        Trie[] children;
        Character val;
        public Trie() {
            children = new Trie[27]; // one more space for termination
        }
        public Trie(char val){
            this.val = val;
            children = new Trie[27]; // one more space for termination
        }
    }
}


/***
 class Solution {
 int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1,0}};
 public List<String> findWords(char[][] board, String[] words) {
 //corner condition

 List<String> res = new ArrayList<>();
 if(words == null || words.length == 0) return res;

 Trie root = new Trie();
 for(String word: words){
 char[] chars = word.toCharArray();
 Trie node = root;
 for(char c : chars){
 if(node.children[c - 'a'] == null){
 node.children[c - 'a'] = new Trie();
 }
 node = node.children[c - 'a'];
 }
 node.children[node.TERMINATE_INDEX] = new Trie(); //indicate the ending node
 }

 boolean[][] visited = new boolean[board.length][board[0].length];
 for(String word : words){
 for(int i = 0; i < board.length; i++){
 for(int j = 0; j < board[0].length; j++){
 backtrack(board, visited, res, i, j, word, 0);
 if(foundWord(res, word)) break;
 }
 }
 }
 return res;
 }

 //how to terminate backtrack if word is found??
 public void backtrack(char[][] board, boolean[][] visited, List<String> res, int row, int col, String word, int idx){
 //termination
 if(idx == word.length()) {
 if(!res.contains(word)) res.add(word);

 return;
 }
 //backtracking steps
 //check constraint
 //place
 //backtrack
 //remove
 if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && visited[row][col] == false && board[row][col] == word.charAt(idx)){
 visited[row][col] = true;
 for(int[] d : directions){
 backtrack(board, visited, res, row + d[0], col + d[1], word, idx + 1);
 if(foundWord(res, word)) break;
 }
 visited[row][col] = false;
 }
 return;
 }

 public boolean foundWord(List<String> res, String word){
 return res.contains(word);
 }

 class Trie{
 public int TERMINATE_INDEX = 26;
 Trie[] children;
 public Trie(){
 children = new Trie[27]; // one more space for termination
 }
 }

 }
 ***/