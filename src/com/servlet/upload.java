
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

        //�õ�����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //���û����С��Ŀ¼
        //DiskFileItemFactory factory = new DiskFileItemFactory(20*1024, new File("F:/temp"));

        //����������
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("utf-8");
        //����֮ǰ�������ϴ��ļ���С������
        sfu.setFileSizeMax(10*1024);//���Ƶ����ļ���С
        sfu.setSizeMax(1024*1024);//�������������ݴ�С

        try {
            //����request���õ�FileItem����
            List<FileItem> list = sfu.parseRequest(request);
            FileItem file2 = list.get(1);//�ļ�����

            /*
             * �����ļ�
             */

            //1.�����ļ�������·������
            String fileName = file2.getName();//��ȡ�ļ���
            int index = fileName.lastIndexOf("\\");
            if(index != -1){
                fileName = fileName.substring(index+1);
            }

            //2.���ļ�����ǰ׺��UUID����ֹ����
            String saveName = UUID.randomUUID().toString() + "_" + fileName;

            //3.�ļ����浽WEB-INFĿ¼�£���ɢĿ¼
            String root = this.getServletContext().getRealPath("/WEB-INF/uploads/");
            //�õ�hash code
            int hashCode = fileName.hashCode();
            String hex = Integer.toHexString(hashCode);

            //���hex��ǰ������ĸ����root������һ��õ�һ��������·��
            File dirFile = new File(root,hex.charAt(0) + "/" + hex.charAt(1));
            //����Ŀ¼��,�Զ���������·���ﲻ���ڵ��ļ���
            dirFile.mkdirs();
            //����Ŀ���ļ�
            File destFile = new File(dirFile,saveName);

            //�����ļ�
            file2.write(destFile);

        } catch (FileUploadException e) {
            if(e instanceof FileUploadBase.FileSizeLimitExceededException){
                request.setAttribute("mag", "�ļ���С����10K��������ѡ��Ҫ�ϴ����ļ���");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}