package com.max.controller.book;

import com.max.controller.BaseServlet;
import com.max.dao.AuthorDAO;
import com.max.dao.BookDAO;
import com.max.dao.PublisherDAO;
import com.max.model.Book;
import com.max.model.dto.UserSessionDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
@WebServlet(urlPatterns = {"/saveBook", "/newBook"})
public class BookServlet extends BaseServlet {

    PublisherDAO publisherDAO = PublisherDAO.getInstance();
    AuthorDAO authorDAO = AuthorDAO.getInstance();
    BookDAO bookDAO = BookDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("authors", authorDAO.findAll());
        request.setAttribute("publishers", publisherDAO.findAll());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/book.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int pages = parseIntegerParameter(request, "pages");
        int yearOfPublication = parseIntegerParameter(request, "yearOfPublication");
        double price = parseIntegerParameter(request, "price");
        long publisherId = parseLongParameter(request, "publisherId");
        long authorId = parseLongParameter(request, "authorId");
        String description = request.getParameter("description");
        Part selectImage = request.getPart("selectImage");

        Book newBook = new Book();
        newBook.setName(name);
        newBook.setPages(pages);
        newBook.setYearOfPublication(yearOfPublication);
        newBook.setPrice(price);
        newBook.setAuthorId(authorId);
        newBook.setPublisherId(publisherId);
        newBook.setDescription(description);
        InputStream imageStream = null;
        if (selectImage != null && selectImage.getSize() > 0) {
            imageStream = selectImage.getInputStream();
        }
        newBook.setImage(imageStream);
        UserSessionDTO loginedUser = (UserSessionDTO) request.getSession().getAttribute("loginedUser");
        newBook.setCreatedBy(loginedUser.getId());
        bookDAO.save(newBook);
        response.sendRedirect(request.getContextPath());
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        bookDAO.deleteById(id);
    }
}
