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

    private String name;
    private List<Rellle> rele;

    public Room(String name) {
        this.name = name;
        this.rele = new ArrayList<Rellle>();
    }

    public void addRelle(String... nameRelle)
    {
        for (String s : nameRelle) {
            rele.add(new Rellle(s));
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
