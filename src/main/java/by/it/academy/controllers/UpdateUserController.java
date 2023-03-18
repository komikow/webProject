package by.it.academy.controllers;

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

@WebServlet(urlPatterns = {USER_URL_UPDATE})
public class UpdateUserController extends HttpServlet {
    private UserService userService;
    private UserRepository userRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginToUpdate = req.getParameter(LOGIN_TO_UPDATE);
        String newPassword = req.getParameter(NEW_PASSPORT_TO_UPDATE);
        userService.updateUser(loginToUpdate, newPassword);
        req.getRequestDispatcher(USER_UPDATE_TRUE_PAGE)
                .forward(req, resp);
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
