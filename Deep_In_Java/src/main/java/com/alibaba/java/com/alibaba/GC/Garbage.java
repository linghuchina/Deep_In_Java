package com.alibaba.java.com.alibaba.GC;
/*
* 下面例子展示垃圾收集所经历的过程，并对当前陈述进行了总结
* */
class FinalizeDemo {
    static boolean gcrun=false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;
    int i;
    public FinalizeDemo(){
        i = ++ created;
        if (created==47){
            System.out.println("created 47");
        }
    }
    protected void fianlized(){
        if (!gcrun){
            gcrun = true;
            System.out.println("begining to finalized after"+created+"Finalized has bean created");
        }
        if (i==47){
            System.out.println("finalized #47" + "Setting flag to stop finalize creation");
        }
        finalized++;
        System.out.println("all "+finalized +"finalized");
    }
}
public class Garbage {
    public static void main(String[] args) {
        if (args.length==0){
            System.out.println("Usage: \n"+"java Garbage before\n or: \n"+"java Garbage after");
            return;
        }
        while (!FinalizeDemo.f){
            new FinalizeDemo();
            new String("To take up space");
        }
        System.out.println(
                "After all Chairs have been created:\n"+
                        "total created="+ FinalizeDemo.finalized
        );
        if (args[0].equals("before")){
            System.out.println("gc（）：");
            System.gc();
            System.out.println("runFinalization():");
            System.runFinalization();
        }
        System.out.println("bye!");
        if (args[0].equals("after")){
            System.runFinalizersOnExit(true);
        }
    }
}

