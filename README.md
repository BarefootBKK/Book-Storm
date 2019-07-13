# Book Storm - 基于大数据的图书推荐系统
  
  **本项目采取【前后端分离】的模式，前端基于npm-vue，后端基于SSM + Spring Security + MySQL**
  
<img src="https://img-blog.csdnimg.cn/20190714001106538.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0hCS19NeVN1bW1lckNU,size_16,color_FFFFFF,t_70" width="700px"/>
  
<img src="https://img-blog.csdnimg.cn/20190714000720221.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0hCS19NeVN1bW1lckNU,size_16,color_FFFFFF,t_70" width="700px"/>
  
## 运行本项目

### 后端

后端服务器基于Spring + SpringMVC + MyBatis (SSM) + Spring security框架，在导入后端项目前，请确保你已经配置好Maven环境

```
1. 克隆后端项目（back-end）至本地

2. 打开后端项目，等待maven加载完成必备依赖包

3. 运行 book-main/src/main/java/com/book 目录下的 BookApplication.java
```


### 前端

前端基于vue.js

``` bash
# 克隆前端项目至本地
本项目中的front-end(web)

# 安装环境依赖
npm install

# 启动前端服务器（默认localhost:8080）
npm run dev

# 从配置中构建
npm run build

# 捆绑
npm run build --report
```

### 数据库配置

```
1. 安装MySQL：详细安装过程请百度或Google

2. 导入数据库结构配置：克隆本项目database文件夹下的sql文件，将其导入至数据库中（PS：sql文件包含了表结构和数据）
```
### 大数据相关
项目可基于Hadoop集群运行，可自行根据需求将【日志分析】与【分布式推荐算法】部署在集群上，本项目默认的是单卡日志分析与推荐算法
