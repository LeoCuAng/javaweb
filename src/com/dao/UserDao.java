package com.dao;  
  
import java.util.List;  
  
import com.entity.User;  
  
public interface UserDao {  
    public boolean login(String name,String pwd);//��¼  
    public boolean register(User user);//ע��  
    public List<User> getUserAll();//�����û���Ϣ����  
    public boolean delete(int id) ;//����idɾ���û�  
    public boolean update(int id,String name, String pwd,String sex, String dep,String info,String pay) ;//�����û���Ϣ  
}