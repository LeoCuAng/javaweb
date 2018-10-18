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
    <title>当前用户页面</title>  
     <body style="background-color:D9DFAA">
  </head>  
    
  <body>  
  <h1>${xiaoxi}</h1>  
  <table  width="600" border="1" cellpadding="0" >  
        <tr>  
            <th>ID</th>  
            <th>姓名</th>  
            <th>密码</th> 
            <th>性别</th>  
             <th>部门</th>  
            
            <th>职务</th>  
             <th>薪酬</th>
        
        </tr>  
<c:forEach var="U" items="${userAll}"  >
      <form action="UpdateServlet" method="post">   
      
      { <tr>  
       <td><input type="text" value="${U.id}" name="id" ></td>  
           <td><input type="text" value="${U.name}" name="name"></td>  
           <td><input type="text" value="${U.pwd}" name="pwd"></td>
           <td><input type="text" value="${U.sex}" name="sex"></td>
           <td><input type="text" value="${U.dep}" name="dep"></td>  
           <td><input type="text" value="${U.info}" name="info"></td>
           <td><input type="text" value="${U.pay}" name="pay"></td>   
           <td><a href="DeleteServlet?id=${U.id}">删除</a>  <input type="submit" value="更新"/></td>  
       </tr> } 
      </form> 
    </c:forEach>    
    </table>  
  </body>  
</html>