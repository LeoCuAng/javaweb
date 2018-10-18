
package com.servlet;  

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import com.dao.depDao;  
import com.dao.depDaoImpl;  
import com.entity.Dep;  
  
public class depall extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request, response);  
    }  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
          
        depDao ud= new depDaoImpl();  
        List<Dep> depAll = ud.getDepAll();  
        request.setAttribute("depAll", depAll); 
        System.out.println("0220"); 
        request.getRequestDispatcher("/depmessage.jsp").forward(request, response);  
    }  
}




