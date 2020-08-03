package com.po.quiz.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***["root/a 1.txt(abcd) 2.txt(efgh)",
 * "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 *
 */
public class Q609 {
    public List<List<String>> findDuplicate(String[] paths) {
        //corner case

        Map<String, List<String>> toFiles = new HashMap<>();
        for(String path : paths){
            String[] separate = path.split(" ");
            //format always valid?
            String p = separate[0];
            for(int i = 1; i < separate.length; i++){
                String[] f = separate[i].split("\\(");
                String name = f[0];
                String content = f[1];
                List<String> list = toFiles.computeIfAbsent(content, k-> new ArrayList<>());
                list.add(p + "/" + name);
            }

        }
        List<List<String>> res = new ArrayList<>();
        for( List<String> l : toFiles.values()){
            if(l.size() > 1) res.add(l);
        }
        return res;
    }

}
