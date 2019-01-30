package com.scalyr;

import java.util.LinkedList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class Album {
    public static List<Integer> photoAlbum(List<Integer> index, List<Integer> identity) {
        // Write your code here
        List<Integer> ans = new LinkedList<>();
        //corner case
        if(index == null || identity == null || index.size() == 0 || identity.size() == 0 || index.size() != identity.size()){
            return ans;
        }

        for(int i =0; i < identity.size();i++){
            int id = identity.get(i); // current photo id
            int in = index.get(i); // index to insert current photo
            ans.add(in,id);   // add  photo(id) to linkedList at index(in).
        }
        return ans;
    }

}
