

## Fork/Join框架

### 1.引言

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
```
当你在ForkJoinPool中执行ForkJoinTask时，你可以使用同步或异步方式来实现。
当你使用同步方式时，提交任务给池的方法直到提交的任务完成它的执行，才会返回结果。
当你使用异步方式时，提交任务给执行者的方法将立即返回，所以这个任务可以继续执行。

你应该意识到这两个方法有很大的区别，当你使用同步方法，调用这些方法（比如：invokeAll()方法）的任务将被阻塞，
直到提交给池的任务完成它的执行。这允许ForkJoinPool类使用work-stealing算法，分配一个新的任务给正在执行睡眠任务的工作线程。
反之，当你使用异步方法（比如：fork()方法），这个任务将继续它的执行，所以ForkJoinPool类不能使用work-stealing算法来提高应用程序的性能。
在这种情况下，只有当你调用join()或get()方法来等待任务的完成时，ForkJoinPool才能使用work-stealing算法。
```



### 5.在任务中抛出异常 
```
在Java中有两种异常：

已检查异常（Checked exceptions）：这些异常必须在一个方法的throws从句中指定或在内部捕捉它们。比如：IOException或ClassNotFoundException。
未检查异常（Unchecked exceptions）：这些异常不必指定或捕捉。比如：NumberFormatException。

在ForkJoinTask类的compute()方法中，你不能抛出任何已检查异常，因为在这个方法的实现中，它没有包含任何抛出（异常）声明。
你必须包含必要的代码来处理异常。但是，你可以抛出（或者它可以被任何方法或使用内部方法的对象抛出）一个未检查异常。
ForkJoinTask和ForkJoinPool类的行为与你可能的期望不同。程序不会结束执行，并且你将不会在控制台看到任何关于异常的信息。
它只是被吞没，好像它没抛出（异常）。你可以使用ForkJoinTask类的一些方法，得知一个任务是否抛出异常及其异常种类。
在这个指南中，你将学习如何获取这些信息。
```


### 6.取消任务 
```
当你在一个ForkJoinPool类中执行ForkJoinTask对象，在它们开始执行之前，你可以取消执行它们。
ForkJoinTask类提供cancel()方法用于这个目的。
当你想要取消一个任务时，有一些点你必须考虑一下，这些点如下：
ForkJoinPool类并没有提供任何方法来取消正在池中运行或等待的所有任务。
当你取消一个任务时，你不能取消一个已经执行的任务。

在这个指南中，你将实现取消ForkJoinTask对象的例子。你将查找数在数组中的位置。
第一个找到这个数的任务将取消剩下的任务（未找到这个数的任务）。由于Fork/Join框架并没有提供这种功能，
所以，你将实现一个辅助类来做这个取消功能。
```
