

## AKKA文档

### 什么是AKKA？
```
可扩展的实时事务处理

我们相信编写并发、容错、可扩展的应用相当的困难。盖因大多数时候我们一直在使用错误的工具和错误的抽象等级。
AKKA就是为了改变这一切的。我们利用角色模型提升了抽象等级，并且提供了一个用来构建可扩展的、弹性的以及响应式应用的更好的平台
——更多信息请见Reactive Manifesto。对于容错机制我们采用“让它崩溃”模型，这一模型已在电信行业取得了巨大的成功，
旨在构建自我修复与永不停机的系统。角色还提供了透明的分布式抽象以及真正的可扩展且容错应用的基础。

AKKA是开源的，并遵守Apache2许可。
```


```
AKKA实现了一个独特的混合

角色
角色给你提供了：
并发与并行性的高等级抽象
异步、无锁以及高性能的事件驱动编程模型
非常轻量级的事件驱动流程（1GB堆内存可容纳几百万的角色）

容错
拥有“让它崩溃”语义的管理层级
管理层级可跨越多个JVM，实现真正的容错系统
非常适合编写可自我修复且永不停机的高容错能力的系统

位置透明
AKKA的一切旨在分布式环境中工作：角色之间都使用纯消息交互，而且一切都是异步的。

持久化
启动或重启角色时，可以选择持久化或重放它接收到的消息。
在JVM崩溃或角色迁移到另一节点时，这一点可以使角色恢复它的状态。

Scala和Java API
AKKA拥有Scala和Java两种语言的接口文档。

AKKA有两种使用方式
作为一个库：将它放到WEB-INF/lib下面供一个web应用使用，或把它当作一个常规的JAR放到你的类路径里。
微内核方式：将你的应用放到独立的内核里。

```

### 为什么选择Akka

```
与同类其它产品相比，Akka平台有什么过人之处呢？

Akka 提供可伸缩的实时事务处理能力。

Akka在以下方面提供了一致的运行时和编程模型：
纵向扩展性（并发）
横向扩展性（远程调用）
容错性

由于Akka的高内聚性和连贯的语义，学习和管理就成了一件事。

Akka是一款极具可伸缩性的软件，它的可伸缩性不仅体现在性能方面，在控制应用程序的大小方面也很实用。
Akka的内核—akka-actor, 非常小并且很容易植入已有项目中。
当你的项目需要异步或没有冲突的无锁并发时就可以考虑将akka-actor植入你的程序。

你还可以对akka核进行瘦身，使其只包含你的程序用到的部分，我们称这个瘦身后的包为Akka微内核。
然后基于它来部署你的Akka应用。随着cpu核心数的持续攀升，为了得到系统性能方面的提升akka也成了一个不错的选择。
因为Akka即使在单机环境下也能提供杰出的性能。Akka还提供了一系列的并发范式，用户可以根据自己的需求特点选择最优的方案。

Akka适用于那些场景？

Akka被很多大型组织在不同的领域所采用，如：
· 投资和商业银行业务
· 零售业
· 社交媒体
· 仿真
· 游戏和赌博
· 汽车和交通系统
· 医疗卫生
· 数据分析
等等。任何系统只要是需要高吞吐量或低延迟率的都可以考虑使用Akka。

通过角色(Actor)来管理服务故障(Supervisor)，负载管理(回退策略，超时以及进程隔离)，以及水平和垂直的伸缩性管理(增加cpu核或增加机器数量)。

下面的链接是Akka的使用者对他们是怎样使用Akka的一些评论：
http://stackoverflow.com/questions/4493001/good-use-case-for-akka
所有这些都是基于ApacheV2的开源项目。
```



### 准备开始

```
入门指南与模板项目
学习AKKA的最好方式是下载Typesafe Activator[ http://www.lightbend.com/activator/download ]并尝试一个AKKA模板项目。

下载
有许多种下载AKKA的方式。你可以把它当作Typesafe平台的一部分下载（就像上面描述的）。
还可以下载完全发布版，它包含微内核以及所有模块。或者使用像Maven或SBT这样的构建工具从AKKA Maven仓库下载依赖。

模块
AKKA是调度模块化的，它由许多拥有不同特性的JAR组成。

akka-actor – 经典角色、类型角色、IO角色等。
akka-agent – 代理、整合了Scala的STM特性
akka-camel – 整合Apache的Camel
akka-cluster – 集群成员管理、弹性路由
akka-kernel – AKKA微内核，运行着一个极简应用服务器
akka-osgi – 在OSGI容器里使用AKKA的基本bundle，包括akka-actor的类
akka-osgi-aries – Aries——服务提供角色系统的蓝图
akka-remote – 远程角色
akka-slf4j – SLF4J Logger (事件总线监听器)
akka-testkit – 测试角色系统的工具包Toolkit for testing Actor systems
akka-zeromq – 整合ZeroMQ

除了这些已进入稳定内核的稳定模块之外，还有许多标记为“试验（experimental）”的模块。
这并不是意味着它们没有达到预期的功能，它的主要意义是这些模块的API尚不够稳定。
你可以通过邮件列表向我们反馈这些模块的使用情况，帮助加快这一进程。

akka-contrib – 提交者贡献的各种模块可能会也可能不被移到核心模块，见外部贡献了解更多细节。

一个实际的JAR文件名如下所示：akka-actor_2.10-2.3.6.jar（其它模块也是如此）。
在依赖关系章节说明了各AKKA模块的JAR之间的依赖关系。

使用发布版
从 http://akka.io/downloads下载你需要的发布版并解压缩。

使用快照版
每日构建的AKKA快照版发布在http://repo.akka.io/snapshots/，并同时以SNAPSHOT和时间戳标记版本。
你可以选择使用一个时间戳标记的版本并决定何时升级到一个更新版本。
AKKA快照仓库还通过http://repo.typesafe.com/typesafe/snapshots/代理了AKKA模块依赖的许多其它仓库的代理。

警告
除非你知道你在做什么，否则不鼓励使用AKKA的快照版、每日构建版和里程碑版。

微内核
AKKA的发布版拥有一个微内核。将你的应用JAR放到deploy目录并运行bin 目录下的脚本。

使用构建工具
AKKA可以使用支持Maven仓库的构建工具

Maven仓库

从AKKA2.1-M2版开始：
Maven中央仓库（http://repo1.maven.org/maven2/）
之前的版本：
AKKA仓库（http://repo.akka.io/releases/） Typesafe仓库（http://dl.bintray.com/typesafe/maven-releases/）

通过Maven使用AKKA

开始使用AKKA和Maven的最简单的方式是检出Typesafe Activator名为
Akka Main in Java（http://www.lightbend.com/activator/template/akka-sample-main-java）的教程。

既然AKKA发布到了Maven中央仓库（从v2.1-M2开始），当然可以通过POM添加AKKA依赖。
比如下面就是akka-actor模块的依赖

模块的依赖
<dependency>
    <groupId>com.typesafe.akka</groupId>
    <artifactId>akka-actor_2.10</artifactId>
    <version>2.3.6</version>
</dependency>
注意：对于快照版，SNAPSHOT 与时间戳版本同时发布。


通过SBT使用AKKA

最简单的方法是检出Akka/SBT template工程。

SBT中的AKKA的必要部分：
SBT安装指南：https://github.com/harrah/xsbt/wiki/Setup

build.sbt文件：
name:="My Project"
version:="1.0"
scalaVersion:="2.10.4"
resolvers+="Typesafe Repository" at "http://typesafe.com/typesafe/releases/"
libraryDependencies+="com.typesafe.akka" %% "akka-actor" % "2.3.6"

注意：在上面的libraryDependencies设置中，指定SBT版本为v0.12.x或更高版本。
如果你使用较早的SBT版本，libraryDependencies应像下面这样：
libraryDependencies+="com.typesafe.akka" %% "akka-actor_2.10" % "2.3.6"


在IntelliJ IDEA中使用AKKA
安装SBT工程然后使用 sbt-idea生成IntelliJ IDEA工程。

从源码构建
Akka使用Git托管在Github上。
从http://github.com/akka/akka克隆Akka仓库

需要帮助？
如果你有问题可以从Akka邮件列表（https://groups.google.com/forum/#!forum/akka-user）获得帮助。
你也可以获取商业支持。


```