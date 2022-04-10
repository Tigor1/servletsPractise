package ru.lid.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

//@WebFilter(urlPatterns = "/*")
@WebFilter(servletNames = {
            "RegistrationServlet"
        },
        initParams = {
            @WebInitParam(name = "param1", value = "paramValue1")
        },
        dispatcherTypes = {
            DispatcherType.REQUEST,
            DispatcherType.ASYNC,
            DispatcherType.ERROR,
            DispatcherType.FORWARD,
            DispatcherType.INCLUDE
        }
)
public class CharsetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        chain.doFilter(request, response);
        System.out.println("CharsetFilter");
    }
}
