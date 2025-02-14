# campus-book-share
## 图书共享平台

### 项目说明
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

### 项目结构示例

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
