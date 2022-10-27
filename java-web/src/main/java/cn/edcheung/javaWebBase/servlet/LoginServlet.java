package cn.edcheung.javaWebBase.servlet;

import cn.edcheung.javaWebBase.service.UserService;
import cn.edcheung.javaWebBase.utils.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LoginServlet
 *
 * @author Edward Cheung
 * 2019/11/3
 */
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            resp.sendError(404);
            // resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            throw new RuntimeException();
        }
        UserService userService = new UserService();
        String pwd = userService.findByUsername(username);
        if (StringUtils.isNotEmpty(pwd) && pwd.equals(password)) {
            req.getSession().setAttribute("user", username);
            // 所有Servlet都共享着一个ServletContext对象，所以Servlet之间可以通过ServletContext实现通讯
            ServletContext servletContext = this.getServletConfig().getServletContext();
            Integer globalNum = (Integer) this.getServletContext().getAttribute("num");

            // Servlet之间可以通过ServletContext实现通讯，ServletContext也能称之为域对象。
            // 而request也可以称之为域对象，只不过ServletContext的域是整个web应用，而request的域仅仅代表一次http请求
            Integer localNum = (Integer) req.getServletContext().getAttribute("num");

            ServletOutputStream outputStream = resp.getOutputStream();
            outputStream.print(globalNum + "\t");
            outputStream.write(localNum);
        } else {
            // 获取到资源的路径
            // String path = this.getServletContext().getRealPath("/camera.jpg");

            // 获取到requestDispatcher对象，跳转到index.jsp
            // RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            // 调用requestDispatcher对象的forward()实现转发,传入request和response方法
            // requestDispatcher.forward(req, resp);

            // 转发是由服务器进行跳转的，转发的时候，浏览器的地址栏是没有发生变化的
            // 重定向是由浏览器进行跳转的，进行重定向跳转的时候，浏览器的地址会发生变化的
            // 给服务器用的直接从资源名开始写，给浏览器用的要把应用名写上
            resp.sendRedirect("/");
        }
    }
}
