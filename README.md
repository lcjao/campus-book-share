# campus-book-share
## 图书共享平台
### 项目结构示例
src/main/java
├── com.example.campusbookshare
│   ├── CampusBookShareApplication.java  # 主应用程序入口
│   ├── controller                       # 控制器层
│   │   ├── UserController.java          # 用户控制器
│   │   ├── BookController.java          # 图书控制器
│   │   ├── BorrowRecordController.java  # 借阅记录控制器
│   │   └── ReviewController.java        # 评论控制器
│   ├── service                          # 服务层
│   │   ├── UserService.java             # 用户服务
│   │   ├── BookService.java             # 图书服务
│   │   ├── BorrowRecordService.java     # 借阅记录服务
│   │   └── ReviewService.java           # 评论服务
│   ├── repository                       # 数据访问层
│   │   ├── UserRepository.java          # 用户数据访问接口
│   │   ├── BookRepository.java          # 图书数据访问接口
│   │   ├── BorrowRecordRepository.java  # 借阅记录数据访问接口
│   │   └── ReviewRepository.java        # 评论数据访问接口
│   ├── model                            # 实体类
│   │   ├── User.java                    # 用户实体类
│   │   ├── Book.java                    # 图书实体类
│   │   ├── BorrowRecord.java            # 借阅记录实体类
│   │   └── Review.java                  # 评论实体类
│   └── dto                              # 数据传输对象
│       ├── LoginRequest.java            # 登录请求对象
│       └── ...                         # 其他 DTO 类
