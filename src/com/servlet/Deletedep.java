package com.servlet;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import com.dao.depDao;  
import com.dao.depDaoImpl;  
  
public class Deletedep extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request, response);  
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
          
        String id = request.getParameter("id");  
        int depId = Integer.parseInt(id);  
          
      depDao uf= new depDaoImpl();  
          
        if(uf.delete(depId)){  
            request.setAttribute("xiaoxi", "É¾³ý³É¹¦");  
            request.getRequestDispatcher("/depall").forward(request, response);  
        }else{  
            response.sendRedirect("index.jsp");  
        }  
    }  
  
}