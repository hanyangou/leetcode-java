package com.po.quiz.design;

import java.util.*;

public class FileSystem {
    Map<String, Set<String>> dirs;
    Map<String, String> files;
    String DELIMITER = "/";

    public FileSystem() {
        dirs = new HashMap<>();
        files = new HashMap<>();
    }

    public List<String> ls(String path) {
        //check if this is a file path or dir path
        List<String> res = new ArrayList<>();
        if(files.containsKey(path)){
            String[] paths = path.split(DELIMITER);
            res.add(paths[paths.length - 1]);
        } else {
            Set<String> ds = dirs.getOrDefault(path, new HashSet<>());
            if(!ds.isEmpty()){
                for(String p : ds){
                    String[] ps = p.split(DELIMITER);
                    res.add(ps[ps.length - 1]);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        String[] paths = path.split(DELIMITER);
        String cur = "/";
        for(int i = 1; i < paths.length; i++){
            Set<String> d = dirs.computeIfAbsent(cur, k -> new HashSet<>());
            String nextD;
            if(i == 1)
                nextD = cur + paths[i];
            else
                nextD = cur + DELIMITER + paths[i];
            d.add(nextD);
            dirs.put(cur, d);
            cur = nextD;
        }
    }

    public void addContentToFile(String filePath, String content) {
        mkdir(filePath);
        String c = files.computeIfAbsent(filePath, k -> "");
        c += content;
        files.put(filePath, c);
    }

    public String readContentFromFile(String filePath) {
        return files.get(filePath);
    }
}
