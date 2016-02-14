package com.lgd.frames.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by liguodong on 2016/1/29.
 */

public class ForkJoinMain {

    public static void main(String[] args) {
        long beginTime = System.nanoTime();
        System.out.println("The sumRecursion from 1 to 1000 is "
                + sumRecursion(1, 1000));

        System.out.println("Time consumed(nano second) By recursive algorithm : "
                + (System.nanoTime() - beginTime));


        beginTime = System.nanoTime();
        System.out.println("The sumRecursion from 1 to 1000000000 is "
                + sumIteration(1, 10000000));
        System.out.println("Time consumed(nano second) By loop algorithm : "
                + (System.nanoTime() - beginTime));


        ForkJoinMain app = new ForkJoinMain();

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask task = app.new CountTask(1,10000000);

        beginTime = System.nanoTime();

        Future<Long> result = forkJoinPool.submit(task);

        try{
            System.out.println("The sumRecursion from 1 to 1000000000 is "
                    + result.get());
        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Time consumed(nano second) By ForkJoin algorithm : "
                + (System.nanoTime() - beginTime));
    }

    /**
     * 迭代
     * @param start
     * @param end
     * @return
     */
    private static long sumIteration(long start, long end) {
        long s = 0l;

        for(long i=start; i<= end; i++){
            s += i;
        }

        return s;
    }

    /**
     * 递归
     * @param start
     * @param end
     * @return
     */
    private static long sumRecursion(long start, long end){
        if(end > start){
            return end + sumRecursion(start, end - 1);
        }
        else{
            return start;
        }
    }



    private class CountTask extends RecursiveTask<Long>{
        private static final int THRESHOLD = 10000; //阀值

        private int start;
        private int end;

        public CountTask(int start, int end){
            this.start = start;
            this.end = end;
        }

        protected Long compute(){
            System.out.println("Thread ID: " + Thread.currentThread().getId());

            Long sum = 0l;

            if((end -start) <= THRESHOLD){
                sum = sumIteration(start, end);
            }
            else{
                int middle = (start + end) / 2;
                CountTask leftTask = new CountTask(start, middle);
                CountTask rightTask = new CountTask(middle + 1, end);
                leftTask.fork();
                rightTask.fork();

                Long leftResult = leftTask.join();
                Long rightResult = rightTask.join();

                sum = leftResult + rightResult;
            }
            return sum;
        }
    }
}