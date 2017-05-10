package Domii.connectSql.datasource;

import Domii.Domii;
import Domii.RepMashin;
import Domii.connectSql.model.Room;
import lombok.Data;

import java.util.List;

/**
 * Created by Юра on 10.05.2017.
 */
@Data
public abstract class SqlMashin implements SqlWork {

    private static DataSource dataSource;

    public static  void instans() {
        SqlMashin.dataSource = DataSource.getInstance();
    }


    public void updateSql(RepMashin mashin) {

    }

    public void deleteSql(RepMashin mashin) {

    }

    public void insertSql(RepMashin mashin){
        System.out.println("Class: "+mashin.getClass().getSimpleName());
    }

    public void setRoomSql(Room room) {

    }

    public Room getRoomSql(String nameRoom) {
        return null;
    }

    public List<RepMashin> getAllRelleSql() {
        return null;
    }

    public List<RepMashin> getAllRoomSql() {
        return null;
    }
}
