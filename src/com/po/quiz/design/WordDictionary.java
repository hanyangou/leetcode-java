package com.po.quiz.design;

public class WordDictionary {
    WordNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new WordNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word.length() == 0) return;
        char[] chars = word.toCharArray();
        addWord(chars, 0, root);
    }

    private void addWord(char[] chars, int idx, WordNode parent){
        if(idx == chars.length){
            parent.isLeaf = true;
            return;
        }

        WordNode[] children = parent.children;
        int pos = chars[idx] - 'a';
        if(children[pos] == null){
            children[pos] = new WordNode();
        }
        addWord(chars, idx + 1, children[pos]);
        return;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false; //need clarification from interviewer

        char[] chars = word.toCharArray();
        return search(chars, 0, root);
    }

    private boolean search(char[] chars, int idx, WordNode parent){
        if(chars.length == idx) return parent.isLeaf;

        char target = chars[idx];
        WordNode[] children = parent.children;
        if(target == '.'){
            for(int i = 0; i < children.length; i++){
                if(children[i] != null){
                    if(search(chars, idx + 1, children[i])){
                        return true;
                    }
                }
            }
            return false;
        } else {
            if(children[target - 'a'] == null){
                return false;
            }
            return search(chars, idx + 1, children[target - 'a']);
        }
    }

    private class WordNode{
        boolean isLeaf;
        WordNode[] children = new WordNode[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */