package ru.yandex.fixcolor.test.userdb.service.impl;

import ru.yandex.fixcolor.test.userdb.dao.UserDao;
import ru.yandex.fixcolor.test.userdb.dao.domain.User;
import ru.yandex.fixcolor.test.userdb.dao.jdbc.UserDaoImpl;
import ru.yandex.fixcolor.test.userdb.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() {
        UserDao userDao = new UserDaoImpl();
        return userDao.loadAllUsers();
    }

    @Override
    public User getUserById(Integer userId) {
        UserDao userDao = new UserDaoImpl();
        return userDao.loadUserById(userId);
    }

    @Override
    public User getUserByUserName(String userName) {
        UserDao userDao = new UserDaoImpl();
        return userDao.loadUserByUserName(userName);
    }

    @Override
    public Integer saveUser(User user) {
        UserDao userDao = new UserDaoImpl();

        if (user.getId() == null) {
            return userDao.storeUser(user);
        }

        userDao.updateUser(user);
        return user.getId();
    }

    @Override
    public void deleteUser(Integer userId) {
        UserDao userDao = new UserDaoImpl();
        userDao.deleteUser(userId);
    }
}
