package by.it.academy.controllers;

import by.it.academy.entity.User;
import by.it.academy.repositories.UserRepository;
import by.it.academy.repositories.UserRepositoryImpl;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.services.Constants.*;

@WebServlet(urlPatterns = {USERS_URL_CREATE}, loadOnStartup = 0)
public class CreateUserController extends HttpServlet {
    private UserService userService;
    private UserRepository userRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(NAME);
        String secondName = req.getParameter(SURNAME);
        int age = Integer.parseInt(req.getParameter(AGE));
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        User user = new User(firstName, secondName, age, login, password);
        userService.createUser(user);
        req.getRequestDispatcher(PAGES_REGISTRATION_TRUE).forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserServiceImpl) config
                .getServletContext()
                .getAttribute(USER_SERVICE);
        userRepository = (UserRepositoryImpl) config
                .getServletContext()
                .getAttribute(USER_REPOSITORY);
    }
}
