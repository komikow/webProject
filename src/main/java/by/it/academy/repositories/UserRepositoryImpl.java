package by.it.academy.repositories;

import by.it.academy.entity.User;
import by.it.academy.services.Utils;
import by.it.academy.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @Override
    public void createUser(User user) {
        Utils.add(user);
    }

    @Override
    public void deleteUser(String loginToDelete) {
        entityManager = new JPAUtil().getEntityManager();
        int id = findIdByLogin(loginToDelete);
        User user = entityManager.find(User.class, id);
        transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateUser(String loginToUpdate, String newPassword) {
        entityManager = new JPAUtil().getEntityManager();
        int id = findIdByLogin(loginToUpdate);
        transaction = entityManager.getTransaction();
        transaction.begin();
        User user = entityManager.find(User.class, id);
        user.setPassword(newPassword);
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<User> readUsers() {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }

    private int findIdByLogin(String loginToDelete) {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        int foundUserId = 0;
        for (User user : users) {
            if (user.getLogin().equals(loginToDelete)) {
                foundUserId = user.getUser_id();
            }
        }
        return foundUserId;
    }
}
