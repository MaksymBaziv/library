package com.max.dao;

import com.max.DBUtils;
import com.max.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements BaseDAO<User> {

    private static UserDAO userDAO = null;
    private Connection connection = DBUtils.getConnection();

    public static UserDAO getInstance() {
        if (userDAO == null)
            userDAO = new UserDAO();

        return userDAO;
    }

    public User findUserByEmail(String email) {
        String select = "SELECT * FROM users where email= ?";
        Connection connection = DBUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1, email);
            preparedStatement.execute();
            User user = new User();
            ResultSet resultSet = preparedStatement.getResultSet();

            if ((resultSet.next())) {
                user.setId(resultSet.getLong("ID"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setZipCode(resultSet.getString("ZIP_CODE"));
                user.setUserRole(resultSet.getString("USER_ROLE"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long save(User user) {
        String sql = "INSERT INTO users (EMAIL, PASSWORD, ZIP_CODE, USER_ROLE) VALUES(?,?,?,?)";
        long id = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getZipCode());
            ps.setString(4, "user");
            if (ps.executeUpdate() > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next())
                    id = rs.getLong(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(long id) {
        String sql = "DELETE from book where id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

}
