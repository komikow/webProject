package by.it.academy.repositories;

import by.it.academy.entity.Product;
import by.it.academy.entity.User;
import by.it.academy.services.Utils;
import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @Override
    public void deleteProduct(String modelToDelete) {
        int id = findIdByModel(modelToDelete);
        entityManager = new JPAUtil().getEntityManager();
        Product product = entityManager.find(Product.class, id);
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void createProduct(Product product) {
        Utils.add(product);
    }

    @Override
    public List<Product> readProducts() {
        entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        List<Product> products = entityManager
                .createQuery("from Product", Product.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return products;
    }

    private int findIdByModel(String modelToDelete) {
        entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        List<Product> products = entityManager
                .createQuery("from Product ", Product.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        int foundProductById = 0;
        for (Product product : products) {
            if (product.getModel().equals(modelToDelete)) {
                foundProductById = product.getProduct_id();
            }
        }
        return foundProductById;
    }

    @Override
    public void updateProduct(String modelToUpdate, int newPrice) {
        entityManager = new JPAUtil().getEntityManager();
        int id = findIdByModel(modelToUpdate);
        transaction = entityManager.getTransaction();
        transaction.begin();
        Product product = entityManager.find(Product.class, id);
        product.setPrice(newPrice);
        entityManager.persist(product);
        transaction.commit();
        entityManager.close();
    }
}
