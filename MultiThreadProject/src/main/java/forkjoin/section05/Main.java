package forkjoin.section05;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by liguodong on 2016/11/21.
 */

public class Main {

    public static void main(String[] args) {
        //创建一个大小为100的整数数组。
        int array[]=new int[100];

        //创建一个Task对象来处理这个数组。
        Task task=new Task(array,0,100);

        //使用默认构造器创建一个ForkJoinPool对象。
        ForkJoinPool pool=new ForkJoinPool();
        //在池中使用execute()方法执行这个任务。
        pool.execute(task);
        //使用shutdown()方法关闭ForkJoinPool类。
        pool.shutdown();

        //使用awaitTermination()方法等待任务的结束。
        // 如果你想要等待任务的结束，无论它花多长时间结束，
        // 将值1和TimeUnit.DAYS作为参数传给这个方法。
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //使用isCompletedAbnormally()方法，
        // 检查这个任务或它的子任务是否已经抛出异常。
        // 在这种情况下，将抛出的异常写入到控制台。
        // 使用ForkJoinTask类的getException()方法获取那个异常。
        if (task.isCompletedAbnormally()) {
            System.out.printf("Main: An exception has ocurred\n");
            System.out.printf("Main: %s\n",task.getException());
        }
        System.out.printf("Main: Result: %d",task.join());



    }

}

/*
你已经实现Task类来处理一个数字数组。它检查要处理的数字块是否是10个或更多的元素。
在这种情况下，它将数字块分成两块，并创建两个新的Task对象来处理这些块。
否则，他查找数组中的第4个位置的元素（索引号3）。
如果这个元素在任务要处理的块中，它抛出一个RuntimeException异常。

当你执行这个程序，异常是抛出了，但程序并没有停止。
在Main类中，你已经使用发起任务调用ForkJoinTask类的isCompletedAbnormally()方法。
如果任务或它的子任务抛出异常，这个方法返回true。你同时使用了同样对象的getException()方法来获取已抛出的Exception对象。

当你在一个任务中抛出一个未检查异常时，它也影响到它的父任务（把它提交到ForkJoinPool类的任务）和父任务的父任务，以此类推。
如果你修订程序的所有输出，你将会看到一些任务结束没有输出信息。

这些任务是那些及其父任务抛出异常的任务。
它们全部异常地完成。考虑到这一点，当你使用ForkJoinPool和ForkJoinTask对象开发一个程序，当你不想这种行为时，可以抛出异常。

*/