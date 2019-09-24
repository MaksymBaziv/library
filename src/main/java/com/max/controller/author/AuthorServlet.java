package com.max.controller.author;

import com.max.controller.BaseServlet;
import com.max.dao.AuthorDAO;
import com.max.model.Author;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveAuthor")
public class AuthorServlet extends BaseServlet {

    AuthorDAO authorDAO = AuthorDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = parseLongParameter(request, "id");
        Author authorById = authorDAO.findById(id);
        if (authorById != null) {
            request.setAttribute("author", authorById);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/bookEdit.jsp");
            rd.forward(request, response);
        } else {
            response.getWriter().write("No Such Author");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String about = request.getParameter("about");

        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setAbout(about);
        authorDAO.save(author);
        response.sendRedirect(request.getContextPath());
    }
}
