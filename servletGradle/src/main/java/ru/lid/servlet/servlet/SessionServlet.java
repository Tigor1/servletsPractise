package ru.lid.servlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.lid.servlet.dto.UserDto;

import java.io.IOException;

public class SessionServlet extends HttpServlet {

    private static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        var user = (UserDto) session.getAttribute(USER);

        if (user == null) { //первыый запрос от пользователя
            // обычно пользователь устанавливается один раз на странице login приложения по username и password
            user = UserDto.builder()
                    .id(25)
                    .mail("test@gmail.com")
                    .build();
            session.setAttribute(USER, user);
        }
    }
}


