package by.tms.project.servlets;

import by.tms.project.exceptions.LoginDuplicateException;
import by.tms.project.exceptions.ParametersNotPassedException;
import by.tms.project.servises.Main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            Main.register(login, password);
            resp.getWriter().println("Аккаунт успешно зарегестрирован.");
        } catch (LoginDuplicateException e) {
           resp.getWriter().println("Данный логин уже занят, попробуйте использовать другой.");
        } catch (ParametersNotPassedException e) {
            resp.getWriter().format("Не передан параметр '%s'", e.getParam());
        }
    }
}
