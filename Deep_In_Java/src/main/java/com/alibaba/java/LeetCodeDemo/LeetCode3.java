package com.alibaba.java.LeetCodeDemo;

import java.util.Optional;

public class LeetCode3 {
    public static void main(String[] args) {
        Solution solution = new LeetCode3().new Solution();
        String result = solution.defangIPaddr("1.1.1.1");
        System.out.println(result);
    }
    class Solution {
        public String defangIPaddr(String address) {
            if(Optional.of(address).isPresent()){
                address = address.replaceAll("\\.","[.]");
                return  address;
            }
            return (String) new Object();

        }
    }
}
