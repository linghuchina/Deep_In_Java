package com.alibaba.java.LeetCodeDemo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode1 {
    public static void main(String[] args) {

    }
}
class Solution {

    public int numJewelsInStones(String J, String S) {
        Set<Character> hashset = new HashSet<Character>();
        char[] chars = J.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
             hashset.add(chars[i]);
        }
        int count=0;
        char[] chars1 = S.toCharArray();
        for (int i = 0; i <chars1.length ; i++) {
            if(hashset.contains(chars1[i])){++count;}
        }
        return count;
    }
}
