package com.po.quiz.topologysort;

import java.util.*;

/***
 * topology sort
 *
 * 1. first -- check if there is cycle in the graph. return empty array if there is
 * 2. applying topology sort to build the list
 *
 * map<int, [int]> : course and list of courses that depends on it.
 * indegree: the number of dependencies a course has
 */

public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //corner case
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int idx = 0;
        for(int i = 0; i < prerequisites.length; i++){
            int pre = prerequisites[i][1];
            int course = prerequisites[i][0];
            List<Integer> cList = map.getOrDefault(pre, new ArrayList<>());
            cList.add(course);
            map.put(pre, cList);
            indegree[course] = indegree[course] + 1;
        }
        //initially, throwing all courses that has 0 degree
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()){
            int c = queue.poll();
            res[idx++] = c;
            List<Integer> depends = map.get(c);
            if(depends != null && depends.size() > 0){
                for(int d : depends){
                    indegree[d] = indegree[d] - 1;
                    if(indegree[d] == 0) queue.offer(d);
                }
            }
        }
        //check indegree, if there is any element with degree > 0, meaning a cycle exists in topology
        for(int i : indegree){
            if(i > 0) return new int[0];
        }
        //otherwise return true
        return res;
    }
}
