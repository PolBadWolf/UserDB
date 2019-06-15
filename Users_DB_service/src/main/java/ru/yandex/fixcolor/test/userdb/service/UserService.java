package ru.yandex.fixcolor.test.userdb.service;

import ru.yandex.fixcolor.test.userdb.dao.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer userId);
    User getUserByUserName(String userName);
    Integer saveUser(User user);
    void deleteUser(Integer userId);
}
