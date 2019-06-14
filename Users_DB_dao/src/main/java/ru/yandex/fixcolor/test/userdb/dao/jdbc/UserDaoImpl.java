package ru.yandex.fixcolor.test.userdb.dao.jdbc;

import ru.yandex.fixcolor.test.userdb.dao.UserDao;
import ru.yandex.fixcolor.test.userdb.dao.db.DbPool;
import ru.yandex.fixcolor.test.userdb.dao.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<User> allUsers = new ArrayList<>();

        try {
            connection = DbPool.getPool().getConnection();
            statement = connection.prepareStatement(SELECT_ALL_SQL);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("user_name");
                String password = resultSet.getString("password");

                User user=new User();
                user.setId(id);
                user.setUserName(name);
                user.setPassword(password);

                allUsers.add(user);

                return  allUsers;
            }
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            DbPool.getPool().closeDbResources(connection, statement, resultSet);
            // Урок-5 - Модульный проект в Eclipse IDE при помощи Apache Maven
            // https://www.youtube.com/watch?v=rLbjwEWases
            // 36.11
        }

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
