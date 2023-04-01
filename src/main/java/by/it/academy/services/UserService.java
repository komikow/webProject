package by.it.academy.services;

import by.it.academy.entity.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    int deleteUser(String loginToDelete);

    List<User> readUsers();

    void updateUser(String loginToUpdate, String newPassword);
}
