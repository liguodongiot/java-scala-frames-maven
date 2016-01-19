
配置文件
spring-mybatis-cfg.xml -->包含spring和mybatis的配置文件
spring-mvc-cfg.xml -->spring-mvc的配置文件

资源文件
jdbc.propertis
log4j.properties


使用mybatis插件自動生成工具，
生成的*Mapper.java实际上等同于I*Dao.java接口
eg: StudentsMapper <==> IStudentDao


com.lgd.dao
com.lgd.dao.impl
DAO层：DAO层主要是做数据持久层的工作，负责与数据库进行联络的一些任务都封装在此，
DAO层的设计首先是设计DAO的接口，然后在Spring的配置文件中定义此接口的实现类，
然后就可在模块中调用此接口来进行数据业务的处理，而不用关心此接口的具体实现类是哪个类，
显得结构非常清晰，DAO层的数据源配置，以及有关数据库连接的参数都在Spring的配置文件中进行配置。

com.lgd.service
com.lgd.service.impl
Service层：Service层主要负责业务模块的逻辑应用设计。
同样是首先设计接口，再设计其实现的类，接着再Spring的配置文件中配置其实现的关联。
这样我们就可以在应用中调用Service接口来进行业务处理。Service层的业务实现，
具体要调用到已定义的DAO层的接口，封装Service层的业务逻辑有利于通用的业务逻辑的独立性和
重复利用性，程序显得非常简洁。


com.lgd.controller
Controller层:Controller层负责具体的业务模块流程的控制，在此层里面要调用Serice层的接口
来控制业务流程，控制的配置也同样是在Spring的配置文件里面进行，
针对具体的业务流程，会有不同的控制器，我们具体的设计过程中可以将流程进行抽象归纳，
设计出可以重复利用的子单元流程模块，这样不仅使程序结构变得清晰，也大大减少了代码量。





Log4j的配置
为了方便调试，一般都会使用日志来输出信息，Log4j是Apache的一个开放源代码项目，
通过使用Log4j，我们可以控制日志信息输送的目的地是控制台、文件、GUI组件，
甚至是套接口服务器、NT的事件记录器、UNIX Syslog守护进程等；
我们也可以控制每一条日志的输出格式；通过定义每一条日志信息的级别，
我们能够更加细致地控制日志的生成过程。

resources/log4j.properties




配置SpringMVC
resources/config/spring-mvc-cfg.xml


