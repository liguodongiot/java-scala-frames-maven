jetty-maven-plugin 有两种方式设置服务端口（默认：8080）：

方式一
通过命令行，在启动jetty的时候设置：mvn jetty:run -Djetty.port=10001

方式二
在 pom 中的 jetty-maven-plugin 中进行设置：
<plugin>
    <groupId>org.mortbay.jetty</groupId>
    <artifactId>maven-jetty-plugin</artifactId>
    <version>6.1.22</version>
    <configuration>
        <connectors>
            <connector implementation="org.mortbay.jetty.nio.SelectChannelConnector">
                <port>10001</port>
            </connector>
        </connectors>

        <stopKey>stop1</stopKey>
        <stopPort>5599</stopPort>
        <webAppConfig>
            <contextPath>/test1_srv</contextPath>
        </webAppConfig>
        <scanIntervalSeconds>5</scanIntervalSeconds>
    </configuration>
</plugin>