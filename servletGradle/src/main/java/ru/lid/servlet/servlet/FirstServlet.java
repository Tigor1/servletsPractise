package ru.lid.servlet.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            var header = headerNames.nextElement();
            System.out.println(req.getHeader(header));
        }


        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("token", "12414");
        try (var writer = resp.getWriter()) {
            writer.write("<h1>Hello from first servlet</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var parameterMap = req.getParameterMap();
        System.out.println(parameterMap);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
