package ru.yandex.fixcolor.test.userdb.dao;

import ru.yandex.fixcolor.test.userdb.dao.domain.User;

import java.util.List;

public interface UserDao {
    List<User> loadAllUsers();
    User loadUserById(Integer userId);
    User loadUserByUserName(String userName);
    Integer storeUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
}
