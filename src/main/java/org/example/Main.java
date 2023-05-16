package org.example;

import org.example.dao.DeviceServicePostgres;
import org.example.dao.UserServicePostgres;
import org.example.essence.Device;
import org.example.essence.User;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user = new User(147, "qwerty", "ytrewq", "+3052354354", "male");
        UserServicePostgres usp = new UserServicePostgres();

        usp.create(user);
        System.out.println(user);
        System.out.println();
        User user2 = usp.getById(147);
        user.setFirst_name("Igor");
        usp.update(user);
        List<User> users = usp.getAll();
        for (var us : users) {
            System.out.println(us);
        }

        usp.removeById(147);
        System.out.println();
        users = usp.getAll();
        for (var us : users) {
            System.out.println(us);
        }
        System.out.println();

        Device device = new Device(2, "iphone", 2256);
        DeviceServicePostgres dsp = new DeviceServicePostgres();
        dsp.create(device);
        System.out.println(device);
        System.out.println();
        Device device2 = dsp.getByMAC(2256);
        device.setDevice_name("samsung");
        dsp.update(device);
        List<Device> devices = dsp.getAll();
        for (var dev : devices) {
            System.out.println(dev);
        }
        dsp.removeByMAC(2256);
        System.out.println();
        devices = dsp.getAll();
        for (var dev : devices) {
            System.out.println(dev);
        }


//        String url="jdbc:postgresql://localhost:5432/postgres";
//        String name="postgres";
//        String pasword ="123123123v";
//
//        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {

//            PreparedStatement statement = connection.prepareStatement("select * from users");
//            var rs = statement.executeQuery();
//            while (rs.next()){
//                System.out.print("first_name="+rs.getString("first_name")+", ");
//                System.out.print("last_name="+rs.getString("last_name")+", ");
//                System.out.print("id="+rs.getInt("id")+".");
//                System.out.println();
//            }


//            PreparedStatement statement = connection.prepareStatement("select first_name from users where id = ?");
//            int id=1;
//            statement.setInt(1,id);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                System.out.println(rs.getString(1));
//            }

//            PreparedStatement statement = connection.prepareStatement("select * from users");
//            ResultSet rs = statement.executeQuery();
//            ResultSetMetaData md = rs.getMetaData();
//            for (int i = 1; i <= md.getColumnCount(); i++) {
//                System.out.print(md.getColumnName(i) + "\t\t"+"  ");
//
//            }
//            System.out.println();
//            while (rs.next()) {
//                for (int i = 1; i <= md.getColumnCount(); i++) {
//                    System.out.print(rs.getString(i) + "\t\t\t");
//                }
//                System.out.println();
//
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


    }
}