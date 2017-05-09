package Domii.connectSql.model;

import Domii.Work;
import lombok.Data;

import javax.naming.Name;
import java.util.List;

/**
 * Created by Юра on 09.05.2017.
 */
@Data
public class Rellle {
    private String priborName;
    private String strUrllOn = "strUrllOn";
    private String strUrllOff = "strUrllOff";
    private boolean status;


    public Rellle(String priborName) {


        this.priborName = priborName;
    }

    public Rellle(String priborName, String strUrllOn, String strUrllOff) {
        this.strUrllOff = strUrllOff;
        this.strUrllOn = strUrllOn;
        this.priborName = priborName;
    }

    public void on() {
        status=true;
        System.out.println(priborName + "   //" + strUrllOn);
    }

    public void off() {
        status=false;
        System.out.println(priborName + "   //" + strUrllOff);
    }

}
