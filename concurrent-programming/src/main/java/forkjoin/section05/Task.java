package forkjoin.section05;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by liguodong on 2016/11/21.
 */

//创建Task类。指定它实现RecursiveTask类，并参数化为Integer类型。
public class Task extends RecursiveTask<Integer> {

    //声明一个私有的、int类型数组的属性array。它将模拟在这个指南中，你将要处理的数据的数组。
    private int array[];

    //声明两个私有的、int类型的属性start和end。这些属性将决定这个任务要处理的数组的元素。
    private int start, end;

    //实现这个类的构造器，初始化它的属性。
    public Task(int array[], int start, int end){
        this.array=array;
        this.start=start;
        this.end=end;
    }

    //实现这个任务的compute()方法。正如你使用Integer类型参数化RecursiveTask类一样，
    // 这个方法将返回一个Integer对象。首先，将start和end值写入到控制台。
    @Override
    protected Integer compute() {
        System.out.printf("Task: Start from %d to %d\n",start,end);

        //如果这个任务将要处理的，由start和end属性决定的元素块的大小小于10，
        // 检查数组的第4位置（索引号3）的元素是否在那个块中。
        // 如果是这种情况，抛出一个RuntimeException异常。然后，令这个任务睡眠1秒。
        if (end-start<10) {

            if ((3>start)&&(3<end)){
                throw new RuntimeException("This task throws an"+
                        "Exception: Task from "+start+" to "+end);

            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            //否则（这个任务将要处理的元素块的大小等于或大于10），将这个元素块分成两个部分，
            // 创建2个Task对象来处理这些块，在池中使用invokeAll()方法执行它们。
            int mid = (end + start) / 2;
            Task task1 = new Task(array, start, mid);
            Task task2 = new Task(array, mid, end);
            invokeAll(task1, task2);
        }
        System.out.printf("Task: End form %d to %d\n",start,end);
        return 0;
    }



}
