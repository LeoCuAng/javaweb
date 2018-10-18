    package com.util;  
      
    import java.sql.*;  
      
    public class DBconn {  
        static String url = "jdbc:mysql://localhost:3306/test?useunicuee=true&characterEncoding=utf-8";   
        static String username = "root";   
        static String password = "";   
        static Connection  conn = null;  
        static ResultSet rs = null;  
        static PreparedStatement ps =null;  
        public static void init(){  
            try {  
                Class.forName("com.mysql.jdbc.Driver");  
                conn = DriverManager.getConnection(url,username,password);  
            } catch (Exception e) {  
                System.out.println("init [SQL���������ʼ��ʧ�ܣ�]");  
                e.printStackTrace();  
            }  
        }  
        public static int addUpdDel(String sql){  
            int i = 0;  
            try {  
                PreparedStatement ps =  conn.prepareStatement(sql);  
                i =  ps.executeUpdate();  
            } catch (SQLException e) {  
                System.out.println("sql���ݿ���ɾ���쳣");  
                e.printStackTrace();  
            }  
              
            return i;  
        }
        public static ResultSet selectSql(String sql){  
            try {  
                ps =  conn.prepareStatement(sql);  
                rs =  ps.executeQuery(sql);  
            } catch (SQLException e) {  
                System.out.println("sql���ݿ��ѯ�쳣");  
                e.printStackTrace();  
            }  
            return rs;  
        }  
        public static void closeConn(){  
            try {  
                conn.close();  
            } catch (SQLException e) {  
                System.out.println("sql���ݿ�ر��쳣");  
                e.printStackTrace();  
            }  
        }  
    }  