# blog 
### 个人练手，写的贼烂


# 采坑记录(给自己看的)
### 1. 使用mybatis-plus报异常
`Invalid bound statement (not found)`

原因是：mybatis和mybatis-plus在application.yml的配置不一样  
mybatis的配置是以mybatis为前缀  
mubatis-plus的配置是以mybatis-plus为前缀