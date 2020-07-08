package com.po.quiz.graph;

import java.util.*;

public class Q399 {
    HashMap<String, ArrayList<String>> graph;
    HashMap<String, ArrayList<Double>> weights;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //corner case

        graph = new HashMap<>();
        weights = new HashMap<>();
        for(int i = 0; i < equations.size(); i ++){
            List<String> e = equations.get(i);
            ArrayList<String> firstEdge = graph.getOrDefault(e.get(0), new ArrayList<>());
            ArrayList<String> secondEdge = graph.getOrDefault(e.get(1), new ArrayList<>());
            ArrayList<Double> firstWeight = weights.getOrDefault(e.get(0), new ArrayList<>());
            ArrayList<Double> secondWeight = weights.getOrDefault(e.get(1), new ArrayList<>());
            firstEdge.add(e.get(1));
            secondEdge.add(e.get(0));
            graph.put(e.get(0), firstEdge);
            graph.put(e.get(1), secondEdge);
            firstWeight.add(values[i]);
            secondWeight.add(1/values[i]);
            weights.put(e.get(0), firstWeight);
            weights.put(e.get(1), secondWeight);
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            res[i] = dfs(query.get(0), query.get(1),1.0, new HashSet<>());
        }

        return res;
    }

    private double dfs(String start, String end, double value, Set<String> variables){
        if(variables.contains(start)) return -1.0;
        if(!graph.containsKey(start)) return -1.0;
        if(start.equals(end)) return value;
        //add
        variables.add(start);
        ArrayList<String> nextList = graph.get(start);
        ArrayList<Double> weightList = weights.get(start);
        for(int i = 0; i < nextList.size(); i++){
            //backtrack
            double tmp = dfs(nextList.get(i), end, weightList.get(i) * value, variables);
            if(tmp != -1.0) return tmp;
        }
        //remove
        variables.remove(variables.size() - 1);
        return -1.0; //end not found, return -1
    }
}

//archive historical approach

//    HashMap<String, String> parents;
//    HashMap<String, Double> dist;
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        //corner chase
//
//        parents = new HashMap<>();
//        dist = new HashMap<>();
//
//        //building root map and distance map from the equations
//        for(int i = 0; i < equations.size(); i++){
//            List<String> e = equations.get(i);
//            //insert parent into map and pointing to itself
//            parents.putIfAbsent(e.get(0),e.get(0));
//            parents.putIfAbsent(e.get(1),e.get(1));
//            dist.putIfAbsent(e.get(0), 1.0);
//            dist.putIfAbsent(e.get(1), 1.0);
//
//            /***
//             *             index   a   b   a  c
//             *             root    c   d   b  d
//             *             dist    2   3   4  ?
//             *
//             *             1/ (a/c) * a/b * b/d = b/d * a/b / (a/c) = a/d * c/a = c/d
//             *
//             *
//             ***/
//
//            String r1 = find(e.get(0));
//            String r2 = find(e.get(1));
//            parents.put(r1, r2);
//            dist.put(r1, dist.get(e.get(1)) * values[i] / dist.get(e.get(0)));
//        }
//
//        double[] ans = new double[queries.size()];
//
//        //parse query
//        int idx = 0;
//        for (List<String> q : queries){
//            String v1 = q.get(0);
//            String v2 = q.get(1);
//            //if variable does not exist in map, means it does not appear in equations, return -1
//            if(!parents.containsKey(v1) || !parents.containsKey(v2)){
//                ans[idx++] = -1;
//            } else if(!find(v1).equals(find(v2))) { //the root of variable 1 != root of variable 2
//                ans[idx++] = -1;
//            } else {
//
//                double a = getDistance(v2) / getDistance(v1);
//                ans[idx++] = a;
//            }
//        }
//        return ans;
//    }
//
//    private String find(String key){
//        if(parents.get(key).equals(key)) return key;
//        return find(parents.get(key));
//    }
//
//    /***
//     *             index   a   b   a  c
//     *             root    c   d   b  d
//     *             dist    2   3   4  ?
//     *
//     *  if key is not in the map, insert key into map and put itself as root
//     *  also put 1 as it's distance
//     *  if key is in the map, try to find it's root. if it's root has another root,
//     *  update to the new root, and update the distance from key to new root/
//     */
//
//    private double getDistance(String key){
//        String r = parents.get(key);
//        double d = dist.get(key);
//
//        if(r.equals(key)) return d;
//        return d * getDistance(r);
//    }