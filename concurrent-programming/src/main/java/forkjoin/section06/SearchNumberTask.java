package forkjoin.section06;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by liguodong on 2016/11/22.
 */

//实现SearchNumberTask类，指定它继承参数化为Integer类型的RecursiveTask类。
// 这个类将查找在整数数组的元素块中的数。
public class SearchNumberTask  extends RecursiveTask<Integer> {

    //声明一个私有的、int类型的数字数组。
    private int numbers[];

    //声明两个私有的、int类型的属性start和end。这些属性将决定任务要处理的数组的元素。
    private int start, end;

    //声明一个私有的、int类型的属性number，它将存储你将要查找的数。
    private int number;

    //声明一个私有的、TaskManager类型的属性manager。你将使用这个对象来取消所有任务。
    private TaskManager manager;

    //声明一个私有的、int类型的常量并初始化它为值-1。
    // 当任务没有找到这个数时，它将作为任务的返回值。
    private final static int NOT_FOUND=-1;

    //实现这个类的构造器来初始化它的属性。
    public SearchNumberTask(int numbers[], int start, int end, int number,
                TaskManager manager){
        this.numbers=numbers;
        this.start=start;
        this.end=end;
        this.number=number;
        this.manager=manager;
    }

    //实现compute()方法。写入一条信息（start和end属性值）到控制台表明这个方法的开始。
    @Override
    protected Integer compute() {
        System.out.println("Task: "+start+":"+end);
        int ret;
        //如果start和end之差大于10（这个任务将处理超过10个元素的数组），
        // 调用launchTasks()方法，将这个任务的工作拆分成两个任务。
        if (end-start>10) {
            ret=launchTasks();
        } else {
            //否则，这个任务调用lookForNumber()方法来查找在数组块中的数。
            ret=lookForNumber();
        }
        //返回任务的结果。
        return ret;
    }

    //实现lookForNumber()方法。
    private int lookForNumber() {
        //对于任务要处理的元素块中的所有元素，将你想要查找的数与存储在元素中的值进行比较。
        // 如果他们相等，写入一条信息到控制台表明这种情形，
        // 使用TaskManager对象的cancelTasks()方法来取消所有任务，
        // 并返回你已经找到的这个数对应元素的位置。
        for (int i=start; i<end; i++){
            if (numbers[i]==number) {
                System.out.printf("Task: Number %d found in position %d.\n",number,i);
                        manager.cancelTasks(this);
                return i;
            }

        }

        //.在循环的内部，令任务睡眠1秒。
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //最后，返回值-1。
        return NOT_FOUND;

    }

    //实现launchTasks()方法。
    // 首先，将这个任务要处理的数块分成两个部分，然后，创建两个Task对象来处理它们。
    private int launchTasks() {

        int mid = (start + end) / 2;
        SearchNumberTask task1 = new SearchNumberTask(numbers, start, mid, number, manager);
        SearchNumberTask task2 = new SearchNumberTask(numbers, mid, end, number, manager);
        //添加这个任务到TaskManager对象中。
        manager.addTask(task1);
        manager.addTask(task2);

        //使用fork()方法异步执行这两个任务。
        task1.fork();
        task2.fork();

        //等待这个任务的结束，返回第一个任务的结果（如果它不等于1），或第二个任务的结果。
        int returnValue;
        returnValue=task1.join();
        if (returnValue!=-1) {
            return returnValue;
        }
        returnValue=task2.join();
        return returnValue;

    }
    //实现writeCancelMessage()方法，当任务取消时，写一条信息到控制台。
    public void writeCancelMessage(){
        System.out.printf("Task: Canceled task from %d to %d.\n",start,end);
    }

}
