package com.thn.taxi.servlet;

import com.thn.taxi.service.RegisterUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerUserServlet", value = "/register-user")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login;
        String password;
        String name;
        login = req.getParameter("login");
        password = req.getParameter("password");
        name = req.getParameter("name");

        boolean result = RegisterUserService.registerUser(login, password, name);

        if (result) {
            resp.sendRedirect("/auth");
        } else {
            req.setAttribute("login", login);
            req.setAttribute("name", name);
            req.setAttribute("message", "Something went wrong. Try again");
            getServletContext().getRequestDispatcher("/sign-up").forward(req, resp);
        }
    }
}