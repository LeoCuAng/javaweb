package com.servlet;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import com.dao.depDao;  
import com.dao.depDaoImpl;  
import com.entity.Dep;  
  
public class Updatedep extends HttpServlet {  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request, response);  
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
          
        String id = request.getParameter("id");  
        int DepId = Integer.parseInt(id);  
          
       String depname = request.getParameter("depname");  
  
        String sex = request.getParameter("sex");  
        String epy = request.getParameter("epy");  
       
        String past = request.getParameter("past");
        
          
        System.out.println("------------------------------------"+DepId);  
          
        depDao ud = new depDaoImpl();  
          
        if(ud.update(DepId,depname,sex,epy, past)){  
            request.setAttribute("xiaoxi", "更新成功");  
            request.getRequestDispatcher("/depall").forward(request, response);  
        }else{  
            response.sendRedirect("index.jsp");  
        }  
    }  
}