package com.alibaba.java.ConcurrentFunction.ThreadFrameWorkDemo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 *
 */
public class AllThreadStackInfoQuestion {
    public static void main(String[] args) {
        com.sun.management.ThreadMXBean t   = (com.sun.management.ThreadMXBean) ManagementFactory.getThreadMXBean();

        long[] threadIDs = t.getAllThreadIds();

        for (long thread:threadIDs
             ) {
            ThreadInfo threadInfo = t.getThreadInfo(thread);
            System.out.println(threadInfo.toString());

        }
    }
}
 