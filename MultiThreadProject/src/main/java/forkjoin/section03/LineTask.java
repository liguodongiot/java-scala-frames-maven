package forkjoin.section03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * 创建LineTask类，指定它继承RecursiveTask类，并参数化为Integer类型。
 * 这个类将实现统计单词在一行中出现的次数的任务。
 * Created by liguodong on 2016/11/18.
 */
public class LineTask extends RecursiveTask<Integer> {

    //声明这个类的序列号版本UID。这个元素是必需的，
    // 因为RecursiveTask类的父类，ForkJoinTask类实现了Serializable接口。
    // 声明一个私有的、String类型的属性line，两个私有的、int类型的属性start和end，一个私有的、String类型的属性word。
    private static final long serialVersionUID = 1L;
    private String line[];
    private int start, end;
    private String word;

    public LineTask(String line[], int start, int end, String word)
    {
        this.line=line;
        this.start=start;
        this.end=end;
        this.word=word;
    }


    @Override
    protected Integer compute() {
        Integer result=null;

        //如果属性end和start之差小于100，这个任务在行中由start和end属性使用count()方法决定的片断中查找单词。
        if (end-start<100) {
            result=count(line, start, end, word);
        } else {
            //否则，将行中的单词组分成两部分，创建两个新的LineTask对象来处理这两个组，在池中使用invokeAll()方法执行它们。
            int mid=(start+end)/2;
            LineTask task1=new LineTask(line, start, mid, word);
            LineTask task2=new LineTask(line, mid, end, word);
            invokeAll(task1, task2);

            //然后，使用groupResults()方法将这两个任务返回的值相加。最后，返回这个任务计算的结果。
            try {
                result=groupResults(task1.get(),task2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    //它接收以下参数：完整行的字符串数组、start属性、end属性、任务将要查找的word属性。
    private Integer count(String[] line, int start, int end, String word) {
        int counter;
        counter=0;
        for (int i=start; i<end; i++){
            if (line[i].equals(word)){
                counter++;
            }
        }
        //为了显示示例的执行，令任务睡眠10毫秒。
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return counter;
    }

    //它合计两个数的值，并返回这个结果。
    private Integer groupResults(Integer number1, Integer number2) {
        Integer result;
        result=number1+number2;
        return result;
    }


}
