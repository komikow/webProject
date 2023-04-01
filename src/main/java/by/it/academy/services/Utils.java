package by.it.academy.services;

import by.it.academy.entity.Product;
import by.it.academy.entity.User;
import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.it.academy.services.Constants.*;

public class Utils {

    public static void add(Object o) {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(o);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static Product createNewProduct(HttpServletRequest req) {
        String model = req.getParameter(PRODUCT_MODEL);
        String specifications = req.getParameter(PRODUCT_SPECIFICATIONS);
        int guarantee = Integer.parseInt(req.getParameter(PRODUCT_GUARANTEE));
        int price = Integer.parseInt(req.getParameter(PRODUCT_PRICE));
        int quantity = Integer.parseInt(req.getParameter(PRODUCT_QUANTITY));
        Product product = new Product(model, specifications, guarantee, price, quantity);
        return product;
    }

    public static User createNewUser(HttpServletRequest req) {
        String firstName = req.getParameter(NAME);
        String secondName = req.getParameter(SURNAME);
        int age = Integer.parseInt(req.getParameter(AGE));
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        User user = new User(firstName, secondName, age, login, password);
        return user;
    }

    public static void deleteUserByRepository(EntityManager em, EntityTransaction transaction, Object o) {
        transaction = em.getTransaction();
        transaction.begin();
        em.remove(o);
        em.getTransaction().commit();
        em.close();
    }

    public static void updateUserByRepository(EntityManager entityManager, EntityTransaction transaction, Object o) {
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(o);
        transaction.commit();
        entityManager.close();
    }

    public static void addNewProductToDB(EntityManager entityManager, Product product) {
        entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void deleteProductFromDB(EntityManager entityManager, EntityTransaction transaction, Object o) {
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(o);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void addNewUserToDB(Object o) {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(o);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public static int similarityCheck(HttpServletRequest req, String login) {
        int isUniqLogin = UNIQ_LOGIN;
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("from User", User.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                isUniqLogin = NOT_UNIQ_LOGIN;
            }
        }
        return isUniqLogin;
    }
}
