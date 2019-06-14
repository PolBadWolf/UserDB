package ru.yandex.fixcolor.test.userdb.dao.jdbc;

import ru.yandex.fixcolor.test.userdb.dao.UserDao;
import ru.yandex.fixcolor.test.userdb.dao.domain.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final String SELECT_ALL_SQL = "SELECT id, user_name, password FROM users";
    private static final String SELECT_BY_ID_SQL = "SELECT id, user_name, password FROM users WHERE id=?";
    private static final String SELECT_BY_USER_NAME_SQL = "SELECT id, user_name, password FROM users WHERE user_name=?";
    private static final String INSERT_SQL = "INSERT INTO users(user_name, password) VALUES (?, ?)";
    private static final String UPDATE_SQL = "UPDATE users SET user_name=?, password=? WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM users WHERE id=?";

    @Override
    public List<User> loadAllUsers() {
        return null;
    }

    @Override
    public User loadUserById(Integer userId) {
        return null;
    }

    @Override
    public User loadUserByUserName(String userName) {
        return null;
    }

    @Override
    public Integer storeUser(User user) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(Integer userId) {

    }
}
