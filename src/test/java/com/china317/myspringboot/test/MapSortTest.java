package com.china317.myspringboot.test;

import java.util.*;

/**
 * Created by lx-dong on 2017/11/2.
 */
public class MapSortTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("d","d");
        map.put("a","a");
        map.put("f","f");
        map.put("b2","b2");
        map.put("b","b");
        map.put("c","c");
        map.put("b1","b1");
        map.put("","");

        List<String> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                /*if(o1.equals(o2))
                    return 0;
                char[] chars_o1 = o1.toCharArray();
                char[] chars_o2 = o2.toCharArray();
                for(int i = 0; i < (chars_o1.length < chars_o2.length ? chars_o1.length : chars_o2.length); i++){
                    if(chars_o1[i] > chars_o2[i]){
                        return 1;
                    }
                    else if(chars_o1[i] < chars_o2[i]){
                        return -1;
                    }
                    i++;
                }
                return chars_o1.length > chars_o2.length ? 1 : -1;*/

                if(o1 == null || o2 == null)
                    throw new NullPointerException();
                return compareChar(o1.toCharArray(), o2.toCharArray(), 0);
            }

            int compareChar(char[] chars_o1, char[] chars_o2, int index){
                if(chars_o1.length - 1 >= index && chars_o2.length - 1 >= index){
                    if(chars_o1[index] > chars_o2[index])
                        return 1;
                    else if(chars_o1[index] < chars_o2[index])
                        return -1;
                    else
                        return compareChar(chars_o1, chars_o2, ++index);
                }
                return chars_o1.length > chars_o2.length ? 1 : -1;
            }

        });

        System.out.println(list);


    }
}
