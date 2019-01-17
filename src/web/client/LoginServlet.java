package web.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String wh;//去哪个页面
        BusinessServiceImpl service = new BusinessServiceImpl();
        User user = service.userLogin(username, password);
        if (user == null) {
            String message = String.format(
                    "对不起，用户名或密码有误！！请重新登录！1秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='1;url=%s'",
                    request.getContextPath() + "/welcome.jsp");
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        //登录成功后，就将用户存储到session中
        request.getSession().setAttribute("user", user);
        if (user.isRoot()) {
            wh = "/manager.jsp";
        } else {
            wh = "/client.jsp";
        }
        String message = String.format(
                "恭喜：%s,登陆成功！本页将在1秒后跳转！！<meta http-equiv='refresh' content='1;url=%s'",
                user.getUsername(),
                request.getContextPath() + wh);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/message.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
