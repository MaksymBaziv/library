package com.max.controller.publisher;

import com.max.controller.BaseServlet;
import com.max.dao.PublisherDAO;
import com.max.model.Publisher;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/savePublisher")
public class PublisherServlet extends BaseServlet {

    PublisherDAO publisherDAO = PublisherDAO.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String phoneNumber = request.getParameter("phoneNumber");

        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setCity(city);
        publisher.setPhoneNumber(phoneNumber);
        publisherDAO.save(publisher);
        response.sendRedirect(request.getContextPath());
    }
}
