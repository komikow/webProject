package by.it.academy.filters;

import by.it.academy.entity.User;
import by.it.academy.repositories.ProductRepository;
import by.it.academy.repositories.ProductRepositoryImpl;
import by.it.academy.services.ProductService;
import by.it.academy.services.ProductServiceImpl;
import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static by.it.academy.services.Constants.*;

@WebFilter(urlPatterns = {USERS_URL_INPUT})
public class CredentialsFilter extends HttpFilter {

    private ProductService productService;
    private ProductRepository productRepository;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String formLogin = req.getParameter(LOGIN);
        String formPassword = req.getParameter(PASSWORD);
        if (formLogin.isEmpty() || formPassword.isEmpty()) {
            req.getRequestDispatcher(ERROR_AUTHORIZATION).forward(req, res);
        } else if (formLogin.equals(ADMIN_LOGIN) && formPassword.equals(ADMIN_PASSWORD)) {
            req.getRequestDispatcher(ADMIN_PAGE).forward(req, res);
        } else {
            EntityManager entityManager;
            EntityTransaction transaction;
            entityManager = new JPAUtil().getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            TypedQuery<User> userTypedQuery = entityManager
                    .createNamedQuery("getUserByLogin", User.class)
                    .setParameter("userLogin", formLogin);
            Optional<User> optionalUser = userTypedQuery.getResultStream().findFirst();
            User user = optionalUser.orElse(null);
            transaction.commit();
            entityManager.close();
            if (user.getPassword().equals(formPassword)) {
                req.getRequestDispatcher(PRODUCT_URL_READ).forward(req, res);
            } else {
                req.getRequestDispatcher(ERROR_AUTHORIZATION).forward(req, res);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        productService = new ProductServiceImpl();
        config.getServletContext().setAttribute(PRODUCT_SERVICE, productService);
        productRepository = new ProductRepositoryImpl();
        config.getServletContext().setAttribute(PRODUCT_REPOSITORY, productRepository);
    }
}
