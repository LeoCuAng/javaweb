
package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class upload extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //得到工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置缓存大小和目录
        //DiskFileItemFactory factory = new DiskFileItemFactory(20*1024, new File("F:/temp"));

        //创建解析器
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("utf-8");
        //解析之前，设置上传文件大小的限制
        sfu.setFileSizeMax(10*1024);//限制单个文件大小
        sfu.setSizeMax(1024*1024);//限制整个表单数据大小

        try {
            //解析request，得到FileItem集合
            List<FileItem> list = sfu.parseRequest(request);
            FileItem file2 = list.get(1);//文件表单项

            /*
             * 保存文件
             */

            //1.处理文件名绝对路径问题
            String fileName = file2.getName();//获取文件名
            int index = fileName.lastIndexOf("\\");
            if(index != -1){
                fileName = fileName.substring(index+1);
            }

            //2.给文件名加前缀，UUID，防止重名
            String saveName = UUID.randomUUID().toString() + "_" + fileName;

            //3.文件保存到WEB-INF目录下，打散目录
            String root = this.getServletContext().getRealPath("/WEB-INF/uploads/");
            //得到hash code
            int hashCode = fileName.hashCode();
            String hex = Integer.toHexString(hashCode);

            //获得hex的前两个字母，与root连接在一起得到一个完整的路径
            File dirFile = new File(root,hex.charAt(0) + "/" + hex.charAt(1));
            //创建目录链,自动创建整个路径里不存在的文件夹
            dirFile.mkdirs();
            //创建目标文件
            File destFile = new File(dirFile,saveName);

            //保存文件
            file2.write(destFile);

        } catch (FileUploadException e) {
            if(e instanceof FileUploadBase.FileSizeLimitExceededException){
                request.setAttribute("mag", "文件大小超出10K，请重新选择要上传的文件！");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}