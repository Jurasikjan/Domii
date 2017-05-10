package Domii.connectSql.datasource;

import Domii.RepMashin;
import Domii.connectSql.model.Rellle;
import Domii.connectSql.model.Room;

import java.util.List;

/**
 * Created by Юра on 10.05.2017.
 */
public interface SqlWork {
    void updateSql(RepMashin mashin);
    void deleteSql(RepMashin mashin);
    void insertSql(RepMashin mashin);

    void setRoomSql(Room room);
    Room getRoomSql(String nameRoom);

    List<RepMashin> getAllRelleSql();
    List<RepMashin> getAllRoomSql();

}
