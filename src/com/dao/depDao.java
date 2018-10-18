package com.dao;  
  
import java.util.List;  
  
import com.entity.Dep;  
  
public interface depDao {  
   //public boolean login(String name,String pwd);//登录  
   //public boolean register(Dep dep);//注册  
    public List<Dep> getDepAll();//返回用户信息集合  

    public boolean delete(int id) ;//根据id删除用户  
    public boolean update(int id,String depname, String epy,String sex, String past) ;//更新用户信息  
}
