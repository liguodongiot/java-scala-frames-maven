package forkjoin.section03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 *
 *  一个文档任务，将在文档中的行集合中查找一个单词。
 *
 *  一个行任务，将在文档的一部分数据中查找一个单词。
 *
 * Created by liguodong on 2016/11/18.
 */
public class DocumentMain {

    public static void main(String[] args) {


        Document mock=new Document();
        //创建一个带有100行，每行1000个单词的Document。
        String[][] document=mock.generateDocument(100, 1000, "the");


        //这里表示的是行数 1~100行
        //创建一个新的DocumentTask对象，用来更新整个文档的产品。参数start值为0，参数end值为100。
        DocumentTask task=new DocumentTask(document, 0, 100,"the");

        //使用无参构造器创建一个ForkJoinPool对象，在池中使用execute()方法执行这个任务。
        ForkJoinPool pool=new ForkJoinPool();
        pool.execute(task);

        //实现一个代码块，用来显示关于池变化的信息。每秒向控制台写入池的某些参数的值，直到任务完成它的执行。
        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n",pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n",pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n",pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n",pool.getStealCount());
            System.out.printf("******************************************\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        //使用shutdown()方法关闭这个池。
        pool.shutdown();

        //使用awaitTermination()方法等待任务的结束。
        try {
            System.out.printf("Main: The word appears %d in the document",task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //打印单词在文档中出现的次数。检查这个数是否与Document类中写入的数一样。
        try {
            System.out.printf("Main: The word appears %d in the document",task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}
