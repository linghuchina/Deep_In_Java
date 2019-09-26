package com.alibaba.java.ConcurrentFunction.ThreadFrameWorkDemo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 *
 */
public class AllThreadStackQuestion {
    public static void main(String[] args) {
        ThreadMXBean t   = ManagementFactory.getThreadMXBean();

        long[] threadIDs = t.getAllThreadIds();

        for (long thread:threadIDs
             ) {
            ThreadInfo threadInfo = t.getThreadInfo(thread);
            System.out.println(threadInfo.toString());

        }
    }
}
