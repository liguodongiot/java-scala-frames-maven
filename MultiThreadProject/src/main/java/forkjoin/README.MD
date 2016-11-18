

## Fork/Join框架


### 2.创建Fork/Join线程池

Fork/Join框架的核心是由以下两个类：
```
ForkJoinPool：它实现ExecutorService接口和work-stealing算法。它管理工作线程和提供关于任务的状态和它们执行的信息。

ForkJoinTask： 它是将在ForkJoinPool中执行的任务的基类。它提供在任务中执行fork()和join()操作的机制，并且这两个方法控制任务的状态。
通常， 为了实现你的Fork/Join任务，你将实现两个子类的子类的类：RecursiveAction对于没有返回结果的任务和RecursiveTask 对于返回结果的任务。
```


### 3.加入任务的结果


Fork/Join框架提供了执行返回一个结果的任务的能力。这些任务的类型是实现了RecursiveTask类。
这个类继承了ForkJoinTask类和实现了Executor framework提供的Future接口。

在任务中，你必须使用Java API方法推荐的结构：
```
If (problem size < size){
    tasks=Divide(task);
    execute(tasks);
    groupResults()
    return result;
} else {
    resolve problem;
    return result;
}
```


### 4.异步运行任务