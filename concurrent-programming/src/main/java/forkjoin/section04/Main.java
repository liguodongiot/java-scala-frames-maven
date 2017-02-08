package forkjoin.section04;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * 学习如何使用ForkJoinPool和ForkJoinTask类提供的异步方法来管理任务。
 * 你将实现一个程序，在一个文件夹及其子文件夹内查找确定扩展名的文件。
 * 你将实现ForkJoinTask类来处理文件夹的内容。对于文件夹里的每个子文件夹，
 * 它将以异步的方式提交一个新的任务给ForkJoinPool类。
 * 对于文件夹里的每个文件，任务将检查文件的扩展名，如果它被处理，并把它添加到结果列表。
 *
 * Created by liguodong on 2016/11/21.
 */
public class Main {

    public static void main(String[] args) {
        //使用默认构造器创建ForkJoinPool。
        ForkJoinPool pool=new ForkJoinPool();
        //创建3个FolderProcessor任务。用不同的文件夹路径初始化每个任务。
        FolderProcessor system=new FolderProcessor("C:\\Windows", "log");
        FolderProcessor apps=new FolderProcessor("C:\\Program Files","log");
        FolderProcessor documents=new FolderProcessor("C:\\Documents And Settings","log");
        //在池中使用execute()方法执行这3个任务。
        pool.execute(system);
        pool.execute(apps);
        pool.execute(documents);

        //将关于池每秒的状态信息写入到控制台，直到这3个任务完成它们的执行。
        do {
            System.out.printf("*****************************************\n");
            System.out.printf("Main: Parallelism: %d\n",pool.
                    getParallelism());
            System.out.printf("Main: Active Threads: %d\n",pool.
                    getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n",pool.
                    getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n",pool.
                    getStealCount());
            System.out.printf("*****************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while((!system.isDone())||(!apps.isDone())||(!documents.isDone()));
        //使用shutdown()方法关闭ForkJoinPool。
        pool.shutdown();

        //将每个任务产生的结果数量写入到控制台。
        List<String> results;
        results=system.join();
        System.out.printf("System: %d files found.\n",results.size());
        results=apps.join();
        System.out.printf("Apps: %d files found.\n",results.size());
        results=documents.join();
        System.out.printf("Documents: %d files found.\n",results.size());

    }

}



/*
这个例子的关键是FolderProcessor类。每个任务处理文件夹的内容。如你所知，这个内容有以下两种元素：
    文件
    其他文件夹

如果任务找到一个文件夹，它创建另一个Task对象来处理这个文件夹，并使用fork()方法把它（Task对象）提交给池。
这个方法提交给池的任务将被执行，如果池中有空闲的工作线程或池可以创建一个新的工作线程。
这个方法会立即返回，所以这个任务可以继续处理文件夹的内容。对于每个文件，任务将它的扩展与所想要查找的（扩展）进行比较，
如果它们相等，将文件名添加到结果数列。

一旦这个任务处理完指定文件夹的所有内容，它将使用join()方法等待已提交到池的所有任务的结束。
这个方法在一个任务等待其执行结束时调用，并返回compute()方法返回的值。
这个任务将它自己发送的所有任务的结果和它自己的结果分组，并返回作为compute()方法的一个返回值的数组。

ForkJoinPool类同时允许任务的执行以异步的方式。你已经使用execute()方法，提交3个初始任务给池。
在Main类中，你也使用shutdown()方法结束池，并打印关于正在池中运行任务的状态和变化的信息。
ForkJoinPool类包含更多方法，可用于这个目的（异步执行任务）。参见监控一个Fork/Join池指南，看这些方法完整的列表。

不止这些…

在这个示例中，你已经使用了join()方法来等待任务的结束，并获得它们的结果。对于这个目的，你也可以使用get()方法的两个版本之一：

    get()：这个版本的get()方法，如果ForkJoinTask已经结束它的执行，则返回compute()方法的返回值，否则，等待直到它完成。
    get(long timeout, TimeUnit unit)：这个版本的get()方法，如果任务的结果不可用，则在指定的时间内等待它。如果超时并且任务的结果仍不可用，
    这个方法返回null值。TimeUnit类是一个枚举类，包含以下常量：DAYS，HOURS，MICROSECONDS， MILLISECONDS，MINUTES， NANOSECONDS 和 SECONDS。

get()和join()有两个主要的区别：

    join()方法不能被中断。如果你中断调用join()方法的线程，这个方法将抛出InterruptedException异常。
    如果任务抛出任何未受检异常，get()方法将返回一个ExecutionException异常，而join()方法将返回一个RuntimeException异常。
*/
