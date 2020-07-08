package com.po.quiz.graph;

import java.util.*;

/***
 * Thoughts: constructing Map<departure, List<arrival>> from given tickets, that arraival is sorted by alphabet order
 * remove arrival once putting into result set.
 * if arrival is empty, remove all document from map
 *
 * Algorithm:
 * 1. building travel graph with Map<departure, [destinations]>
 * 2. choosing destination with greedy (smallest lexical order)
 * 3. kickoff backtracking travel to obtain final result
 *
 *  Challenge:
 *  1. how to apply backtracking on travel
 */
public class Q332 {
    HashMap<String, List<String>> itineraries;
    HashMap<String, boolean[]> visitMaps;
    int flights = 0;
    List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>();
        itineraries = new HashMap<>();
        visitMaps = new HashMap<>();
        //corner case
        if(tickets == null || tickets.size() == 0)
            return res;
        //1. building graph in HashMap
        flights = tickets.size();
        for(List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            List<String> arrivals = itineraries.getOrDefault(departure, new ArrayList<>());
            arrivals.add(arrival);
            itineraries.put(departure, arrivals);
        }
        //2. sorting destination for greedy
        for(Map.Entry<String, List<String>> e : itineraries.entrySet()){
            Collections.sort(e.getValue());
            boolean[] visitMap = new boolean[e.getValue().size()];
            visitMaps.put(e.getKey(), visitMap);
        }
        //2. travel graph
        List<String> route = new LinkedList<>();
        String start = "JFK";
        route.add(start);
        backtracking(start, route);
        return res;
    }

    public boolean backtracking(String from, List<String> route){
        //termination
        if(route.size() == flights + 1){
            res = new LinkedList<>(route);
            return true;
        }
        if(!itineraries.containsKey(from)) return false;
        //place
        List<String> desList = itineraries.get(from);
        boolean[] visitMap = visitMaps.get(from);
        for(int i = 0; i < desList.size(); i++){
            boolean complete = false;
            if(!visitMap[i]){
                route.add(desList.get(i));
                visitMap[i] = true;
                complete = backtracking(desList.get(i), route);
                route.remove(route.size() - 1);
                visitMap[i] = false;
            }
            if(complete) return true;
        }
        return false;
    }
}

//archive historical approach which did not work
//public class Q332 {
//    HashMap<String, List<String>> itineraries = new HashMap<>();
//    public List<String> findItinerary(List<List<String>> tickets) {
//        List<String> res = new ArrayList<>();
//        //corner case
//        if(tickets == null || tickets.size() == 0)
//            return res;
//
//        for(List<String> ticket : tickets) {
//            String departure = ticket.get(0);
//            String arrival = ticket.get(1);
//
//            List<String> arrivals = itineraries.getOrDefault(departure, new ArrayList<>());
//            arrivals.add(arrival);
//            Collections.sort(arrivals);
//            itineraries.put(departure, arrivals);
//        }
//
//        String curr = "JFK";
//        res.add(curr);
//        while (!itineraries.isEmpty()){
//            List<String> ds = itineraries.get(curr);
//            int idx = 0;
//            while (!itineraries.containsKey(ds.get(idx)) && ds.size() > 1){
//                idx++;
//            }
//            String next = ds.get(idx);
//            res.add(next);
//            ds.remove(idx);
//            if(ds.isEmpty()){
//               itineraries.remove(curr);
//            } else {
//                itineraries.put(curr, ds);
//            }
//            curr = next;
//        }
//        return res;
//    }
//}
