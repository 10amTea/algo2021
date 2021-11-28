### http协议和socket的区别

##### 一、TCP/IP 协议体系结构模型

| OSI 参考层编号 | 等效的 OSI 层    | TCP/IP 层  | TCP/IP 协议示例                                              |
| -------------- | ---------------- | ---------- | ------------------------------------------------------------ |
| 5、6、7        | 应用、会话、表示 | 应用       | NFS、NIS、DNS、LDAP、telnet、ftp、ssh、http、rlogin、rsh、rcp、RIP、RDISC、SNMP 等 |
| 4              | 传输             | 传输       | TCP、UDP、SCTP                                               |
| 3              | 网络             | 网络 or IP | IPv4、IPv6、ARP、ICMP                                        |
| 2              | 数据链路         | 数据链路   | PPP、IEEE 802.2                                              |
| 1              | 物理             | 物理网络   | 以太网 (IEEE 802.3)、令牌环、RS-232、FDDI 等等               |

https://docs.oracle.com/cd/E19253-01/819-7058/ipov-10/index.html



IP：网络层协议；（高速公路）

TCP和UDP：传输层协议；（卡车）

HTTP：应用层协议；（货物）

socket是在应用层和传输层之间的一个抽象层，它把TCP/IP层复杂的操作抽象为几个简单的接口供应用层调用已实现进程在网络中通信。



WebSocket想象成HTTP(应用层)，HTTP和Socket什么关系，WebSocket和Socket就是什么关系。

HTTP 协议有一个缺陷：通信只能由客户端发起，做不到服务器主动向客户端推送信息。

WebSocket 协议在2008年诞生，2011年成为国际标准。所有浏览器都已经支持了。

它的最大特点就是，服务器可以主动向客户端推送信息，客户端也可以主动向服务器发送信息，是真正的双向平等对话，属于服务器推送技术的一种。

http://www.sohu.com/a/322257372_120104204



### websocket http grpc

WebSocket 是一个双向通信协议，它在握手阶段采用 HTTP/1.1 协议（暂时不支持 HTTP/2）。



socket不安全容易被攻击，需要结合ssl协议才安全。



Tomcat和Spring Boot默认使用HTTP1.1协议。

