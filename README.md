# Spring Cloud Learn
## 一、版本管理

**版本约束：https://start.spring.io/actuator/info**

```json
{
    "bom-ranges": {
        "spring-cloud": {
            "2021.0.8": "Spring Boot >=2.6.0 and <3.0.0",
            "2022.0.3": "Spring Boot >=3.0.0 and <3.2.0-M1"
        }
    }
}
```

### 1.1 Spring Boot
> https://spring.io/projects/spring-boot#learn

| Spring Boot Versiojn | JDK    | Release Notes                                                | Spring Framework Version |
| -------------------- | ------ | ------------------------------------------------------------ | ------------------------ |
| 3.x                  | JDK 17 | [here](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Release-Notes) | 6.0.x                    |
| 2.7.x                | JDK 8  | [here](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.7-Release-Notes) | 5.3.20+                  |
| 2.6.x                | JDK 8  | [here](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.6-Release-Notes) | 5.3.13+                  |

### 1.2 Spring Cloud

> https://spring.io/projects/spring-cloud#overview

If you an existing Spring Boot app you want to add Spring Cloud to that app, the first step is to determine the version of Spring Cloud you should use. The version you use in your app will depend on the version of Spring Boot you are using.

The table below outlines which version of Spring Cloud maps to which version of Spring Boot.

Table 1. Release train Spring Boot compatibility

| Release Train                                                | Release Train                         |
| ------------------------------------------------------------ | ------------------------------------- |
| [2022.0.x](https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-2022.0-Release-Notes) aka Kilburn | 3.0.x, 3.1.x (Starting with 2022.0.3) |
| [2021.0.x](https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-2021.0-Release-Notes) aka Jubilee | 2.6.x, 2.7.x (Starting with 2021.0.3) |
| [2020.0.x](https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-2020.0-Release-Notes) aka Ilford | 2.4.x, 2.5.x (Starting with 2020.0.3) |
| [Hoxton](https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-Hoxton-Release-Notes) | 2.2.x, 2.3.x (Starting with SR5)      |
| [Greenwich](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Greenwich-Release-Notes) | 2.1.x                                 |
| [Finchley](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Finchley-Release-Notes) | 2.0.x                                 |
| [Edgware](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Edgware-Release-Notes) | 1.5.x                                 |
| [Dalston](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Dalston-Release-Notes) | 1.5.x                                 |

> Spring Cloud Dalston, Edgware, Finchley, and Greenwich have all reached end of life status and are no longer supported.

如果同时使用 springboot 和 springcloud ，需要照顾 springcloud ，由 springcloud 决定 springboot 的版本。

> https://docs.spring.io/spring-cloud/docs/2021.0.8/reference/html/

![image-20230722214107238](images/image-20230722214107238.png)

### 1.3 Spring Cloud Alibaba

> https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E

**2021.x 分支**

适配 Spring Boot 2.4，Spring Cloud 2021.x 版本及以上的 Spring Cloud Alibaba 版本按从新到旧排列如下表（最新版本用*标记）：

| Spring Cloud Alibaba Version | Spring Cloud Version  | Spring Boot Version |
| ---------------------------- | --------------------- | ------------------- |
| 2021.0.5.0*                  | Spring Cloud 2021.0.5 | 2.6.13              |
| 2021.0.4.0                   | Spring Cloud 2021.0.4 | 2.6.11              |
| 2021.0.1.0                   | Spring Cloud 2021.0.1 | 2.6.3               |
| 2021.1                       | Spring Cloud 2020.0.1 | 2.4.2               |

### 1.4 版本选择

| Spring Cloud | Spring Boot | Spring Cloud Alibaba |
| ------------ | ----------- | -------------------- |
| 2022.0.3     | 3.0.7       | 2022.0.0.0-RC2       |
| **2021.0.8** | **2.6.15**  | **2021.0.5.0**       |

## 二、微服务组件

### 2.1 Eureka

服务注册中心，已停止更新。

1. 服务治理

   在传统的 RPC 远程调用框架中，管理每个服务与服务之间依赖关系比较复杂，管理比较复杂，所以需要使用服务治理，管理服务于服务之间依赖关系，可以实现服务调用、负载均衡、容错等，实现服务发现与注册。

2. 服务注册与发现

   Eureka 采用了 CS 的设计架构，Eureka Server 作为服务注册功能的服务器，它是**服务注册中心**。而系统中的其他微服务，使用 **Eureka Client** 连接到 **Eureka Server** 并维持**心跳**连接。这样系统的维护人员就可以通过 Eureka Server 来**监控**系统中各个微服务是否正常运行。
   在服务注册与发现中，有一个注册中心。当服务器启动的时候，会把当前自己服务器的信息比如：服务地址通讯地址等以**别名**方式注册到注册中心上。另一方（消费者|服务提供者），**以该别名的方式去注册中心上获取到实际的服务通讯地址，然后再实现本地 RPC 调用**。

   RPC 远程调用框架核心设计思想：在于注册中心，因为使用注册中心管理每个服务与服务之间的一个依赖关系（服务治理概念）。在任何 RPC 远程框架中，都会有一个注册中心（存放服务地址相关信息(接口地址））

**Eureka VS Dubbo**：

![image-20230803222944947](./images/image-20230803222944947.png)

Eureka 包含两个组件：Eureka Server 和 Eureka Client。

1. Eureka Server

   提供服务注册服务，各个微服务节点通过配置启动后，会在 Eureka Server 中进行注册，这样 Eureka Server 中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观看到。

2. Eureka Client

   通过注册中心进行访问，是一个 Java 客户端，用于简化 Eureka Server 的交互，客户端同时也具备一个内置的、使用轮询（round-robin）负载算法的负载均衡器。

   在应用启动后，客户端将会向 Eureka Server 发送心跳（默认周期为 30 秒）。如果 Eureka Server 在多个心跳周期内没有接收到某个节点的心跳，Eureka Server 将会从服务注册表中把这个服务节点移除（默认 90 秒）。

#### 2.1.1 Eureka Server

`pom.xml`:

```xml
<!-- eureka-server -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

`application.yaml`:

```yaml
server:
  port: 7001

eureka:
  server:
    eviction-interval-timer-in-ms: 60  # 定期检测实例状态（心跳机制） 默认60s
    enable-self-preservation: true  # 关闭自我保护 默认为打开状态，生产环境建议打开
  instance:
    hostname: localhost  # eureka 服务器实例名称
  client:
    register-with-eureka: false  # 不向注册中心注册自己
    fetch-registry: false  # false 表示本机是注册中心
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/  # 设置与 eureka 的交互地址
```

`Application.java`:

```java
@EnableEurekaServer
@SpringBootApplication
public class AlbrusCloudEurekaServer7001Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudEurekaServer7001Application.class);
    }

}
```

![image-20230807211826190](./images/image-20230807211826190.png)

EurekaServer 自我保护机制：

![image-20230807212117315](./images/image-20230807212117315.png)

#### 2.1.2 Eureka Client

##### 2.1.2.1 Provider

`pom.xml`:

```xml
<!-- eureka-client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

`application.yaml`:

```yaml
server:
  port: 8001

spring:
  application:
    name: albrus-cloud-payment-service  # 注意在 EurekaServer 中 Application 名称

eureka:
  client:
    register-with-eureka: true  # 将自己注册到 EurekaServer
    fetch-registry: true  # 是否从 EurekaServer 抓取已有的注册信息，默认为 true。单节点无所谓，集群必须设置为 true 才能配合 ribbon 使用负载均衡
    service-url:
      defaultZone: http://localhost:7001/eureka/  # 路径包含 /eureka 是因为 EurekaServer 内部有 web 过滤器
    registry-fetch-interval-seconds: 30  # 隔多久从服务中心拉取一次服务列表，默认 30s
  instance:
    # 使用 IP 注册，否则会使用主机注册（此处考虑老版本的兼容，新版本经过实验都是 IP）
    prefer-ip-address: true
    # 自定义实例显示格式，加上版本号便于多版本管理，注意是 ip-address，早期版本是 ipaddress
    instance-id: ${spring.cloud.client.ip-address}:${spring.application.name}:${server.port}:@project.version@
    # 自定义元数据（key/value 结构）
    metadata-map:
      cluster: cll
      region: rnl
    lease-renewal-interval-in-seconds: 30  # 租约续约间隔时间，默认 30s
    lease-expiration-duration-in-seconds: 90  # 租约到期，服务时效时间，默认值 90s，服务超过 90s 没有发⽣⼼跳，EurekaServer 会将服务从列表移除
```

`Application.java`:

```java
@EnableEurekaClient
@SpringBootApplication
public class AlbrusCloudPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudPayment8001Application.class, args);
    }

}
```

![image-20230807211930506](./images/image-20230807211930506.png)

##### 2.1.2.2 Consumer

`pom.xml`:

```xml
<!-- eureka-client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

`application.yaml`:

```yaml
server:
  port: 80

spring:
  application:
    name: albrus-cloud-order-service

eureka:
  client:
    register-with-eureka: true  # 将自己注册到 EurekaServer
    fetch-registry: true  # 是否从 EurekaServer 抓取已有的注册信息，默认为 true。单节点无所谓，集群必须设置为 true 才能配合 ribbon 使用负载均衡
    service-url:
      defaultZone: http://localhost:7001/eureka/  # 路径包含 /eureka 是因为 EurekaServer 内部有 web 过滤器
    registry-fetch-interval-seconds: 30  # 隔多久从服务中心拉取一次服务列表，默认 30s
  instance:
    # 使用 IP 注册，否则会使用主机注册（此处考虑老版本的兼容，新版本经过实验都是 IP）
    prefer-ip-address: true
    # 自定义实例显示格式，加上版本号便于多版本管理，注意是 ip-address，早期版本是 ipaddress
    instance-id: ${spring.cloud.client.ip-address}:${spring.application.name}:${server.port}:@project.version@
    # 自定义元数据（key/value 结构）
    metadata-map:
      cluster: cll
      region: rnl
    lease-renewal-interval-in-seconds: 30  # 租约续约间隔时间，默认 30s
    lease-expiration-duration-in-seconds: 90  # 租约到期，服务时效时间，默认值 90s，服务超过 90s 没有发⽣⼼跳，EurekaServer 会将服务从列表移除
```

`Application.java`:

```java
@EnableEurekaClient
@SpringBootApplication
public class AlbrusCloudConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudConsumerOrder80Application.class, args);
    }

}
```

![image-20230807213256305](./images/image-20230807213256305.png)

#### 2.1.3 Eureka 集群

![image-20230807213938814](./images/image-20230807213938814.png)

单点故障：**集群，负载均衡 + 故障容错**。

##### 2.1.3.1 Eureka Server 集群

> **互相注册、互相守望**：[A、B、C] -> [A: [B、C]、B[A、C]、C[A、B]]。

`org.springframework.cloud.netflix.eureka.EurekaClientConfigBean#getEurekaServerServiceUrls`:

```java
@Override
public List<String> getEurekaServerServiceUrls(String myZone) {
    // 从 application.yaml 中获取 service-url 
    String serviceUrls = this.serviceUrl.get(myZone);
    if (serviceUrls == null || serviceUrls.isEmpty()) {
        // 最后会尝试获取 DEFAULT_ZONE = defaultZone 
        serviceUrls = this.serviceUrl.get(DEFAULT_ZONE);
    }
    
    if (!StringUtils.isEmpty(serviceUrls)) {
        // 按 , 分割获取到的服务路径
        final String[] serviceUrlsSplit = StringUtils.commaDelimitedListToStringArray(serviceUrls);
        List<String> eurekaServiceUrls = new ArrayList<>(serviceUrlsSplit.length);
        for (String eurekaServiceUrl : serviceUrlsSplit) {
            // 给结尾添加 /
            if (!endsWithSlash(eurekaServiceUrl)) {
                eurekaServiceUrl += "/";
            }
            eurekaServiceUrls.add(eurekaServiceUrl.trim());
        }
        return eurekaServiceUrls;
    }

    return new ArrayList<>();
}
```

`application.yaml`:

```yaml
# Eureka Server 7001
server:
  port: 7001

eureka:
  server:
    eviction-interval-timer-in-ms: 60  # 定期检测实例状态（心跳机制） 默认60s
    enable-self-preservation: true  # 关闭自我保护 默认为打开状态，生产环境建议打开
  instance:
    hostname: eureka7001.com  # eureka 服务器实例名称
  client:
    register-with-eureka: false  # 不向注册中心注册自己
    fetch-registry: false  # false 表示本机是注册中心
    service-url:
      defaultZone: http://eureka7001.com:7001/eureka/  # 设置与 eureka 的交互地址，用 , 分割配置多个地址

# Eureka Server 7002
server:
  port: 7002

eureka:
  server:
    eviction-interval-timer-in-ms: 60  # 定期检测实例状态（心跳机制） 默认60s
    enable-self-preservation: true  # 关闭自我保护 默认为打开状态，生产环境建议打开
  instance:
    hostname: eureka7002.com  # eureka 服务器实例名称
  client:
    register-with-eureka: false  # 不向注册中心注册自己
    fetch-registry: false  # false 表示本机是注册中心
    service-url:
      defaultZone: http://eureka7002.com:7002/eureka/  # 设置与 eureka 的交互地址，用 , 分割配置多个地址
```

**Eureka Client Provider 注册**

`application.yaml`:

```yaml
server:
  port: 8001

spring:
  application:
    name: albrus-cloud-payment-service

eureka:
  client:
    register-with-eureka: true  # 将自己注册到 EurekaServer
    fetch-registry: true  # 是否从 EurekaServer 抓取已有的注册信息，默认为 true。单节点无所谓，集群必须设置为 true 才能配合 ribbon 使用负载均衡
    service-url:
      # defaultZone: http://localhost:7001/eureka/  # 路径包含 /eureka 是因为 EurekaServer 内部有 web 过滤器
      defaultZone: http://eureka7001.com:7001/eureka/, http://eureka7002.com:7002/eureka/  # 集群配置
    registry-fetch-interval-seconds: 30  # 隔多久从服务中心拉取一次服务列表，默认 30s
  instance:
    # 使用 IP 注册，否则会使用主机注册（此处考虑老版本的兼容，新版本经过实验都是 IP）
    prefer-ip-address: true
    # 自定义实例显示格式，加上版本号便于多版本管理，注意是 ip-address，早期版本是 ipaddress
    instance-id: ${spring.cloud.client.ip-address}:${spring.application.name}:${server.port}:@project.version@
    # 自定义元数据（key/value 结构）
    metadata-map:
      cluster: cll
      region: rnl
    lease-renewal-interval-in-seconds: 30  # 租约续约间隔时间，默认 30s
    lease-expiration-duration-in-seconds: 90  # 租约到期，服务时效时间，默认值 90s，服务超过 90s 没有发⽣⼼跳，EurekaServer 会将服务从列表移除
```

**Eureka Client Consumer 注册**

`application.yaml`:

```yaml
server:
  port: 80

spring:
  application:
    name: albrus-cloud-order-service

eureka:
  client:
    register-with-eureka: true  # 将自己注册到 EurekaServer
    fetch-registry: true  # 是否从 EurekaServer 抓取已有的注册信息，默认为 true。单节点无所谓，集群必须设置为 true 才能配合 ribbon 使用负载均衡
    service-url:
      # defaultZone: http://localhost:7001/eureka/  # 路径包含 /eureka 是因为 EurekaServer 内部有 web 过滤器
      defaultZone: http://eureka7001.com:7001/eureka/, http://eureka7002.com:7002/eureka/  # 集群配置
    registry-fetch-interval-seconds: 30  # 隔多久从服务中心拉取一次服务列表，默认 30s
  instance:
    # 使用 IP 注册，否则会使用主机注册（此处考虑老版本的兼容，新版本经过实验都是 IP）
    prefer-ip-address: true
    # 自定义实例显示格式，加上版本号便于多版本管理，注意是 ip-address，早期版本是 ipaddress
    instance-id: ${spring.cloud.client.ip-address}:${spring.application.name}:${server.port}:@project.version@
    # 自定义元数据（key/value 结构）
    metadata-map:
      cluster: cll
      region: rnl
    lease-renewal-interval-in-seconds: 30  # 租约续约间隔时间，默认 30s
    lease-expiration-duration-in-seconds: 90  # 租约到期，服务时效时间，默认值 90s，服务超过 90s 没有发⽣⼼跳，EurekaServer 会将服务从列表移除
```

##### 2.1.3.2 Eureka Client 集群

**Eureka Client Provider**

`application.xml`:

```yaml
server:
  port: 8001

spring:
  application:
    name: albrus-cloud-payment-service

eureka:
  client:
    register-with-eureka: true  # 将自己注册到 EurekaServer
    fetch-registry: true  # 是否从 EurekaServer 抓取已有的注册信息，默认为 true。单节点无所谓，集群必须设置为 true 才能配合 ribbon 使用负载均衡
    service-url:
      # defaultZone: http://localhost:7001/eureka/  # 路径包含 /eureka 是因为 EurekaServer 内部有 web 过滤器
      defaultZone: http://eureka7001.com:7001/eureka/, http://eureka7002.com:7002/eureka/  # 集群配置
    registry-fetch-interval-seconds: 30  # 隔多久从服务中心拉取一次服务列表，默认 30s
  instance:
    # 使用 IP 注册，否则会使用主机注册（此处考虑老版本的兼容，新版本经过实验都是 IP）
    prefer-ip-address: true
    # 自定义实例显示格式，加上版本号便于多版本管理，注意是 ip-address，早期版本是 ipaddress
    instance-id: ${spring.cloud.client.ip-address}:${spring.application.name}:${server.port}:@project.version@
    # 自定义元数据（key/value 结构）
    metadata-map:
      cluster: cll
      region: rnl
    lease-renewal-interval-in-seconds: 30  # 租约续约间隔时间，默认 30s
    lease-expiration-duration-in-seconds: 90  # 租约到期，服务时效时间，默认值 90s，服务超过 90s 没有发⽣⼼跳，EurekaServer 会将服务从列表移除
    
server:
  port: 8002

spring:
  application:
    name: albrus-cloud-payment-service

eureka:
  client:
    register-with-eureka: true  # 将自己注册到 EurekaServer
    fetch-registry: true  # 是否从 EurekaServer 抓取已有的注册信息，默认为 true。单节点无所谓，集群必须设置为 true 才能配合 ribbon 使用负载均衡
    service-url:
      # defaultZone: http://localhost:7001/eureka/  # 路径包含 /eureka 是因为 EurekaServer 内部有 web 过滤器
      defaultZone: http://eureka7001.com:7001/eureka/, http://eureka7002.com:7002/eureka/  # 集群配置
    registry-fetch-interval-seconds: 30  # 隔多久从服务中心拉取一次服务列表，默认 30s
  instance:
    # 使用 IP 注册，否则会使用主机注册（此处考虑老版本的兼容，新版本经过实验都是 IP）
    prefer-ip-address: true
    # 自定义实例显示格式，加上版本号便于多版本管理，注意是 ip-address，早期版本是 ipaddress
    instance-id: ${spring.cloud.client.ip-address}:${spring.application.name}:${server.port}:@project.version@
    # 自定义元数据（key/value 结构）
    metadata-map:
      cluster: cll
      region: rnl
    lease-renewal-interval-in-seconds: 30  # 租约续约间隔时间，默认 30s
    lease-expiration-duration-in-seconds: 90  # 租约到期，服务时效时间，默认值 90s，服务超过 90s 没有发⽣⼼跳，EurekaServer 会将服务从列表移除
```

**Eureka Client Consumer 调用**

`OrderController.java`:

```java
// private static final String BASE_URL = "http://127.0.0.1:8001";
/**
 * 通过在 eureka 上注册过的微服务名称调用
 */
private static final String BASE_URL = "http://ALBRUS-CLOUD-PAYMENT-SERVICE";
```

