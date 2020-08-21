package pl.rex89m.MySQL;

import java.sql.SQLException;

public class klasa_test {

    static MySQLConnect mySQLConnect = new MySQLConnect(1, "mokogl_rex", "vipserv.pl", "mokogl_rex","cXS92-y1");
    static MySQLConnect mySQLConnect2 = new MySQLConnect(2, "mokogl_rex", "vipserv.pl", "mokogl_rex","cXS92-y1");

    public static void main(String[] args) {
        System.out.println(mySQLConnect.get("time", "kanaly", "client", "3"));
        System.out.println(mySQLConnect2.get("id", "kanaly", "client", "3"));

        MySQLConnect mySQLConnect3 = new MySQLConnect(1);
        System.out.println(mySQLConnect3.get("time", "kanaly", "client", "3"));
        MySQLConnect mySQLConnect4 = new MySQLConnect(2);
        System.out.println(mySQLConnect4.get("time", "kanaly", "client", "3"));

    }
}
