package com.ctci.design.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FindValue {

    public static void main(String[] args) {

    ArrayList<String> list = new ArrayList<String>();
    list.add("good");
    list.add("bad");
    list.add("bad");
    for (int i = 0; i < list.size(); i++) {  
            System.out.println(list.get(i)); 
    }

if (list != null) { 
    for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) { 
        if ("bad".equals(itr.next())) itr.remove(); 
    }
}
    System.out.println("After removing");
    for (int i = 0; i < list.size(); i++) {  
        System.out.println(list.get(i)); 
}
    }
}