package com.po.quiz.graph;

import java.util.*;

/***
 * Thoughts: the challenge part for this question is how to handle the node A that has already been visited from node B before.
 * Running DFS for all nodes
 *
 * Be careful about cloning node in neighbors.... can not just simply assign reference to it, since it will not consider as deep clone
 * This quesiton is about how to recursively clone object that is nested in another object
 */
public class Q133 {
    HashMap<Node, Node> visited = new HashMap<>(); //map[orig, clone]
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(visited.containsKey(node)) return visited.get(node);
        Node clone = new Node(node.val);
        visited.put(node, clone);
        for(Node n: node.neighbors){
            clone.neighbors.add(cloneGraph(n));
        }
        return clone;
    }
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

