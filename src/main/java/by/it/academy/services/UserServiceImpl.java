package by.it.academy.services;

import by.it.academy.entity.User;
import by.it.academy.repositories.UserRepository;
import by.it.academy.repositories.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository = new UserRepositoryImpl();
        userRepository.createUser(user);
    }

    @Override
    public void deleteUser(String loginToDelete) {
        userRepository = new UserRepositoryImpl();
        userRepository.deleteUser(loginToDelete);
    }

    @Override
    public List<User> readUsers() {
        userRepository = new UserRepositoryImpl();
        return userRepository.readUsers();
    }

    @Override
    public void updateUser(String loginToUpdate, String newPassword) {
        userRepository = new UserRepositoryImpl();
        userRepository.updateUser(loginToUpdate, newPassword);
    }
}
