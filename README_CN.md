# GMall 系统

该仓库包含完整的 GMall 系统，包括后端、前端和数据库设置。

## 后端

后端服务使用 Spring Boot 和 MyBatis Plus 开发。它提供了用于数据管理和前端与数据库之间交互的 API。

### 前提条件

在开始之前，请确保已安装以下软件：

- **Java 17**
- **Maven 3.6+**
- **MySQL Server**
- **IDE（推荐使用 IntelliJ IDEA 或 Eclipse）**

### 环境设置

1. **克隆仓库**：

   ```bash
   git clone https://github.com/wwwqqqzzz/gmall-system.git
   cd gmall-system/BackEnd
   ```

2. **配置 MySQL 数据库**：

   - 创建一个项目用的数据库（例如 `gmall`）。

   - 在 `src/main/resources` 目录中更新 `application.yml` 文件，填写你的 MySQL 连接信息：

     ```yaml
     server:
       ip: YOUR_SERVER_IP
       port: YOUR_SERVER_PORT
     
     spring:
       datasource:
         driver-class-name: com.mysql.cj.jdbc.Driver
         url: jdbc:mysql://YOUR_DATABASE_HOST:YOUR_DATABASE_PORT/YOUR_DATABASE_NAME?serverTimezone=GMT%2b8
         username: YOUR_DATABASE_USERNAME
         password: YOUR_DATABASE_PASSWORD
     
     mybatis:
       mapper-locations: classpath:mapper/*.xml
     
     mybatis-plus:
       configuration:
         log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
     
     files:
       upload:
         path: YOUR_UPLOAD_PATH
     ```

     将占位符（例如 `YOUR_SERVER_IP`、`YOUR_DATABASE_USERNAME`）替换为你的具体值。

3. **安装依赖**：

   ```bash
   mvn clean install
   ```

4. **生成代码（可选）**：
   如果你想为模型、映射器和服务生成代码，请配置 `MyBatis Plus Generator` 并运行它。

### 如何运行

1. **启动应用程序**：
   使用 IDE 或 Maven 启动应用程序：

   - **使用 Maven**：

     ```bash
     mvn spring-boot:run
     ```

   - **使用 IDE**：
     找到主类 `com.GMall.BackEnd.BackEndApplication` 并运行它。

2. **访问 API**：
   默认情况下，应用程序在端口 `9090` 上运行。你可以通过以下地址访问 API：

   - Swagger UI: [http://YOUR_SERVER_IP:9090/swagger-ui/](http://YOUR_SERVER_IP:9090/swagger-ui/)

## 前端

前端服务使用 Vue.js 和 ElementUI 开发。

### 设置

1. **导航到前端目录**：

   ```bash
   cd gmall-system/FrontEnd
   ```

2. **配置服务器 IP**：
   在 `public/config.js` 文件中更新你的后端服务器 IP：

   ```javascript
   export const serverIp = 'YOUR_SERVER_IP';
   ```

3. **安装依赖并启动前端**：

   ```bash
   npm install
   npm run serve
   ```

4. **访问前端**：
   默认情况下，前端在端口 `8080` 上运行。打开浏览器并导航到：

   ```
   http://localhost:8080
   ```

## 数据库

数据库架构和初始数据包含在仓库中。

### 设置

1. **找到 SQL 脚本**：
   SQL 脚本位于仓库的 `database` 文件夹中：

   ```bash
   cd gmall-system/database
   ```

2. **导入数据库架构**：
   运行 SQL 脚本以设置所需的表：

   ```bash
   mysql -u YOUR_DATABASE_USERNAME -p YOUR_DATABASE_NAME < gmall.sql
   ```

3. **验证数据库**：
   确保表和初始数据已正确导入，通过检查数据库结构进行验证。

## 包含的依赖项

- **Spring Boot Web**：用于创建 REST API。
- **MyBatis Plus**：用于简化数据库交互。
- **MySQL Connector**：用于连接 MySQL。
- **Lombok**：减少样板代码。
- **Swagger**：用于 API 文档。
- **Hutool**：Java 的实用工具库。
- **Apache POI**：用于处理 Excel 文件。
- **Java JWT**：用于 JSON Web Token 身份验证。

## 附加说明

- 确保 MySQL 正在运行并可访问，然后再启动应用程序。
- 在开发过程中使用 Swagger 测试 API。
- 日志存储在默认配置中；你可以在 `application.yml` 中调整日志级别。

## 故障排除

- **依赖问题**：
  运行以下命令以解决：

  ```bash
  mvn dependency:resolve
  ```

- **端口冲突**：
  在 `application.yml` 中更改服务器端口：

  ```yaml
  server:
    port: 8081
  ```