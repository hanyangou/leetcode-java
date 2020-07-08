package com.po.quiz.tree;

import java.util.*;

/***
 * need to track name and email
 * we can group emails with union find, but how we can label it with names?
 * we can use Set to track unique emails. and we can iterate it with union find to get it's group
 * but how we can get name with the group??
 * using map[email, name] ?
 */
public class Q721 {
    Map<String, String> unionMap;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, String> emailToName;
        Set<String> emailSet;
        unionMap = new HashMap<>();
        emailToName = new HashMap<>();
        emailSet = new HashSet<>();
        for(List<String> account: accounts){
            String name = account.get(0);
            String masterEmail = account.get(1);
            emailToName.put(masterEmail, name);
            emailSet.add(masterEmail);
            for(int i = 2; i < account.size(); i++){
                String email = account.get(i);
                emailSet.add(email);
                emailToName.put(email, name);
                union(email, masterEmail);
            }
        }
        Map<String, List<String>> group = new HashMap<>();
        for(String e : emailSet){
            String master = find(e);
            List<String> es = group.getOrDefault(master, new ArrayList<>());
            es.add(e);
            group.put(master, es);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : group.entrySet()){
            List<String> sub = new ArrayList<>();
            String name = emailToName.get(entry.getKey());
            sub.add(name);
            List<String> sorted = entry.getValue();
            Collections.sort(sorted);
            sub.addAll(sorted);
            res.add(sub);
        }
        return res;
    }

    /***
     * how to determine if given string is final parent?
     *
     *
     */
    private String find(String child){
        if(!unionMap.containsKey(child))
            return child;
        String parent = unionMap.get(child);
        return parent.equals(child) ? parent : find(parent);
    }

    private void union(String child, String parent){
        String c = find(child);
        String p = find(parent);
        unionMap.put(c, p);
    }
}
