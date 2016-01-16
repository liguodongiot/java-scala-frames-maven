密码分类：

受限制算法--古典密码

基于密钥的算法--现代密码

对称密码

非对称密码

散列函数

数字签名



安全服务<-->安全机制


Java安全组成
JCA-->基本的加密框架（消息摘要，数字签名等）
JCE-->提供一些加密算法
JSSE-->基于SSL加密的功能，主要用于网络传输中
JAAS-->权限身份验证功能



$JAVA_HOME/jdk1.7.0_17/jre/lib/security/java.security


java相关包与类
java.security --> 消息摘要

javax.crypto --> 安全消息摘要，消息认证（鉴别）码

java.net.ssl --> 安全套接字


第三方扩展包

Bouncy Castle
两种支持方案：1）配置；2）调用


Commons Codec
Apache提供的，Base64，二进制，十进制，字符集编码
url编码、解码


应用场景：
email，密钥，证书文件

产生：邮件的历史问题
定义：基于64个字符的编码算法
衍生：Base16，Base32，URL Base64
无密钥







