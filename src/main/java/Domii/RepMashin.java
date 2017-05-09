package Domii;

import Domii.connectSql.datasource.DataSource;
import Domii.connectSql.model.Room;
import lombok.Data;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юра on 09.05.2017.
 */

public abstract class RepMashin implements Work {

    private static List<Room> rooms;
    private static DataSource dataSource;

    static {
        rooms = new ArrayList<Room>();
    }

    private Connection getConnect() {
        return dataSource.getConnection();
    }

    public static void getInstans() {
        dataSource = DataSource.getInstance();
    }

    public static void addRoom(Room... room) {
        for (Room room1 : room) {
            rooms.add(room1);
        }
    }

    public static Room getRoom(String name) {
        Room ret = null;
        for (Room room : rooms) {
            if (room.getName().equals(name)) {
                ret = room;
            }
        }
        return ret;
    }

    public static List<Room> getAllRoom() {
        return rooms;
    }

    public static void onAllDomii(){
        for (Room room : rooms) {
            room.onAll();
        }
    }

    public static void offAllDomii(){
        for (Room room : rooms) {
            room.offAll();
        }
    }

    public void onRelle(String name) {
        ON(name);
    }

    public void offRelle(String name) {
        OFF(name);
    }

    protected abstract void ON(String PriborName);

    protected abstract void OFF(String PriborName);
}
