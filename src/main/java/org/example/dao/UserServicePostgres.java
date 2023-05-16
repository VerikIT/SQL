package org.example.dao;

import org.example.essence.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServicePostgres implements UserDAO {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String name = "postgres";
    private String pasword = "123123123v";
    private static final String tableName = "users";

    @Override
    public void create(User user) {

        //  insert into users values (1, 'Sergey', 'Kvochka', '+380635808081', 'male');

        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {

            PreparedStatement statement = connection.prepareStatement("insert into " + tableName + " values (?, ?, ?, ?, ?)");

            statement.setInt(1, user.getId());
            statement.setString(2, user.getFirst_name());
            statement.setString(3, user.getLast_name());
            statement.setString(4, user.getPhone_number());
            statement.setString(5, user.getGender());
            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
           //select * from users;
        List<User> users = new ArrayList<User>();
        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {
            PreparedStatement statement = connection.prepareStatement("select * from " + tableName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setFirst_name(rs.getString(2));
                user.setLast_name(rs.getString(3));
                user.setPhone_number(rs.getString(4));
                user.setGender(rs.getString(5));
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User getById(int id) {
        //select * from users where id=2;
        User user = new User();
        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {

            PreparedStatement statement = connection.prepareStatement("select * from " + tableName + " where id=?;");

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                user.setId(rs.getInt(1));
                user.setFirst_name(rs.getString(2));
                user.setLast_name(rs.getString(3));
                user.setPhone_number(rs.getString(4));
                user.setGender(rs.getString(5));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


    @Override
    public void update(User user) {
        //update users set first_name ='dfdfg', last_name='sdfgv',phone_number='',gender=''  where id=1;
        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {

            PreparedStatement statement = connection.prepareStatement(
                    "update " + tableName + " set first_name =?, last_name=?,phone_number=?,gender=?  where id=?");

            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.setString(3, user.getPhone_number());
            statement.setString(4, user.getGender());
            statement.setInt(5, user.getId());
            statement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void removeById(int id) {
//delete from users where id=1;
        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {

            PreparedStatement statement = connection.prepareStatement(
                    "delete from " + tableName + " where id=?");

           statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
