import Domii.RepMashin;
import Domii.connectSql.model.Rellle;
import Domii.connectSql.model.Room;

import java.util.Arrays;

/**
 * Created by Юра on 09.05.2017.
 */
public class App {
    public static void main(String[] args) {
       // RepMashin.getInstans();

        RepMashin.addRoom(new Room("zal"),new Room("detskay"));


        Room zal=RepMashin.getRoom("zal");
        zal.addRelle(new Rellle("lustraZal"),new Rellle("telikZal"),new Rellle("konder"));
        zal.offRelle("lustraZal");

        Room detsk=RepMashin.getRoom("detskay");
        detsk.addRelle(new Rellle("kompDets"),new Rellle("lustraDetsk"));
        detsk.offRelle("lustraDetsk");

        detsk.onAll();

        System.out.println(Arrays.toString(RepMashin.getAllRoom().toArray()));

        RepMashin.offAllDomii();

        System.out.println(Arrays.toString(RepMashin.getAllRoom().toArray()));
    }
}
