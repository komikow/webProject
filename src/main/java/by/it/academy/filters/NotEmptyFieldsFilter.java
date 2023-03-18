package by.it.academy.filters;

import by.it.academy.entity.User;
import by.it.academy.repositories.UserRepository;
import by.it.academy.repositories.UserRepositoryImpl;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;
import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.it.academy.services.Constants.*;

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
            if (checkFieldsNewUser(newUser) == 0) {
                req.getRequestDispatcher(PAGE_ERRORS_FIELDS).forward(req, res);
            } else if
            (ifNotEmptyFieldsNewUser(newUser) == false) {
                req.getRequestDispatcher(ERROR_AUTHORIZATION).forward(req, res);
            } else {
                EntityManager entityManager = new JPAUtil().getEntityManager();
                entityManager.getTransaction().begin();
                List<User> users = entityManager.createQuery("from User", User.class)
                        .getResultList();
                entityManager.getTransaction().commit();
                entityManager.close();
                for (User user : users) {
                    if (user.getLogin().equals(login)) {
                        req.getRequestDispatcher(ERROR_UNIQ_LOGIN).forward(req, res);
                    } else {
                        req.getRequestDispatcher(USERS_URL_CREATE).forward(req, res);
                    }
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

    private boolean ifNotEmptyFieldsNewUser(User user) {
        boolean isNotEmpty = true;
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
            isNotEmpty = false;
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
