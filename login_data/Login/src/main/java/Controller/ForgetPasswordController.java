package Controller;

import java.io.IOException;
import Model.User;
import Service.UserService;
import ServiceImplement.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/forget-password")
public class ForgetPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/forget_password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        UserService service = new UserServiceImpl();
        User user = service.get(username);
        String alertMsg = "";
        if (user != null && user.getEmail().equals(email)) {
            // For demo: reset password to "123456" and show message
            service.resetPassword(username, "123456");
            alertMsg = "Mật khẩu đã được đặt lại về 123456. Vui lòng đăng nhập lại.";
        } else {
            alertMsg = "Thông tin không đúng. Vui lòng kiểm tra lại.";
        }
        req.setAttribute("alert", alertMsg);
        req.getRequestDispatcher("/forget_password.jsp").forward(req, resp);
    }
}
