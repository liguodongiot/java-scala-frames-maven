
### Thrift

#### 概述
```
Thrift是一个软件框架，用来进行可扩展且跨语言的服务的开发。
它结合了功能强大的软件堆栈和代码生成引擎，
以构建在 C++, Java, Python, PHP, Ruby, Erlang, Perl, Haskell, C#, Cocoa, 
JavaScript, Node.js, Smalltalk, and OCaml 
等等编程语言间无缝结合的、高效的服务。

thrift允许你定义一个简单的定义文件中的数据类型和服务接口。
以作为输入文件，编译器生成代码用来方便地生成RPC客户端和服务器通信的无缝跨编程语言。
```

#### 基本概念

**1.数据类型**

```
基本类型：
    bool：布尔值，true 或 false，对应 Java 的 boolean
    byte：8 位有符号整数，对应 Java 的 byte
    i16：16 位有符号整数，对应 Java 的 short
    i32：32 位有符号整数，对应 Java 的 int
    i64：64 位有符号整数，对应 Java 的 long
    double：64 位浮点数，对应 Java 的 double
    string：utf-8编码的字符串，对应 Java 的 String
结构体类型：
    struct：定义公共的对象，类似于 C 语言中的结构体定义，在 Java 中是一个 JavaBean
容器类型：
    list：对应 Java 的 ArrayList
    set：对应 Java 的 HashSet
    map：对应 Java 的 HashMap
异常类型：
    exception：对应 Java 的 Exception
服务类型：
    service：对应服务的类
```

**2.服务端编码基本步骤：**

```
实现服务处理接口impl
创建TProcessor
创建TServerTransport
创建TProtocol
创建TServer
启动Server
```

**3.客户端编码基本步骤：**

```
创建Transport
创建TProtocol
基于TTransport和TProtocol创建 Client
调用Client的相应方法
```

**4.数据传输协议**

```
TBinaryProtocol : 二进制格式.
TCompactProtocol : 压缩格式
TJSONProtocol : JSON格式
TSimpleJSONProtocol : 提供JSON只写协议, 生成的文件很容易通过脚本语言解析

tips:客户端和服务端的协议要一致
```



**实现接口Iface**

**TSimpleServer服务模型**

简单的单线程服务模型，一般用于测试。

`HelloServerDemo`
`HelloClientDemo`


**TThreadPoolServer服务模型**
线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求。

`HelloThreadPoolServerDemo`
`HelloMulClientDemo`
`HelloClientDemo`

**TNonblockingServer服务模型**
使用非阻塞式IO，服务端和客户端需要指定 TFramedTransport 数据传输的方式。

`HelloNonblockingServerDemo`
`HelloNonblockingClientDemo`


**THsHaServer服务模型**

半同步半异步的服务端模型，需要指定为： TFramedTransport 数据传输的方式。

`HelloHsHaServerDemo`
`HelloHshaClientDemo`
只要注意传输协议一致以及指定传输方式为TFramedTransport。


**异步客户端**

`HelloAsynClientServerDemo`
`HelloAsynClientDemo`




### Scrooge Twitter 详细介绍
Scrooge 是一个 Thrift 代码解析／生成器，能够生成 Scala 和 Java 代码。这就意味着，
它能够取代 Apache Thrift 代码生成器，并能在 libthrift 上生成符合标准的可兼容的二进制编解码。
建议使用Scala语法生成代码。

因为 Scala 与 Java 的API 兼容，所以你能够使用 apache thrift 编解码生成器来生成 Java 文件，
并在 Scala 中使用它们，但是使用 Java 集合和可变的"bean"类生成的代码可能会导致一些问题出现，
这时候就必须手动修改了。但是，可以直接通过生成 Scala 代码来规避这个问题。
所以说，使用Scala语法生成代码的兼容性更好。