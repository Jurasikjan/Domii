package Domii.connectSql.model;

import Domii.Work;
import lombok.Data;

import javax.naming.Name;
import java.util.List;

/**
 * Created by Юра on 09.05.2017.
 */
@Data
public class Rellle extends Room {
    private String priborName;
    private String strUrllOn = "strUrllOn";
    private String strUrllOff = "strUrllOff";
    private int id_Room;
    private boolean status;


    public Rellle(String priborName) {
        super();
        this.priborName = priborName;
    }

    public Rellle(String priborName, String strUrllOn, String strUrllOff) {
        super();
        this.strUrllOff = strUrllOff;
        this.strUrllOn = strUrllOn;
        this.priborName = priborName;

    }

    public void on() {
        status=true;
        System.out.println(priborName + "ON   //" + strUrllOn);
    }

    public void off() {
        status=false;
        System.out.println(priborName + "OFF   //" + strUrllOff);
    }

}
