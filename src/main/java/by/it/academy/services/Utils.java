package by.it.academy.services;

import by.it.academy.repositories.ProductRepository;
import by.it.academy.repositories.ProductRepositoryImpl;
import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import static by.it.academy.services.Constants.PRODUCT_REPOSITORY;
import static by.it.academy.services.Constants.PRODUCT_SERVICE;

public class Utils {
    public static EntityManager entityManager;
    public static EntityTransaction transaction;
    public static ProductService productService;
    public static ProductRepository productRepository;

    public static void add(Object o) {
        entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(o);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void init(ServletConfig config) throws ServletException {
        productService = (ProductServiceImpl) config
                .getServletContext()
                .getAttribute(PRODUCT_SERVICE);
        productRepository = (ProductRepositoryImpl) config
                .getServletContext()
                .getAttribute(PRODUCT_REPOSITORY);
    }
}
