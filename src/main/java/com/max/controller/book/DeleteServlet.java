package com.max.controller.book;

import com.max.controller.BaseServlet;
import com.max.dao.BookDAO;
import com.max.dao.UserDAO;
import com.max.model.Book;
import com.max.model.User;
import com.max.model.dto.UserSessionDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends BaseServlet {
    UserDAO userDAO = UserDAO.getInstance();
    BookDAO bookDAO = BookDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserSessionDTO loginedUser = (UserSessionDTO) request.getSession().getAttribute("loginedUser");
        if (loginedUser != null) {
            User user = userDAO.findUserByEmail(loginedUser.getEmail());
            Long id = Long.parseLong(request.getParameter("id"));
            Book book = bookDAO.findById(id);
            if ("admin".equals(user.getUserRole()) || book.getCreatedBy().equals(user.getId())) {
                bookDAO.deleteById(id);
                response.sendRedirect(request.getContextPath());
            }
        }
    }
}
