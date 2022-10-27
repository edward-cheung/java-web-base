package cn.edcheung.javaWebBase.service;

import cn.edcheung.javaWebBase.utils.DbUtils;
import cn.edcheung.javaWebBase.utils.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserService
 *
 * @author Edward Cheung
 * 2019/11/2
 */
public class UserService {
    public enum UpdateType {
        /**
         * insert
         */
        Insert,
        /**
         * update
         */
        Update,
        /**
         * delete
         */
        Delete;
    }

    public void update(UpdateType type, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DbUtils.getConnection();
            String sql = null;
            switch (type) {
                case Insert:
                    sql = "insert into user (username, password, avatar) values (?, ?, ?)";
                    break;
                case Update:
                    sql = "update user set name = ? where id = ?";
                    break;
                case Delete:
                    sql = "delete from user where id = ?";
                    break;
                default:
                    break;
            }
            if (StringUtils.isEmpty(sql)) {
                return;
            }
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.releaseConnection(connection, preparedStatement, null);
        }
    }

    public String findByUsername(String username) {
        String password = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DbUtils.getConnection();
            String sql = "select password from user where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.releaseConnection(connection, preparedStatement, resultSet);
        }
        return password;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, String>> findById(int id) {
        List userList = new ArrayList(1);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DbUtils.getConnection();
            String sql = "select username, password, avatar from user where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Map<String, String> user = new HashMap<>(4);
                user.put("id", String.valueOf(id));
                user.put("username", String.valueOf(resultSet.getString("username")));
                user.put("password", String.valueOf(resultSet.getString("password")));
                user.put("avatar", String.valueOf(resultSet.getString("avatar")));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.releaseConnection(connection, preparedStatement, resultSet);
        }
        return userList;
    }
}
