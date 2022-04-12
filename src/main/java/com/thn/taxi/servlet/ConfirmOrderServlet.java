package com.thn.taxi.servlet;

import com.thn.taxi.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "confirmOrderServlet", value = "/confirm-order")
public class ConfirmOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("login");
        String placeFrom = req.getParameter("order-from");
        String placeTo = req.getParameter("order-to");

        if (OrderService.makeOrder(login, placeFrom, placeTo)) {
            req.setAttribute("message", "Order was successfully sent");
        } else {
            req.setAttribute("message", "Order was not sent. Try again");
        }
        getServletContext().getRequestDispatcher("/account").forward(req, resp);
    }
}
