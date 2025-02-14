# campus-book-share

## 项目说明
- **技术栈**：
  - **Spring Boot**：作为框架，简化了Java应用的开发。
  - **JPA**：用于数据访问，简化了与数据库的交互。
  - **Thymeleaf**：前端模板引擎，用于生成动态页面。
  - **MySQL**：作为数据库，用于存储用户、图书、借阅记录等信息。

- **功能**：
  - **用户管理**：用户注册、登录、修改资料等功能。
  - **图书借阅**：用户可以浏览、借阅、归还图书。
  - **评论系统**：用户可以对图书进行评论和评分。
  - **借阅记录管理**：跟踪用户的借阅历史记录。

---

## 项目结构示例

```plaintext
src/main/java
├── com.example.campusbookshare                # 主包，包含所有的功能模块
│   ├── CampusBookShareApplication.java        # 主应用程序入口
│   ├── controller                             # 控制器层：处理 HTTP 请求
│   │   ├── UserController.java               # 用户控制器：用户相关的接口
│   │   ├── BookController.java               # 图书控制器：图书相关的接口
│   │   ├── BorrowRecordController.java       # 借阅记录控制器：借阅相关的接口
│   │   └── ReviewController.java             # 评论控制器：评论相关的接口
│   ├── service                                # 服务层：封装业务逻辑
│   │   ├── UserService.java                  # 用户服务：处理用户业务逻辑
│   │   ├── BookService.java                  # 图书服务：处理图书业务逻辑
│   │   ├── BorrowRecordService.java          # 借阅记录服务：处理借阅记录业务逻辑
│   │   └── ReviewService.java                # 评论服务：处理评论业务逻辑
│   ├── repository                             # 数据访问层：与数据库交互
│   │   ├── UserRepository.java               # 用户数据访问接口：管理用户数据
│   │   ├── BookRepository.java               # 图书数据访问接口：管理图书数据
│   │   ├── BorrowRecordRepository.java       # 借阅记录数据访问接口：管理借阅记录数据
│   │   └── ReviewRepository.java             # 评论数据访问接口：管理评论数据
│   ├── model                                  # 实体类：定义数据结构
│   │   ├── User.java                         # 用户实体类：用户的数据结构
│   │   ├── Book.java                         # 图书实体类：图书的数据结构
│   │   ├── BorrowRecord.java                 # 借阅记录实体类：借阅记录的数据结构
│   │   └── Review.java                       # 评论实体类：评论的数据结构
│   └── dto                                    # 数据传输对象：客户端与服务器的数据交互
│       ├── LoginRequest.java                 # 登录请求对象：用于登录数据传输
│       └── ...                               # 其他 DTO 类：用于其他数据传输的类
```
---

## 用户注册功能流程
### 1.应用程序入口
#### 文件：`CampusBookShareApplication.java`

```java
package com.example.campusbookshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CampusBookShareApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusBookShareApplication.class, args);
    }
}
```
#### 逻辑流程
##### 启动应用程序：
- 当运行 `CampusBookShareApplication` 类的 `main` 方法时，Spring Boot 应用程序启动。
- `SpringApplication.run()` 方法会初始化 Spring 应用程序上下文，加载所有 Spring 配置和组件。

##### 自动配置：
- `@SpringBootApplication` 注解包含了以下三个重要注解：
  - **@EnableAutoConfiguration**：自动配置 Spring Boot 的各种组件（如数据库连接、Web 服务器等）。
  - **@ComponentScan**：扫描当前包及其子包中的所有 Spring 组件（如 `@Component`、`@Service`、`@Repository`、`@Controller` 等）。
  - **@Configuration**：标记该类为 Spring 配置类。
    
### 2. 用户实体类

#### 文件：User.java
```java
package com.example.campusbookshare.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    // Getters and Setters
}
```
#### 逻辑流程
##### 实体类定义：
- `@Entity`：标记该类为 JPA 实体类，对应数据库中的表。
- `@Table(name = "user")`：指定实体类对应的数据库表名为 user。
- `@Id`：标记主键字段。
- `@GeneratedValue(strategy = GenerationType.IDENTITY)`：主键生成策略为自增。
- `@Column`：定义字段的列属性，如 nullable、unique 等。
- `@Temporal(TemporalType.TIMESTAMP)`：定义日期类型字段。

### 3. 用户数据访问层
#### 文件：UserRepository.java
```java
package com.example.campusbookshare.repository;

import com.example.campusbookshare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
```
#### 逻辑流程
##### 继承 `JpaRepository`：
- `JpaRepository` 提供了基本的 CRUD 操作（如 `save`、`findById`、`findAll`、`delete` 等）。

##### `UserRepository` 继承 `JpaRepository<User, Integer>`：
- 表示该接口是 `User` 实体类的仓库，主键类型为 `Integer`。

##### 自定义查询方法：
- `findByUsername(String username)`：根据用户名查询用户。
- Spring Data JPA 会自动根据方法名称生成查询语句。

### 4. 用户业务逻辑层
#### 文件：UserService.java
```java
package com.example.campusbookshare.service;

import com.example.campusbookshare.model.User;
import com.example.campusbookshare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        user.setCreated_at(new Date());
        return userRepository.save(user);
    }
}
```
#### 逻辑流程
##### 依赖注入：
- `@Autowired`：自动注入 `UserRepository`，用于操作数据库。

##### 业务逻辑：
- **`registerUser(User user)`**：
  - 设置用户的创建时间 `created_at` 为当前时间。
  - 调用 `userRepository.save(user)` 将用户信息保存到数据库。
  - 返回保存后的用户对象。

### 5. 用户控制器层
#### 文件：UserController.java
```java
package com.example.campusbookshare.controller;

import com.example.campusbookshare.model.User;
import com.example.campusbookshare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
```
#### 逻辑流程
##### 依赖注入：
- `@Autowired`：自动注入 `UserService`，用于处理业务逻辑。

##### RESTful API：
- `@RestController`：标记该类为 RESTful 控制器，返回 JSON 格式的数据。
- `@RequestMapping("/api/users")`：定义基础路径为 `/api/users`。
- `@PostMapping("/register")`：定义 POST 请求路径为 `/api/users/register`。

##### 处理请求：
- **`registerUser(@RequestBody User user)`**：
  - 接收客户端发送的 JSON 数据，自动映射为 `User` 对象。
  - 调用 `userService.registerUser(user)` 处理用户注册。
  - 返回注册后的用户对象。

### 6. 运行逻辑流程总结
##### 启动应用程序：
- 运行 `CampusBookShareApplication`，Spring Boot 初始化应用程序上下文。
##### 客户端发送请求：
- 客户端（如浏览器或 Postman）发送 HTTP 请求到 `/api/users/register`，请求体包含用户信息的 JSON 数据。
##### 控制器接收请求：
- `UserController` 接收请求，调用 `userService.registerUser(user)`。
##### 业务逻辑处理：
- `UserService` 设置用户的创建时间，调用 `userRepository.save(user)` 保存用户信息到数据库。
##### 返回响应：
- `UserService` 返回保存后的用户对象，`UserController` 将其转换为 JSON 格式返回给客户端。
