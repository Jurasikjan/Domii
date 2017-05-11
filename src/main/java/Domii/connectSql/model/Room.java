package Domii.connectSql.model;

import Domii.RepMashin;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юра on 09.05.2017.
 */
@Data
public class Room extends RepMashin{

    private int id;
    private String name;
    private List<Rellle> rele;
private static int colRoom=0;

    public Room() {
    }

    public Room(String name) {
        this.name = name;
        this.rele = new ArrayList<Rellle>();
        id=++colRoom;
    }

    public void addRelle(Rellle... nameRelle)
    {
        for (Rellle s : nameRelle) {
            s.setId_Room(id);
            rele.add(s);
            sqlWork.insertSql(s);
        }

    }

    @Override
    protected void ON(String PriborName) {
        for (Rellle rellle : rele) {
            if (rellle.getPriborName().equals(PriborName)) {
                System.out.print("Room "+name+" ");
                rellle.on();
            }
        }
    }

    @Override
    protected void OFF(String PriborName) {
        for (Rellle rellle : rele) {
            if (rellle.getPriborName().equals(PriborName)) {
                System.out.print("Room "+name+" ");
                rellle.off();
            }
        }
    }

    public void onAll() {
        for (Rellle rellle : rele) {
            rellle.on();
        }
    }

    public void offAll() {
        for (Rellle rellle : rele) {
            rellle.off();
        }
    }

}
