package com.dao;  
  
import java.util.List;  
  
import com.entity.Dep;  
  
public interface depDao {  
   //public boolean login(String name,String pwd);//��¼  
   //public boolean register(Dep dep);//ע��  
    public List<Dep> getDepAll();//�����û���Ϣ����  

    public boolean delete(int id) ;//����idɾ���û�  
    public boolean update(int id,String depname, String epy,String sex, String past) ;//�����û���Ϣ  
}
