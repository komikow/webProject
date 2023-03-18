package by.it.academy.controllers;

import by.it.academy.repositories.ProductRepository;
import by.it.academy.repositories.ProductRepositoryImpl;
import by.it.academy.services.ProductService;
import by.it.academy.services.ProductServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.services.Constants.*;

@WebServlet(urlPatterns = {PRODUCT_URL_READ}, loadOnStartup = 0)
public class ReadProductsController extends HttpServlet {
    private ProductService productService;
    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(PRODUCTS, productService.readProducts());
        req.getRequestDispatcher(PRODUCTS_PAGE).forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        productService = (ProductServiceImpl) config
                .getServletContext()
                .getAttribute(PRODUCT_SERVICE);
        productRepository = (ProductRepositoryImpl) config
                .getServletContext()
                .getAttribute(PRODUCT_REPOSITORY);
    }
}
