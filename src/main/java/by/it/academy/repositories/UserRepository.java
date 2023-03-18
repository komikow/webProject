package by.it.academy.repositories;

import by.it.academy.entity.User;

import java.util.List;

public interface UserRepository {
    void createUser(User user);
//    void createUser(String firstName, String secondName, int age, String login, String password);

    void deleteUser(String loginToDelete);

    List<User> readUsers();

    void updateUser(String loginToUpdate, String newPassword);
}
