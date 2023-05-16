package org.example.essence;

public class Device {
  private int  user_id;
    private String  device_name;
    private int MAC;

    public Device(int user_id, String device_name, int MAC) {
        this.user_id = user_id;
        this.device_name = device_name;
        this.MAC = MAC;
    }

    public Device() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public int getMAC() {
        return MAC;
    }

    public void setMAC(int MAC) {
        this.MAC = MAC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (user_id != device.user_id) return false;
        if (MAC != device.MAC) return false;
        return device_name.equals(device.device_name);
    }

    @Override
    public int hashCode() {
        int result = user_id;
        result = 31 * result + device_name.hashCode();
        result = 31 * result + MAC;
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "user_id=" + user_id +
                ", device_name='" + device_name + '\'' +
                ", MAC=" + MAC +
                '}';
    }
}
