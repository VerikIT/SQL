package org.example.dao;

import org.example.essence.Device;
import org.example.essence.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceServicePostgres implements DeviceDAO {
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String name = "postgres";
    private String pasword = "123123123v";
    private static final String tableName = "devices";

    @Override
    public void create(Device device) {
//insert into  devices values (1,'iphone',361);
        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {

            PreparedStatement statement = connection.prepareStatement("insert into " + tableName + " values (?, ?, ?)");

            statement.setInt(1, device.getUser_id());
            statement.setString(2, device.getDevice_name());
            statement.setInt(3, device.getMAC());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Device> getAll() {
        //select * from devices;
        List<Device> devices = new ArrayList<Device>();
        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {
            PreparedStatement statement = connection.prepareStatement("select * from " + tableName);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Device device = new Device();
                device.setUser_id(rs.getInt(1));
                device.setDevice_name(rs.getString(2));
                device.setMAC(rs.getInt(3));
                devices.add(device);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return devices;
    }

    @Override
    public Device getByMAC(int MAC) {
        //select * from devices where user_id=2;
        Device device = new Device();
        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {
            PreparedStatement statement = connection.prepareStatement("select * from " + tableName + " where MAC=?");
            statement.setInt(1, MAC);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                device.setUser_id(rs.getInt(1));
                device.setDevice_name(rs.getString(2));
                device.setMAC(rs.getInt(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return device;
    }

    @Override
    public void update(Device device) {
        //update users set device_name ='dfdfg', MAC=1234  where user_id=2;
        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {

            PreparedStatement statement = connection.prepareStatement(
                    "update " + tableName + " set user_id=?, device_name =? where MAC=?");

            statement.setInt(1, device.getUser_id());
            statement.setString(2, device.getDevice_name());
            statement.setInt(3, device.getMAC());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeByMAC(int MAC) {
        //delete from devices where id=2;
        try (Connection connection = DriverManager.getConnection(url, name, pasword)) {

            PreparedStatement statement = connection.prepareStatement(
                    "delete from " + tableName + " where MAC=?");

            statement.setInt(1, MAC);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
