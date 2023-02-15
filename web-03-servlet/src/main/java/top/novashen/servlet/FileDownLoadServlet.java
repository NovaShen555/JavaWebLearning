package top.novashen.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET IT");
        //获取文件的路径
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/1.jpeg");
        //设置下载的文件名，使用substring获取
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        System.out.println(realPath);
        System.out.println(fileName);
        //让浏览器识别到这是一个要下载的东西  设置浏览器行为
        response.setHeader("Content-disposition","attachment; filename="+fileName);
        //获取文件的流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //创建缓冲区
        int len;
        byte[] buffer = new byte[1024];
        //获取输出的流
        ServletOutputStream outputStream = response.getOutputStream();
        //将文件流写入缓冲区 固定格式
        while ((len=fileInputStream.read(buffer))!=-1) {
            outputStream.write(buffer,0,len);
        }
        //关闭资源
        fileInputStream.close();
        outputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request,response);
    }
}
