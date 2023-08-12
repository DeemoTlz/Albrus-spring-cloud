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

![image-20230811195613354](./images/image-20230811195613354.png)

**停更前**：

![image-20230811195509124](./images/image-20230811195509124.png)

**新版本**：

![image-20230811195758352](./images/image-20230811195758352.png)

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

启动顺序：

1. Eureka Server * 2
2. Eureka Client Payment * 2
3. Eureka Client Consumer * 1

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

**Eureka Client Consumer 服务调用**

`OrderController.java`:

```java
// private static final String BASE_URL = "http://127.0.0.1:8001";
/**
 * 通过在 eureka 上注册过的微服务名称调用
 */
private static final String BASE_URL = "http://ALBRUS-CLOUD-PAYMENT-SERVICE";

// 2023-08-11 19:43:32.669  WARN 17336 --- [  restartedMain] iguration$LoadBalancerCaffeineWarnLogger : Spring Cloud LoadBalancer is currently working with the default cache. While this cache implementation is useful for development and tests, it's recommended to use Caffeine cache in production.You can switch to using Caffeine cache, by adding it and org.springframework.cache.caffeine.CaffeineCacheManager to the classpath.
```

##### 2.1.3.3 服务发现

`@EnableDiscoveryClient`:

```java
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class AlbrusCloudPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudPayment8001Application.class, args);
    }

}
```

`private final DiscoveryClient discoveryClient;`:

```java
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String applicationName;
    
    public PaymentController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }
    
    @GetMapping(value = "/discoveryClientInfo")
    public Result<ServiceInstance> getDiscoveryClientInfo() {
        log.info("The discovery client is: {}.", discoveryClient);

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("The service is: {}.", service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances(applicationName);
        for (ServiceInstance instance : instances) {
            log.info("The service instance details: {}, {}, {}, {}.", instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }

        return new Result<>(200, instances.get(0));
    }
}
```

#### 2.1.4 自我保护

> 当 Eureka Client 由于网络分区故障发生（延时、卡顿、拥挤）与 Eureka Server 断开连接时，Eureka Server 不会立即从服务列表中清除该 Eureka Client 服务，增加可用性（AP）。

Eureka Server 默认在 90s 没有收到 Eureka Client 的心跳时，会将 Eureka Client 服务剔除。若在 90s 内丢失了大量的服务实例心跳，这时 Eureka Server 会开启自我保护机制，不会剔除任何服务实例了。

```yaml
eureka:
  server:
    enable-self-preservation: true  # 默认开启
    
eureka:
  client:
    lease-renewal-interval-in-seconds: 30  # 租约续约间隔时间，默认 30s
    lease-expiration-duration-in-seconds: 90  # 租约到期，服务时效时间，默认值 90s，服务超过 90s 没有发⽣⼼跳，EurekaServer 会将服务从列表移除
```

#### 2.1.5 停更

[Eureka 2.0 (Discontinued)](https://github.com/Netflix/eureka/wiki)

The existing open source work on eureka 2.0 is discontinued. The code base and artifacts that were released as part of the existing repository of work on the 2.x branch is considered use at your own risk.

Eureka 1.x is a core part of Netflix's service discovery system and is still an active project.

### 2.2 ZooKeeper

> ZooKeeper 是一个分布式协调工具，可以实现注册中心功能。

#### 2.2.1 安装启动

配置文件：[zoo.cfg](./Program/ZooKeeper/zoo.cfg)

```properties
# The number of milliseconds of each tick
# 心跳时间，为了确保client-server连接存在，以毫秒为单位，最小超时时间为2个心跳时间
tickTime=2000
# The number of ticks that the initial 
# synchronization phase can take
# 多少个tickTime内，允许其他server连接并初始化数据，如果zookeeper管理的数据较大，则相应增大这个值
initLimit=10
# The number of ticks that can pass between 
# sending a request and getting an acknowledgement
# 多少个tickTime内，允许follower同步，如果follower落后太多，则会被丢弃
syncLimit=5
# the directory where the snapshot is stored.
# do not use /tmp for storage, /tmp here is just 
# example sakes.
# 用户存放内存数据库快照的文件夹，同时用于集群myid文件也存在这个文件夹里
dataDir=/home/albrus/apache-zookeeper-3.6.4-bin/data
# the port at which the clients will connect
# 客户端监听端口
clientPort=2181
```

安装启动：

```bash
tar -zxvf apache-zookeeper-3.6.4-bin.tar.gz
cp zoo.cfg ./conf
sudo ufw allow 2181
./zkServer.sh start
./zkCli.sh
```

#### 2.2.2 Provider 服务入驻

`application.yaml`:

```yaml
server:
  port: 8004

spring:
  application:
    name: albrus-cloud-payment-service  # 服务别名
  cloud:
    zookeeper:
      connect-string: 10.10.20.121:2181  # ZooKeeper
```

`@EnableDiscoveryClient`:

```java
@SpringBootApplication
@EnableDiscoveryClient
public class AlbrusCloudPayment8004Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudPayment8004Application.class, args);
    }

}
```

```bash
[zk: localhost:2181(CONNECTED) 2] ls /
[services, zookeeper]
[zk: localhost:2181(CONNECTED) 3] ls /services 
[albrus-cloud-payment-service]
```

#### 2.2.3 测试验证

`http://127.0.0.1:8004/payment/31`:

```json
{"code":200,"msg":"查询成功","data":{"id":31,"serial":"尚硅谷111"}}
```

`ZooKeeper`:

```bash
[zk: localhost:2181(CONNECTED) 13] ls /services/albrus-cloud-payment-service 
[21cfe505-2441-41d6-bc04-21c0ef7a574d]
[zk: localhost:2181(CONNECTED) 14] get /services/albrus-cloud-payment-service/21cfe505-2441-41d6-bc04-21c0ef7a574d 
{
	"name": "albrus-cloud-payment-service",
	"id": "21cfe505-2441-41d6-bc04-21c0ef7a574d",
	"address": "localhost",
	"port": 8004,
	"sslPort": null,
	"payload": {
		"@class": "org.springframework.cloud.zookeeper.discovery.ZookeeperInstance",
		"id": "albrus-cloud-payment-service",
		"name": "albrus-cloud-payment-service",
		"metadata": {
			"instance_status": "UP"
		}
	},
	"registrationTimeUTC": 1691805864932,
	"serviceType": "DYNAMIC",
	"uriSpec": {
		"parts": [{
			"value": "scheme",
			"variable": true
		}, {
			"value": "://",
			"variable": false
		}, {
			"value": "address",
			"variable": true
		}, {
			"value": ":",
			"variable": false
		}, {
			"value": "port",
			"variable": true
		}]
	}
}
```

#### 2.2.4 临时节点 && 持久节点

> 临时节点
>
> 带序号的临时节点
>
> 持久节点
>
> 带序号的持久节点

是临时节点，在**服务断连的一段时间**后，ZooKeeper 会剔除断连的服务（CP）。

在服务重新启动后，服务将以一个新节点身份重新上线。

**重启 8004**:

```bash
[zk: localhost:2181(CONNECTED) 15] ls /services/albrus-cloud-payment-service
[a22f75cf-62ad-4a94-9d74-be193afc2849]
```

#### 2.2.5 Consumer 服务入驻

`application.yaml`:

```yaml
server:
  port: 81

spring:
  application:
    name: albrus-cloud-order-service  # 服务别名
  cloud:
    zookeeper:
      connect-string: 10.10.20.121:2181  # ZooKeeper
```

`@EnableDiscoveryClient`:

```java
@SpringBootApplication
@EnableDiscoveryClient
public class AlbrusCloudConsumerOrder81Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudConsumerOrder81Application.class, args);
    }

}
```

```bash
[zk: localhost:2181(CONNECTED) 62] ls /services
[albrus-cloud-order-service, albrus-cloud-payment-service]
```

**Consumer 服务调用**

`OrderController.java`:

```java
// private static final String BASE_URL = "http://127.0.0.1:8001";
/**
 * 通过在 ZooKeeper 上注册过的微服务名称调用
 */
private static final String BASE_URL = "http://albrus-cloud-payment-service";
```

`@LoadBalanced`:

```java
/**
 * 使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡的能力
 */
@Bean
@LoadBalanced
public RestTemplate restTemplate() {
    return new RestTemplate();
}
```

### 2.3 Consul

> https://developer.hashicorp.com/consul
>
> https://www.springcloud.cc/spring-cloud-consul.html

**What is Consul?**

HashiCorp Consul is a service networking solution that enables teams to manage secure network connectivity between services and across on-prem and multi-cloud environments and runtimes. Consul offers **service discovery**, **service mesh**, **traffic management**, and **automated updates to network infrastructure device**. You can use these features individually or together in a single Consul deployment.

HashiCorp Consul 是一种服务网络解决方案，使团队能够管理服务之间以及跨本地和多云环境和运行时的安全网络连接。Consul 提供**服务发现**、**服务网格**、**流量管理**和**网络基础设施设备的自动更新**。您可以在单个 Consul 部署中单独或一起使用这些功能。

**What is service discovery?**

*Service discovery* helps you discover, track, and monitor the health of services within a network. Service discovery registers and maintains a record of all your services in a *service catalog*. This service catalog acts as a single source of truth that allows your services to query and communicate with each other.

*服务发现*可帮助您**发现**、**跟踪**和**监控**网络内服务的运行状况。*服务发现在服务目录*中注册并维护所有服务的记录。该服务目录充当单一事实来源，允许您的服务相互查询和通信。

**Benefits of service discovery**

Service discovery provides benefits for all organizations, ranging from simplified scalability to improved application resiliency. Some of the benefits of service discovery include:

- Dynamic IP address and port discovery - 动态 IP 和端口发现
- Simplified horizontal service scaling - 简化水平服务扩展
- Abstracts discovery logic away from applications - 将发现逻辑从应用程序中抽象出来
- Reliable service communication ensured by health checks - 健康检查确保可靠的服务通信
- Load balances requests across healthy service instances - 在健康的服务实例之间负载平衡请求
- Faster deployment times achieved by high-speed discovery - 通过高速发现实现更快的部署时间
- Automated service registration and de-registration - 自动服务注册和注销

**What is a service mesh?**

A *service mesh* is a dedicated network layer that provides secure service-to-service communication within and across infrastructure, including on-premises and cloud environments. Service meshes are often used with a microservice architectural pattern, but can provide value in any scenario where complex networking is involved.

服务*网格*是一个专用网络层，可在基础设施内部和跨基础设施（包括本地和云环境）提供安全的服务到服务通信。服务网格通常与微服务架构模式一起使用，但可以在涉及复杂网络的任何场景中提供价值。

**Benefits of a service mesh**

A service mesh provides benefits for all organizations, ranging from security to improved application resiliency. Some of the benefits of a service mesh include;

- service discovery - 服务发现
- application health monitoring - 应用程序健康监控
- load balancing - 负载均衡
- automatic failover - 自动故障转移
- traffic management - 流量管理
- encryption - 加密
- observability and traceability - 可观察性和可追溯性
- authentication and authorization - 认证和授权
- network automation - 网格自动化

#### 2.3.1 安装运行

```bash
wget -O- https://apt.releases.hashicorp.com/gpg | sudo gpg --dearmor -o /usr/share/keyrings/hashicorp-archive-keyring.gpg
echo "deb [signed-by=/usr/share/keyrings/hashicorp-archive-keyring.gpg] https://apt.releases.hashicorp.com $(lsb_release -cs) main" | sudo tee /etc/apt/sources.list.d/hashicorp.list
sudo apt update && sudo apt install consul
```

**运行（8500）**：

```bash
# 快捷模式
consul agent -dev -client 0.0.0.0

# Sever 模式
consul agent -server -bootstrap-expect 1 -data-dir /tmp/consul -ui -config-dir /etc/consul.d -bind=192.168.1.100

配置参数说明
-server：- Serve 模式（不配置为 Client 模式），数量一般为 3-5 个
-bootstrap-expect： - Server 数量
-data-dir： - 数据目录
-ui-dir： - UI目录
-node： - Node名称
-bind： - 集群通讯地址
Server 模式后台访问地址：http://localhost:8500
ctrl + c：停止服务

#Client 模式
consul agent -data-dir /tmp/consul -node=ubuntu64 -bind=10.9.10.176

#查看集群
consul members

#查看当前服务器状况
consul info

#退出服务器集群
consul leave
```

[配置项](https://developer.hashicorp.com/consul/docs/agent/config)（[引用中文翻译](https://www.cnblogs.com/duanxz/p/9908762.html)）：

- [`-client`](https://www.consul.io/docs/agent/options.html#_client) - Consul将绑定客户端接口的地址，包括HTTP和DNS服务器。默认情况下，这是“127.0.0.1”，只允许回送连接。在Consul 1.0和更高版本中，可以将其设置为要绑定到的空间分隔的地址列表，或者 可能会解析为多个地址的 [go-sockaddr](https://godoc.org/github.com/hashicorp/go-sockaddr/template)模板。
- [`-bind`](https://www.consul.io/docs/agent/options.html#_bind) - 应为内部集群通信绑定的地址。这是集群中所有其他节点都应该可以访问的IP地址。默认情况下，这是“0.0.0.0”，这意味着Consul将绑定到本地计算机上的所有地址，并将第一个可用的私有IPv4地址[通告](https://www.consul.io/docs/agent/options.html#_advertise)给群集的其余部分。如果有多个私有IPv4地址可用，Consul将在启动时退出并出现错误。如果你指定“[::]”，Consul 将 [做广告](https://www.consul.io/docs/agent/options.html#_advertise)第一个可用的公共IPv6地址。如果有多个公共IPv6地址可用，则Consul将在启动时退出并出现错误。Consul同时使用TCP和UDP以及相同的端口。如果您有任何防火墙，请确保同时允许这两种协议。在Consul 1.0和更高版本中，可以将其设置为要绑定到的空间分隔的地址列表，或者可能会解析为多个地址的 [go-sockaddr](https://godoc.org/github.com/hashicorp/go-sockaddr/template)模板。

#### 2.3.2 Provider 服务入驻

#### 2.2.2 Provider 服务入驻

`application.yaml`:

```yaml
server:
  port: 8005

spring:
  application:
    name: albrus-cloud-payment-service  # 服务别名
  cloud:
    consul:  # Consul
      host: 10.10.20.121
      port: 8500
      discovery:
        ip-address: 10.10.20.115
        service-name: ${spring.application.name}
        heartbeat:
          enabled: true
```

`@EnableDiscoveryClient`:

```java
@SpringBootApplication
@EnableDiscoveryClient
public class AlbrusCloudPayment8005Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudPayment8004Application.class, args);
    }

}
```

#### 2.3.3 Consumer 服务入驻

`application.yaml`:

```yaml
server:
  port: 82

spring:
  application:
    name: albrus-cloud-order-service  # 服务别名
  cloud:
    consul:  # Consul
      host: 10.10.20.121
      port: 8500
      discovery:
        ip-address: 10.10.20.115
        service-name: ${spring.application.name}
        heartbeat:
          enabled: true
```

`@EnableDiscoveryClient`:

```java
@SpringBootApplication
@EnableDiscoveryClient
public class AlbrusCloudConsumerOrder82Application {

    public static void main(String[] args) {
        SpringApplication.run(AlbrusCloudConsumerOrder82Application.class, args);
    }

}
```

**Consumer 服务调用**

`OrderController.java`:

```java
// private static final String BASE_URL = "http://127.0.0.1:8001";
/**
 * 通过在 Consul 上注册过的微服务名称调用
 */
private static final String BASE_URL = "http://albrus-cloud-payment-service";
```

`@LoadBalanced`:

```java
/**
 * 使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡的能力
 */
@Bean
@LoadBalanced
public RestTemplate restTemplate() {
    return new RestTemplate();
}
```

### 2.3 Consul

#### 2.3. ZooKeeper VS Consul

![img](./images/2231162-20201204163044945-20375914.png)
