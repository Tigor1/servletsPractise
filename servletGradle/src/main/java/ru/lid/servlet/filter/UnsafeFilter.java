package ru.lid.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.lid.servlet.dto.UserDto;

import java.io.IOException;

@WebFilter("/admin")
public class UnsafeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var user = (UserDto) ((HttpServletRequest) request).getSession().getAttribute("user");
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/lid/registration");
        }
    }
}
