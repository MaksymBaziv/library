package com.max.controller.user;

import com.max.controller.BaseServlet;
import com.max.dao.BookDAO;
import com.max.dao.UserDAO;
import com.max.model.User;
import com.max.model.dto.UserSessionDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {
    UserSessionDTO userSessionDTO = UserSessionDTO.getInstance();
    UserDAO userDAO = UserDAO.getInstance();
    BookDAO bookDAO = BookDAO.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");
        request.setAttribute("books", bookDAO.findAll());
        User user = userDAO.findUserByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            HttpSession session = request.getSession();
            user.setPassword(null);
            session.setAttribute("loginedUser", UserSessionDTO.fromUser(user));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/login.jsp?error=true").forward(request, response);
        }
    }

}
