package Domii;

import Domii.connectSql.datasource.DataSource;
import Domii.connectSql.datasource.SqlMashin;
import Domii.connectSql.datasource.SqlWork;
import Domii.connectSql.model.Rellle;
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
public static SqlWork sqlWork =new SqlMashin() {};

    static {
        rooms = new ArrayList<Room>();
        SqlMashin.instans();
    }

    public static void addRoom(Room... room) {
        for (Room room1 : room) {
            rooms.add(room1);
            sqlWork.insertSql(room1);
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
