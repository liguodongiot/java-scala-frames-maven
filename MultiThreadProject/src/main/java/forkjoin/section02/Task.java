package forkjoin.section02;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Created by liguodong on 2016/11/18.
 */

public class Task extends RecursiveAction {

    //声明类的序列版本UID。这个元素是必需的，
    // 因为RecursiveAction类的父类ForkJoinTask实现了Serializable接口。
    private static final long serialVersionUID = 1L;

    //声明一个私有的、List<Product>类型的属性products。
    private List<Product> products;


    //声明两个私有的、int类型的属性first和last。这些属性将决定这个任务产品的阻塞过程。
    private int first;
    private int last;

    //声明一个私有的、double类型的属性increment，用来存储产品价格的增长。
    private double increment;


    public Task (List<Product> products, int first, int last, double increment) {
        this.products=products;
        this.first=first;
        this.last=last;
        this.increment=increment;
    }


    @Override
    protected void compute() {
        //如果last和first的差小于10（任务只能更新价格小于10的产品个数），使用updatePrices()方法递增的设置产品的价格。
        if (last-first<10) {
            updatePrices();
        } else {
            //如果last和first的差大于或等于10，则创建两个新的Task对象，
            //一个处理产品的前半部分，另一个处理产品的后半部分，
            // 然后在ForkJoinPool中，使用invokeAll()方法执行它们。
            int middle=(last+first)/2;

            System.out.printf("Task: Pending tasks: %s\n",getQueuedTaskCount());

            Task t1=new Task(products, first,middle+1, increment);
            Task t2=new Task(products, middle+1,last, increment);

            invokeAll(t1, t2);
        }


    }


    private void updatePrices() {
        for (int i=first; i<last; i++){
            Product product=products.get(i);
            product.setPrice(product.getPrice()*(1+increment));
        }
    }
}
