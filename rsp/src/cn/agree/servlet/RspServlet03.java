package cn.agree.servlet;



import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

@WebServlet(name = "RspServlet03", urlPatterns = "/download")
public class RspServlet03 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到一个请求...");
        //获取参数
        String fileName = req.getParameter("fileName");
        System.out.println("要下载的文件名字:"+fileName);

        // 在文件下载 之前告诉客户端
        String path = "E:\\github_local\\moduleDemoReview\\out\\artifacts\\rsp_war_exploded\\download\\"+fileName;

        // URLEncode编码内容之后URLDecoder能解 除了火狐使用的是Base64编解码之外 其他的浏览器的嗾使URLDecoder

        String agent = req.getHeader("User-Agent");

        if (!agent.contains("Firefox")) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            System.out.println("编码之后的fileName:"+fileName);
        } else {
            fileName = base64Encode(fileName);
        }

        //放在header中的应该是编码过后的字符串
        resp.setHeader("Content-Disposition","attachment;filename="+fileName);


        // 将文件转换成字节输入流
        FileInputStream in = new FileInputStream(path);
      /*  int len = 0;
        byte[] buff = new byte[1024];
        // 输出流
        ServletOutputStream out = resp.getOutputStream();

        while ((len=in.read(buff))!=-1) {
            out.write(buff, 0, len);
        }

        out.close();
        in.close();*/

       // 使用jar包方法完成读写
        ServletOutputStream out = resp.getOutputStream();
        IOUtils.copy(in, out);
        out.close();
        in.close();





    }

    //使用Base64对中文字符串进行编码
    private String base64Encode(String fileName) throws UnsupportedEncodingException {
        Base64.Encoder encoder = Base64.getEncoder();
        fileName = encoder.encodeToString(fileName.getBytes("UTF-8"));
        fileName = "=?utf-8?B?" + fileName + "?=";
        return fileName;
    }
}
