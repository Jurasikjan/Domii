package Domii.connectSql.datasource;

import Domii.Domii;
import Domii.RepMashin;
import Domii.connectSql.model.Rellle;
import Domii.connectSql.model.Room;
import lombok.Data;

import java.sql.*;
import java.util.List;

/**
 * Created by Юра on 10.05.2017.
 */
@Data
public abstract class SqlMashin implements SqlWork {

    private static DataSource dataSource;
    private final static String CREATE_DATABASE = "CREATE DATABASE /*!32312 IF NOT EXISTS*/ `domii` /*!40100 DEFAULT CHARACTER SET utf8 */;";
    //zaprosi Room
    private final static String NEW_ROOM_TABLE = "CREATE TABLE IF NOT EXISTS " +
            "room(id int AUTO_INCREMENT primary key,name_room varchar(256))";
    private final static String INSERT_Room = "Insert into room (name_room) values (?);";
    //zapr Relle
    private final static String NEW_RELLLE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            "rellle(id int AUTO_INCREMENT primary key,name_relle varchar(256),url_on varchar(256),url_off varchar(256),id_Room int)";
    private final static String INSERT_Rellle = "Insert into rellle (name_relle,url_on,url_off,id_Room) values (?,?,?,?);";
    public static void instans() {

        dataSource = DataSource.getInstance();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
          //  statement.execute(CREATE_DATABASE);
            statement.execute(NEW_ROOM_TABLE);
            statement.execute(NEW_RELLLE_TABLE);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void updateSql(RepMashin mashin) {

    }

    public void deleteSql(RepMashin mashin) {

    }

    public void insertSql(RepMashin mashin) {
        System.out.println("insertSql Class: " + mashin.getClass().getSimpleName());

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = null;
        try {

        switch (mashin.getClass().getSimpleName()) {
            case "Room":
                preparedStatement = connection.prepareStatement(INSERT_Room, Statement.RETURN_GENERATED_KEYS);
                Room room= (Room) mashin;
            preparedStatement.setString(1, room.getName());
                break;
            case "Rellle":
                preparedStatement = connection.prepareStatement(INSERT_Rellle, Statement.RETURN_GENERATED_KEYS);
                Rellle rellle= (Rellle) mashin;
                preparedStatement.setString(1,rellle.getPriborName());
                preparedStatement.setString(2,rellle.getStrUrllOn());
                preparedStatement.setString(3,rellle.getStrUrllOff());
                preparedStatement.setInt(4,rellle.getId_Room());
                break;
        }

            preparedStatement.execute();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setRoomSql(Room room) {

    }

    public Room getRoomSql(String nameRoom) {
        return null;
    }

}
