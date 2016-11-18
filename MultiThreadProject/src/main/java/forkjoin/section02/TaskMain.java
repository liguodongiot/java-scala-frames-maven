package forkjoin.section02;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by liguodong on 2016/11/18.
 */
public class TaskMain {


    //在这个示例中，你已经创建一个ForkJoinPool对象和一个在池中执行的ForkJoinTask类的子类。
    // 为了创建ForkJoinPool对象，你已经使用了无参构造器，所以它会以默认的配置来执行。
    // 它创建一个线程数等于计算机处理器数的池。
    // 当ForkJoinPool对象被创建时，这些线程被创建并且在池中等待，直到有任务到达让它们执行。

    //由于Task类没有返回结果，所以它继承RecursiveAction类。
    public static void main(String[] args) {

        //使用ProductListGenerator类创建一个包括10000个产品的数列。
        ProductListGenerator generator=new ProductListGenerator();
        List<Product> products=generator.generate(100000);


        //创建一个新的Task对象，用来更新产品队列中的产品。
        // first参数使用值0，last参数使用值10000（产品数列的大小）。
        Task task=new Task(products, 0, products.size(), 0.20);

        //使用无参构造器创建ForkJoinPool对象。
        ForkJoinPool pool=new ForkJoinPool();

        //在池中使用execute()方法执行这个任务 。
        pool.execute(task);

        //实现一个显示关于每隔5毫秒池中的变化信息的代码块。
        // 将池中的一些参数值写入到控制台，直到任务完成它的执行。
        do {

            System.out.printf("Main: Thread Count: %d\n",pool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal: %d\n",pool.getStealCount());
            System.out.printf("Main: Parallelism: %d\n",pool.getParallelism());

            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!task.isDone());

        pool.shutdown();

        if (task.isCompletedNormally()){
            System.out.printf("Main: The process has completed normally.\n");
        }


        for (int i=0; i<products.size(); i++){
            Product product=products.get(i);
            if (product.getPrice()!=12) {
                System.out.printf("Product %s: %f\n",product.getName(),product.getPrice());
            }
        }

        System.out.println("Main: End of the program.\n");

    }




}
