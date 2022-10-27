package cn.edcheung.javaWebBase.servlet;

import cn.edcheung.javaWebBase.service.UserService;
import cn.edcheung.javaWebBase.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * RegisterServlet
 *
 * @author Edward Cheung
 * 2019/11/3
 */
public class RegisterServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            resp.sendError(404);
        }
        UserService userService = new UserService();
        userService.update(UserService.UpdateType.Insert, username, password, "");
        PrintWriter writer = resp.getWriter();
        writer.print("world");
    }
}
