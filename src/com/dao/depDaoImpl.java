package com.dao;  
  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.List;  
  
import com.entity.Dep;  
import com.util.DBconn;  
  
public class depDaoImpl implements depDao{  
      
  public boolean register(Dep dep) {  
        boolean flag = false;  
        DBconn.init();  
        int i =DBconn.addUpdDel("insert into dep(depname,epy,sex,past) " +  
                "values('"+dep.getDepName()+"','"+dep.getEpy()+"','"+dep.getSex()+"','"+dep.getPast()+"')");  
        if(i>0){  
            flag = true;  
        }  
        DBconn.closeConn();  
        return flag;  
    }  
  /* public boolean login(String name, String pwd) {  
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
    } */
    public List<Dep> getDepAll() {  
        List<Dep> list = new ArrayList<Dep>();  
        try {  
            DBconn.init();  
            ResultSet rs = DBconn.selectSql("select * from dep");  
            while(rs.next()){  
            	System.out.println("0000"); 
                Dep dep = new Dep();  
                System.out.println(rs.getString("id"));
                dep.setId(rs.getInt("id"));  
                dep.setDepName(rs.getString("depname"));  
                dep.setEpy(rs.getString("epy"));  
                dep.setSex(rs.getString("sex"));  
                dep.setPast(rs.getString("past")); 
       
                System.out.println("011"); 
                list.add(dep);  
            }  
            DBconn.closeConn();  
            return list;  
        } catch (SQLException e) {  
            e.printStackTrace(); 
           
        }  
        return null;  
    }  
    public boolean update(int id,String depname, String epy,String sex, String past) {  
        boolean flag = false;  
        DBconn.init();  
        String sql ="update Dep set  epy ='"+epy  
        		 +"' ,depname ='"+depname 
                +"' , sex ='"+sex  
                +"' , past ='"+past  
               
                		+ " where id = "+id;  
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
        String sql = "delete  from dep where id="+id;  
        int i =DBconn.addUpdDel(sql);  
        if(i>0){  
            flag = true;  
        }  
        DBconn.closeConn();  
        return flag;  
    }  
      
}