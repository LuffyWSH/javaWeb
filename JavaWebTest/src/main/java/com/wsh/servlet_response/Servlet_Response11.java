package com.wsh.servlet_response;

import com.wsh.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

//文件下载
@WebServlet("/Servlet_Response11")
public class Servlet_Response11 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获得请求参数(得到请求的文名字)
        String filename = request.getParameter("filename");

        //2、获得请求文件的真实路径
        ServletContext servletContext = this.getServletContext();//得到servletContext对象
        String realPath = servletContext.getRealPath("/img/"+filename);//获得文件真实路径

        //3、把文件资源加载进内存
        FileInputStream fileInputStream = new FileInputStream(realPath);

        //4、设置response头信息
        String mimeType = servletContext.getMimeType(filename);//得到mimeType
        //设置ContentType
        response.setContentType(mimeType);
        //解决文件名乱码问题
             //获取请求浏览器
             String header = request.getHeader("user-agent");
             //调用工具类
             filename= DownLoadUtils.getFileName(header, filename);
        //设置响应头打开方式
        response.setHeader("content-disposition","attachment;filename="+filename);

        //5、把文件写到浏览器中去
        ServletOutputStream outputStream = response.getOutputStream();
        //读到多少字节写多少
        byte[] b=new byte[1024*1024];
        int len=0;
        while ((len=fileInputStream.read(b))!=-1){
            outputStream.write(b,0,len);
        }
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
