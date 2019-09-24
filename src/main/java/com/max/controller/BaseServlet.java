package com.max.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class BaseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }

    public int parseIntegerParameter(HttpServletRequest request, String name) {
        String parameter = request.getParameter(name);
        try {
            int result = Integer.parseInt(parameter);
            return result;
        } catch (NumberFormatException nfex) {
            return 0;
        }
    }

    public long parseLongParameter(HttpServletRequest request, String name) {
        String parameter = request.getParameter(name);
        try {
            long result = Long.parseLong(parameter);
            return result;
        } catch (NumberFormatException nfex) {
            return 0;
        }
    }

}
