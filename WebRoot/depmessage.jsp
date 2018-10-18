<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <title>当前部门信息</title>  
  </head>  
    
  <body>  

  <table  width="600" border="1" cellpadding="0" >  
        <tr>  
            <th>ID</th>  
            
            <th>薪酬</th> 
            <th>总人数</th>  
             <th>部门名</th>  
            </tr>  
 
<c:forEach items="${depAll}" var="u"  >
   <form action="Updatedep" method="post">  
     { <tr>  
           
           <td><input type="text" value="${u.id}" name="id"></td>
          
           <td><input type="text" value="${u.epy}" name="epy"></td>
           <td><input type="text" value="${u.sex}" name="sex"></td>
           <td><input type="text" value="${u.past}" name="past"></td>
           <td><a href="Deletedep?id=${u.id}">删除</a>  <input type="submit" value="更新"/></td>  
      <tr> 
     }
   
       
</c:forEach>   
    </table>  
  </body>  
</html>