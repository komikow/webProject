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
        Utils.addNewUserToDB(user);
    }

    @Override
    public int deleteUser(String loginToDelete) {
        entityManager = new JPAUtil().getEntityManager();
        int id = findIdByLogin(loginToDelete);
        if (id > 0) {
            User user = entityManager.find(User.class, id);
            Utils.deleteUserByRepository(entityManager, transaction, user);
        } else {
            return id;
        }
        return id;
    }

    @Override
    public void updateUser(String loginToUpdate, String newPassword) {
        entityManager = new JPAUtil().getEntityManager();
        int id = findIdByLogin(loginToUpdate);
        User user = entityManager.find(User.class, id);
        user.setPassword(newPassword);
        Utils.updateUserByRepository(entityManager, transaction, user);
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
