package forkjoin.section06;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 实现取消ForkJoinTask对象的例子。
 * 你将查找数在数组中的位置。
 * 第一个找到这个数的任务将取消剩下的任务（未找到这个数的任务）。
 * 由于Fork/Join框架并没有提供这种功能，所以，你将实现一个辅助类来做这个取消功能。
 *
 * Created by liguodong on 2016/11/22.
 */
public class Main {

    //实现这个例子的主类，通过创建Main类，并实现main()方法。
    public static void main(String[] args) {

        //使用ArrayGenerator类，创建一个有1000个数字的数组。
        ArrayGenerator generator=new ArrayGenerator();
        int array[]=generator.generateArray(1000);

        //创建一个TaskManager对象。
        TaskManager manager=new TaskManager();

        //使用默认的构造器创建一个ForkJoinPool对象。
        ForkJoinPool pool=new ForkJoinPool();

        //创建一个 SearchNumberTask 对象来处理前面生成的数组。
        SearchNumberTask task=new SearchNumberTask(array,0,1000,5,manager);

        //使用execute()方法，在池中异步执行任务。
        pool.execute(task);

        //使用shutdown()方法关闭这个池。
        pool.shutdown();

        //使用ForkJoinPool类的awaitTermination()方法，等待任务的结束。
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //写入一条信息到控制台，表明程序的结束。
        System.out.printf("Main: The program has finished\n");

    }

}


/*
ForkJoinTask提供cancel()方法，允许你取消一个还未执行的任务。这是一个非常重要的点。
如果任务已经开始它的执行，那么调用cancel()方法对它没有影响。这个方法接收一个Boolean值，名为mayInterruptIfRunning的参数。
这个名字可能让你觉得，如果你传入一个true值给这个方法，这个任务将被取消，即使它正在运行。

Java API文档指出，在ForkJoinTask类的默认实现中，这个属性不起作用。任务只能在它们还未开始执行时被取消。
一个任务的取消不会影响到已经提到到池的（其他）任务。它们继续它们的执行。
Fork/Join框架的一个局限性是，它不允许取消在ForkJoinPool中的所有任务。
为了克服这个限制，你实现了TaskManager类。
它存储被提到池中的所有任务。
它有一个方法取消它存储的所有任务。如果一个任务由于它正在运行或已经完成而不能被取消，cancel()方法返回false值，
所以，你可以尝试取消所有任务，而不用担心可能有间接的影响。
在这个例子中，你已经实现一个任务，用来在一个数字数组中查找一个数。
如Fork/Join框架所推荐的，你将问题分解成更小的子问题。你只关心这个数的出现，所以当你找到它，你取消了其他任务。

 */