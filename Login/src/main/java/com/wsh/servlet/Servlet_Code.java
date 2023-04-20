package com.wsh.servlet;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 画验证码
 */
@WebServlet("/Servlet_Code")
public class Servlet_Code extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、创建对象，表示在内存中的图片
        int width=100;
        int height=50;
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2、美化图片
        Graphics graphics = bufferedImage.getGraphics();//生成画笔
        graphics.setColor(Color.CYAN);//给画笔配置颜色
        graphics.fillRect(0,0,width,height);//用画笔填充矩形框
        graphics.setColor(Color.BLACK);//给画笔配置颜色
        graphics.drawRect(0,0,width-1,height-1);//用画笔给矩形描边框

        //3、生成验证码
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        //定义一个字符串，拼接验证码
        String code="";
        for (int i = 1; i < 5; i++) {
            //生成随机数
            int index = random.nextInt(str.length());
            //根据随机数获取字符串中对应字符
            char ch = str.charAt(index);
            code=code+ch;
            //把字符写到验证码中
            graphics.drawString(ch+"",(width/5)*i,height/2);
        }
        //将code存入session中(因为验证码是及时性东西，不需要长久保存，所以不用自己重写cookies)
        HttpSession session = request.getSession();
        session.setAttribute("code",code);

        //4、画干扰线
        graphics.setColor(Color.ORANGE);//改变画笔颜色
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }

        //5、把图片展示在浏览器中
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
