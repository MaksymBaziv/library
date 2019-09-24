package com.max.controller.book;

import com.max.controller.BaseServlet;
import com.max.dao.AuthorDAO;
import com.max.dao.BookDAO;
import com.max.dao.PublisherDAO;
import com.max.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/bookView")
@MultipartConfig
public class BookViewServlet extends BaseServlet {

    PublisherDAO publisherDAO = PublisherDAO.getInstance();
    AuthorDAO authorDAO = AuthorDAO.getInstance();
    BookDAO bookDAO = BookDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("authors", authorDAO.findAll());
        request.setAttribute("publishers", publisherDAO.findAll());
        Book bookById = bookDAO.findById(id);
        if (bookById != null) {
            request.setAttribute("book", bookById);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/bookView.jsp");
            rd.forward(request, response);
        } else {
            response.getWriter().write("No Such Book");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = parseLongParameter(request, "id");
        String name = request.getParameter("name");
        int pages = parseIntegerParameter(request, "pages");
        int yearOfPublication = parseIntegerParameter(request, "yearOfPublication");
        double price = parseIntegerParameter(request, "price");
        long publisherId = parseLongParameter(request, "publisherId");
        long authorId = parseLongParameter(request, "authorId");
        String description = request.getParameter("description");
        Part selectImage = request.getPart("selectImage");

        Book newBook = new Book();
        newBook.setId(id);
        newBook.setName(name);
        newBook.setPages(pages);
        newBook.setYearOfPublication(yearOfPublication);
        newBook.setPrice(price);
        newBook.setAuthorId(authorId);
        newBook.setPublisherId(publisherId);
        newBook.setDescription(description);
        InputStream imageStream = null;
        if (selectImage.getSize() > 0) {
            imageStream = selectImage.getInputStream();
        }
        newBook.setImage(imageStream);
        bookDAO.update(newBook);
        response.sendRedirect(request.getContextPath());
    }
}
