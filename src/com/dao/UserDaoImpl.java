package com.dao;  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
  
import com.entity.User;  
import com.util.DBconn;  
  
public class UserDaoImpl implements UserDao{  
      
    public boolean register(User user) {  
    	  boolean flag = false;  
          DBconn.init();  
          int i =DBconn.addUpdDel("insert into user(name,pwd,sex,dep,info,pay) " +  
                  "values('"+user.getName()+"','"+user.getPwd()+"','"+user.getSex()+"','"+user.getDep()+"','"+user.getInfo()+"','"+user.getPay()+"')");  
          if(i>0){  
              flag = true;  
          }  
          DBconn.closeConn();  
          return flag;   
    }  
    public boolean login(String name, String pwd) {  
        boolean flag = false;  
        try {  
                DBconn.init();  
                ResultSet rs = DBconn.selectSql("select * from user where name='"+name+"' and pwd='"+pwd+"'");  
                while(rs.next()){  
                    if(rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)){  
                        flag = true;  
                    }  
                }  
                DBconn.closeConn();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return flag;  
    }  
    public List<User> getUserAll() {  
        List<User> list = new ArrayList<User>();  
        try {  
            DBconn.init();  
            ResultSet rs = DBconn.selectSql("select * from user");  
            while(rs.next()){  
                User user = new User();  
                user.setId(rs.getInt("id"));  
                user.setName(rs.getString("name"));  
                user.setPwd(rs.getString("pwd"));  
                user.setSex(rs.getString("sex"));  
                user.setdep(rs.getString("dep"));  
                user.setInfo(rs.getString("info"));
                user.setPay(rs.getString("Pay"));
                list.add(user);  
            }  
            DBconn.closeConn();  
            return list;  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    public boolean update(int id,String name, String pwd,String sex, String dep,String info ,String pay) {  
        boolean flag = false;  
        DBconn.init();  
        String sql ="update user set name ='"+name  
                +"' , pwd ='"+pwd  
                +"' , sex ='"+sex  
                +"' , dep ='"+dep  
                +"' , info ='"+info
                +"' , pay ='"+pay  +"' where id = "+id;  
        int i =DBconn.addUpdDel(sql);  
        if(i>0){  
            flag = true;  
        }  
        DBconn.closeConn();  
        return flag;  
    }  
   
      
 
    public boolean delete(int id) {  
        boolean flag = false;  
        DBconn.init();  
        String sql = "delete  from user where id="+id;  
        int i =DBconn.addUpdDel(sql);  
        if(i>0){  
            flag = true;  
        }  
        DBconn.closeConn();  
        return flag;  
    }  
      
}