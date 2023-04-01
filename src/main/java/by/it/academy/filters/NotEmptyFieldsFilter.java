package by.it.academy.filters;

import by.it.academy.entity.User;
import by.it.academy.repositories.UserRepository;
import by.it.academy.repositories.UserRepositoryImpl;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.services.Constants.*;
import static by.it.academy.services.Utils.similarityCheck;

@WebFilter(urlPatterns = {USERS_URL_CREATE_SERVLET})
public class NotEmptyFieldsFilter extends HttpFilter {
    private UserService userService;
    private UserRepository userRepository;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res,
                            FilterChain chain) throws IOException, ServletException {
        try {
            String firstName = req.getParameter(NAME);
            String secondName = req.getParameter(SURNAME);
            int age = Integer.parseInt(req.getParameter(AGE));
            String login = req.getParameter(LOGIN);
            String password = req.getParameter(PASSWORD);
            User newUser = new User(firstName, secondName, age, login, password);
            if (checkFieldsNewUser(newUser) == NOT_VALIDATE_FIELD) {
                req.getRequestDispatcher(PAGE_ERRORS_FIELDS).forward(req, res);
            } else if
            (ifNotEmptyFieldsNewUser(newUser) == EMPTY_FIELD) {
                req.getRequestDispatcher(ERROR_AUTHORIZATION).forward(req, res);
            } else {
                if (similarityCheck(req, login) == UNIQ_LOGIN) {
                    req.getRequestDispatcher(USERS_URL_CREATE).forward(req, res);
                } else if (similarityCheck(req, login) == NOT_UNIQ_LOGIN) {
                    req.getRequestDispatcher(ERROR_UNIQ_LOGIN).forward(req, res);
                }
            }
        } catch (NumberFormatException e) {
            req.getRequestDispatcher(PAGE_ERRORS_FIELDS).forward(req, res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int ifNotEmptyFieldsNewUser(User user) {
        int isNotEmpty = NOT_EMPTY_FIELD;
        if (user.getFirstName().equals(DOUBLE_QUOTES)
                || user.getFirstName().isEmpty()
                || user.getSecondName().equals(DOUBLE_QUOTES)
                || user.getSecondName().isEmpty()
                || user.getAge() <= 0
                || user.getLogin().equals(DOUBLE_QUOTES)
                || user.getLogin().isEmpty()
                || user.getPassword().equals(DOUBLE_QUOTES)
                || user.getPassword().isEmpty()
        ) {
            isNotEmpty = EMPTY_FIELD;
        }
        return isNotEmpty;
    }

    private int checkFieldsNewUser(User user) {
        int isCorrectField = NULL_VALUE;
        Integer age = user.getAge();
        if ((user.getFirstName() instanceof String)
                && (user.getSecondName() instanceof String)
                && (age instanceof Integer)
                && (user.getLogin() instanceof String)
                && (user.getPassword() instanceof String)) {
            isCorrectField = NOT_NULL_VALUE;
        } else {
            return isCorrectField;
        }
        return isCorrectField;
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        userService = new UserServiceImpl();
        config.getServletContext().setAttribute(USER_SERVICE, userService);
        userRepository = new UserRepositoryImpl();
        config.getServletContext().setAttribute(USER_REPOSITORY, userRepository);
    }
}
