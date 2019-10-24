package com.alibaba.java.ConcurrentFunction.concurrentpakage;

import java.util.concurrent.RecursiveAction;

public class ForkJoinPool {
    public static void main(String[] args) {
        int[] values= new int[]{2,5,6,7,8,10,9,1,0,4,6,1,13,11,17};
        ForkJoinPool pool = new ForkJoinPool();
    }

    private static class QuickSortTast extends RecursiveAction {
        private final int[] values;
        private static  final int THRESHOLD = 4 ;
        private final int low , high;
        private QuickSortTast(int[] values) {
            this.values = values;
            this.low = 0;
            this.high = values.length-1;
        }
        private QuickSortTast(int[] parts,int low,int high){
            this.values = parts;
            this.low = low;
            this.high= high;
        }
        @Override
        protected void compute() {
            if(high - low< THRESHOLD){
                sort(values,low,high);
            }
            //设置一个阈值
        }

        private void sort(int[] values, int low, int high) {

        }
        private void exchange(int[] values,int low , int high){
            if(low!=high){
                int temp = values[low];
                values[low] = values[high];
                values[high] = temp;
            }
        }
    }
}
