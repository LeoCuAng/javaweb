<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>My JSP 'BB.jsp' starting page</title>  
  </head>  
  <body >  
 
  <form action="ZhuceServlet"method="post" style="padding-top:200px; text-align:center;">  
   <font face="simhei";>
    <h1>注册新账号</h1>
       输入用户名:<input name="name" type="text"><br><br>  
       输入密码:<input name="pwd" type="password"><br><br>  
       选择性别:<input type="radio"name="sex"value="男"checked>男  
            <input type="radio"name="sex"value="女">女<br><br>  
       选择部门:  
       <select name="dep">  
           <option value="人事部">人事部</option>  
           <option value="销售部" selected>销售部</option>  
           <option value="项目部">项目部</option>  
        </select><br>  
               填写个人信息:<br>  
       <textarea name="info" row="5"cols="30"></textarea><br>  
       <input type="reset"value="重置"><input type="submit"value="注册">  
       </font>
       <a href="<c:url value='/DownloadServlet?path=a.jpg'/>">a.jpg</a><br/>
<a href="<c:url value='/DownloadServlet?path=中国.jpg'/>">中国.jpg</a><br/>
   </form>  
  </body>  
</html> 