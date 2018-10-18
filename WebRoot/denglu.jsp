<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>登录注册页面</title>  
  
  </head>  
  <body style="background-color:D9DFAA">

</body>
  
  <body > 
     <link href="login.css" rel="stylesheet" type="text/css" /> 
 <STYLE type=text/css><!--body {background-image:url(backpage.gif);background-repeat:no-repeat;background-attachment:fixed;background-position:60% 60%}--> </STYLE>
         <form action="DengluServlet"  method="post"  style="padding-top:-700px;"> 
         <p><font face="verdana">员工信息管理系统</p> 
            用户名：<input type="text" name="name"value=""><br><br>  
             密码：  <input type="password" name="pwd"value=""><br><br>  
                    <input type="submit"value="登录"name="denglu"><input type="reset"value="重置"><br>  
     </form>  
     <form action="zhuce.jsp">  
        <input type="submit"value="新用户注册">  
         </form>  
      
  </body>  
</html>  
