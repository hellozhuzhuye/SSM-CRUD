# SSM-CRUD
  基于Maven+SpringMVC+Spring+MyBatis+Bootstrap的组合，快速开发一个完整的CRUD功能，除了对框架组合的基本使用外，还涉及到许多的开发细节：Bootstrap搭建页面，MyBatis逆向工程使用，Rest风格的URI，@ResponseBody注解完成AJAX，AJAX发送PUT请求的问题，jQuery前端校验等。

SSM-CRUD:SpringMVC+Spring+MyBatis CRUD：Create（创建） Retrieve（查询） Update（更新） Delete（删除）  

功能点  
• 1、分页  
• 2、数据校验  
• jquery前端校验+JSR303后端校验  
• 3、ajax  
• 4、Rest风格的URI；使用HTTP协议请求方式的动词，来表示对资 源的操作（GET（查询），POST（新增），PUT（修改），DELETE （删除））  


技术点  
• 基础框架-ssm（SpringMVC+Spring+MyBatis）  
• 数据库-MySQL  
• 前端框架-bootstrap快速搭建简洁美观的界面  
• 项目的依赖管理-Maven  
• 分页-pagehelper  
• 逆向工程-MyBatis Generator  


基础环境搭建  
• 1、创建一个maven工程  
• 2、引入项目依赖的jar包  
• spring  
• springmvc  
• mybatis  
• 数据库连接池，驱动包  
• 其他（jstl，servlet-api，junit）  
• 3、引入bootstrap前端框架  
• 4、编写ssm整合的关键配置文件  
• web.xml，spring,springmvc,mybatis，使用mybatis的逆向工程生成对应的bean以及mapper  
• 5、测试mapper  


# 查
![image](https://github.com/hellozhuzhuye/SSM-CRUD/blob/master/images/1.png)

查询
• 1、访问index.jsp页面  
• 2、index.jsp页面发送出查询员工列表请求 
• 3、EmployeeController来接受请求，查出员工数据  
• 4、来到list.jsp页面进行展示  
• 5、pageHelper分页插件完成分页查询功能  
• URI：/emps  

查询-ajax  
• 1、index.jsp页面直接发送ajax请求进行员工分页数据的查询  
• 2、服务器将查出的数据，以json字符串的形式返回给浏览器  
• 3、浏览器收到js字符串。可以使用js对json进行解析，使用js通过 dom增删改改变页面。  
• 4、返回json。实现客户端的无关性。 


# 增
![image](https://github.com/hellozhuzhuye/SSM-CRUD/blob/master/images/2.png)
新增-逻辑  
• 1、在index.jsp页面点击”新增”   
• 2、弹出新增对话框  
• 3、去数据库查询部门列表，显示在对话框中  
• 4、用户输入数据，并进行校验 • jquery前端校验，ajax用户名重复校验，重要数据（后端校验(JSR303)，唯一约束）；  
• 5、完成保存  
• URI:   
• /emp/{id} GET 查询员工   
• /emp  POST 保存员工   
• /emp/{id}  PUT  修改员工   
• /emp/{id}  DELETE 删除员工  

# 改
![image](https://github.com/hellozhuzhuye/SSM-CRUD/blob/master/images/3.png)
修改-逻辑   
• 1、点击编辑   
• 2、弹出用户修改的模态框（显示用户信息）   
• 3、点击更新，完成用户修改  

# 删

## 单个删除
![image](https://github.com/hellozhuzhuye/SSM-CRUD/blob/master/images/5.png)
## 批量删除
![image](https://github.com/hellozhuzhuye/SSM-CRUD/blob/master/images/4.png)
删除-逻辑  
• 1、单个删除   
• URI:/emp/{id}  DELETE   
• 2、批量删除  
# 总结

![image](https://github.com/hellozhuzhuye/SSM-CRUD/blob/master/images/6.png)

