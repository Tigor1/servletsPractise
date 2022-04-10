package ru.lid.servlet.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        var requestDispatcher = req.getRequestDispatcher("/flights");
//        или
        var requestDispatcher = getServletContext().getRequestDispatcher("/flights");
//        что-то можем сделать здесь, можем задать аттрибуты req:
        req.setAttribute("attr1", "any object");

        //В include запрос передается в обработку другому servlet после чего возвращается обратно и ответ на запрос будет в этом servlet
        requestDispatcher.include(req, resp);

        resp.getWriter().write("Hello from DispatcherServlet");
        //В forward запрос передается в обработку другому servlet, он в свою очередь сам даст ответ на запрос
//        requestDispatcher.forward(req, resp);
    }
}
