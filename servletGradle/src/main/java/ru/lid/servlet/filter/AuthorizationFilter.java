package ru.lid.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.lid.servlet.dto.UserDto;
import ru.lid.servlet.util.UrlPath;

import java.io.IOException;
import java.util.Set;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of(UrlPath.LOGIN, UrlPath.REGISTRATION, UrlPath.IMAGES );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var uri = ((HttpServletRequest) request).getRequestURI();

        if (isPublicClass(uri) || isUserLoggedIn(request)) {
            chain.doFilter(request, response);
        } else {
            var previousPage = ((HttpServletRequest) request).getHeader("referer");
            ((HttpServletResponse) response).sendRedirect(previousPage != null ? previousPage : UrlPath.LOGIN);
        }
    }

    private boolean isUserLoggedIn(ServletRequest request) {
        var user = (UserDto) ((HttpServletRequest) request).getSession().getAttribute("user");
        return user != null;
    }

    private boolean isPublicClass(String uri) {
        return PUBLIC_PATH.stream().anyMatch(uri::startsWith);
    }
}
