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

