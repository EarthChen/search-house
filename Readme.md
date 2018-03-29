# 基于es的搜房网

## 环境

1. mysql 5.7
2. spring boot 1.5.6
3. redis
4. es 5.6.7
5. jpa
6. rabbitmq

## 技术点

1. 使用七牛云oss进行文件上传
2. 使用spring-session 将session存储在redis中
5. jpa的动态查询条件
6. com.earthchen.spring.boot.searchhouse.constant.RentValueBlock  带区间的常用数值定义
7. 使用es构建搜索引擎
8. 使用rabbitmq作为消息队列，进行异步处理
