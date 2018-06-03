## 功能介绍

>- 0、暂时不提供页面，只提供接口
>- 1、多数卷切换
>- 2、定时任务管理调度，包括任务的增删改查


## 坑
#### 1、sb对quzrtz的支持，必须引入下面的包，尤其是spring-context-support这个包，千万不要引入错了
```$java
<!--quartz-->
        <!-- 该依赖必加，里面有spring对schedule的支持 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>4.1.6.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.quartz-scheduler</groupId>
            <artifactId>quartz-jobs</artifactId>
            <version>2.2.1</version>
        </dependency>
        <dependency>
            <groupId>org.quartz-scheduler</groupId>
            <artifactId>quartz</artifactId>
            <version>2.2.1</version>
        </dependency>
```